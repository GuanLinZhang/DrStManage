package cn.drst.dao;

import cn.drst.base.Page;
import cn.drst.util.PageUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 封装DAO层实现类
 *
 * @param <T>
 * @author Administrator
 */
@Repository
public class BaseDaoImpl<T> implements BaseDao<T> {

    private Class<T> entityClass; // 元素真实类
    private final SessionFactory sessionFactory;

    private Class<T> getEntityClass() {
        Type type = this.getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) type;
        entityClass = (Class<T>) pt.getActualTypeArguments()[0];
        return entityClass;
    }

    @Autowired
    public BaseDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(T entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    public void update(T entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    public void updateFieldsByConditions(Map<String, Object> fieldsMap, Map<String, Object> conditionsMap) {
        if (fieldsMap.isEmpty()) {
            return;
        }
        String a = this.getEntityClass().getName();
        StringBuilder sqlBuilder = new StringBuilder("update "
                + this.getEntityClass().getSimpleName() + " set ");
        int i = 0;
        for (Entry<String, Object> fieldName :
                fieldsMap.entrySet()) {
            if (i > 0) {
                sqlBuilder.append(" and ");
            }
            sqlBuilder.append(fieldName.getKey()).append(" =:").append(fieldName.getKey());
            i++;
        }
        sqlBuilder.append(" where ");
        int j = 0;
        for (Entry<String, Object> conditionName :
                conditionsMap.entrySet()) {
            if (j > 0) {
                sqlBuilder.append(" and ");
            }
            sqlBuilder.append(conditionName.getKey()).append(" =:").append(conditionName.getKey());
            j = j + 1;
        }
        HashMap<String, Object> sqlParamMap = new HashMap<String, Object>();
        sqlParamMap.putAll(fieldsMap);
        sqlParamMap.putAll(conditionsMap);
        String hql = sqlBuilder.toString();
        Query query = sessionFactory.getCurrentSession().createSQLQuery(hql);
        for (Entry<String, Object> entry : sqlParamMap.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        query.executeUpdate();
    }

    public void delete(Serializable pkey) {
        T entity = findByPKey(pkey);
        if (entity != null) {
            sessionFactory.getCurrentSession().delete(entity);
        }
    }

    public T findByPKey(Serializable pkey) {
        return (T) sessionFactory.getCurrentSession().get(getEntityClass(), pkey);
    }

    public List<T> findAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(getEntityClass());
        return (List<T>) criteria.list();
    }

    public List<T> findByConditions(Map<String, Object> conditionsMap) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(getEntityClass());
        for (Entry<String, Object> condition : conditionsMap.entrySet()) {
            criteria.add(Restrictions.eq(condition.getKey(), condition.getValue()));
        }
        return (List<T>) criteria.list();
    }

    public List<T> findByConditions(Map<String, Object> conditionsMap, Map<String, Integer> ordersMap) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(getEntityClass());
        for (Entry<String, Object> condition : conditionsMap.entrySet()) {
            criteria.add(Restrictions.eq(condition.getKey(), condition.getValue()));
        }
        for (Entry<String, Integer> orders : ordersMap.entrySet()) {
            switch (orders.getValue()) {
                case 1: // asc
                    criteria.addOrder(Order.asc(orders.getKey()));
                    break;
                case 2: // desc
                    criteria.addOrder(Order.desc(orders.getKey()));
                    break;
                default:
                    break;
            }
        }
        return (List<T>) criteria.list();
    }

    public Map<Page, List<T>> findPagesByCondition(Map<String, Object> conditionsMap, int everyPage, int currentPage, Map<String, Integer> ordersMap) {
        Map<Page, List<T>> map = null;
        if (conditionsMap.isEmpty()) {
            return map;
        }
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(getEntityClass());
        for (Entry<String, Object> condition : conditionsMap.entrySet()) {
            criteria.add(Restrictions.eq(condition.getKey(), condition.getValue()));
        }
        int totalCount = (Integer) criteria.setProjection(Projections.rowCount()).uniqueResult();
        Page page = PageUtil.createPage(everyPage, totalCount, currentPage);
        criteria.setProjection(null);
        for (Entry<String, Integer> orders :
                ordersMap.entrySet()) {
            switch (orders.getValue()) {
                case 1:
                    criteria.addOrder(Order.asc(orders.getKey()));
                    break;
                case 2:
                    criteria.addOrder(Order.desc(orders.getKey()));
                    break;
            }
        }
        criteria.setFirstResult(page.getBeginIndex());
        criteria.setMaxResults(page.getEveryPage());
        List<T> list = criteria.list();
        if (list.size() == 0) {
            return map;
        }
        map = new HashMap<Page, List<T>>();
        map.put(page, list);
        return map;
    }

    public boolean isThereAny(Serializable pkey) {
        T entity = findByPKey(pkey);
        if (entity != null) {
            return true;
        }else{
            return false;
        }
    }

    public String findMaxColumn(String column) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(getEntityClass());
        criteria.setProjection(Projections.max(column));
        return (String)criteria.uniqueResult();
    }

    public List<T> findTablesBySql(String sql){
        return (List<T>) sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(getEntityClass()).list();
    }

    public void evict(T entity) {
        sessionFactory.getCurrentSession().evict(entity);
    }

    // 多表关联使用Criteria查询，测试一直没通过
    public List<T> findTablesByConditions(Map<String, String> tablesMap, Map<String, Object> conditionsMap,
                                          Map<String, Object> joinConditionsMap, Map<String, Integer> ordersMap) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(getEntityClass());
//
//        for (Entry<String, String> table : tablesMap.entrySet()) {
//            criteria.createAlias(table.getKey(), table.getValue());
//        }
//        for (Entry<String, Object> condition : conditionsMap.entrySet()) {
//            criteria.add(Restrictions.eq(condition.getKey(), condition.getValue()));
//        }
//        for (Entry<String, Object> joinConditions : joinConditionsMap.entrySet()) {
//            // ex:Property.forName("u.id").eq(101)
//            //criteria.add(Property.forName(joinConditions.getKey()).eq(joinConditions.getValue()));
//            criteria.add(Restrictions.eq(joinConditions.getKey(), joinConditions.getValue()));
//        }
//        for (Entry<String, Integer> orders : ordersMap.entrySet()) {
//            switch (orders.getValue()) {
//                case 1: // asc
//                    criteria.addOrder(Order.asc(orders.getKey()));
//                    break;
//                case 2: // desc
//                    criteria.addOrder(Order.desc(orders.getKey()));
//                    break;
//                default:
//                    break;
//            }
//        }
        return (List<T>) criteria.list();
    }

}

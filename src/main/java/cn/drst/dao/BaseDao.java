package cn.drst.dao;

import cn.drst.base.Page;
import org.hibernate.Criteria;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/** 封装DAO层通用基本接口类
 * @author gf
 * @param <T>
 */
public interface BaseDao<T> {

    // 保存 @param entity 表实体
    void save(T entity);

    // 全部更新 @param entity 表实体
    void update(T entity);

    // 部分更新
    // @param fieldsMap set更新的字段：String 表字段名，Object 更新字段的值
    // @param conditionsMap where条件的字段：String 表字段名，Object 查询字段的值
    void updateFieldsByConditions(Map<String, Object> fieldsMap,
                                  Map<String, Object> conditionsMap);

    // 主键删除 @param pkey 主键
    void delete(Serializable pkey);

    // 主键查询 @param pkey 主键
    T findByPKey(Serializable pkey);

    // 全查询
    List<T> findAll();

    // 条件查询 无排序
    // @param conditionsMap where条件的字段：String 表字段名，Object 查询字段的值
    List<T> findByConditions(Map<String, Object> conditionsMap);

    // 条件查询 有排序
    // @param conditionsMap where条件的字段：String 表字段名，Object 查询字段的值
    // @param ordersMap order by条件的字段：String 表字段名，Integer 1:ASC,2:DESC
    List<T> findByConditions(Map<String, Object> conditionsMap,
                             Map<String, Integer> ordersMap);

    // 分页查询
    // @param conditionsMap where条件的字段：String 表字段名，Object 查询字段的值
    // @param everyPage 每页显示数量
    // @param currentPage 当前页
    // @param ordersMap order by条件的字段：String 表字段名，Integer 1:ASC,2:DESC
    Map<Page, List<T>> findPagesByCondition(
            Map<String, Object> conditionsMap, int everyPage, int currentPage,
            Map<String, Integer> ordersMap);

    // 主键查询 判断是否存在
    boolean isThereAny(Serializable pkey);

    // 列最大值查询 @param column 列名 @return 最大值
    String findMaxColumn(String column);

    // 通过sql查询
    List<T> findTablesBySql(String sql);

    // 从session缓存(EntityEntries属性)中逐出该对象
    void evict(T entity);

    // 多表关联 条件查询 有排序
    List<T> findTablesByConditions(Map<String, String> tablesMap, Map<String, Object> conditionsMap,
                                          Map<String, Object> joinConditionsMap, Map<String, Integer> ordersMap);

}

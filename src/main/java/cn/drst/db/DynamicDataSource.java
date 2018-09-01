package cn.drst.db;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.stat.DruidDataSourceStatManager;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.sql.DriverManager;
import java.util.Map;
import java.util.Set;

/**
 * @author gf
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private Map<Object, Object> dynamicTargetDataSources;
    private Object dynamicDefaultTargetDataSource;

    @Override
    protected Object determineCurrentLookupKey() {
        String datasource = DBContextHolder.getDataSource();
        if (datasource == null) {
            datasource = "dataSource";
        }
        return datasource;
    }

    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        super.setTargetDataSources(targetDataSources);
        this.dynamicTargetDataSources = targetDataSources;
    }

    @Override
    public void setDefaultTargetDataSource(Object defaultTargetDataSource) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        this.dynamicDefaultTargetDataSource = defaultTargetDataSource;
    }


    // 创建数据源
    public boolean createDataSource(String key, String driveClass, String url, String username, String password) {
        DataSource createDataSource;
        try {
            try { // 排除连接不上的错误
                Class.forName(driveClass);
                DriverManager.getConnection(url, username, password);// 相当于连接数据库
            } catch (Exception e) {
                return false;
            }
            DruidDataSource druidDataSource = new DruidDataSource();
            druidDataSource.setName(key);
            druidDataSource.setDriverClassName(driveClass);
            druidDataSource.setUrl(url);
            druidDataSource.setUsername(username);
            druidDataSource.setPassword(password);
            druidDataSource.setMaxWait(60000);
            druidDataSource.setFilters("stat");
            createDataSource = druidDataSource;
            druidDataSource.init();
            Map<Object, Object> dynamicTargetDataSources2 = this.dynamicTargetDataSources;
            dynamicTargetDataSources2.put(key, createDataSource);// 加入map
            setTargetDataSources(dynamicTargetDataSources2);// 将map赋值给父类的TargetDataSources
            super.afterPropertiesSet();// 将TargetDataSources中的连接信息放入resolvedDataSources管理
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 删除数据源
    public boolean delDatasources(String datasourceid) {
        Map<Object, Object> dynamicTargetDataSources = this.dynamicTargetDataSources;
        if (dynamicTargetDataSources.containsKey(datasourceid)) {
            Set<DruidDataSource> druidDataSourceInstances = DruidDataSourceStatManager.getDruidDataSourceInstances();
            for (DruidDataSource l : druidDataSourceInstances) {
                if (datasourceid.equals(l.getName())) {
                    System.out.println(l);
                    dynamicTargetDataSources.remove(datasourceid);
                    DruidDataSourceStatManager.removeDataSource(l);
                    setTargetDataSources(dynamicTargetDataSources);// 将map赋值给父类的TargetDataSources
                    super.afterPropertiesSet();// 将TargetDataSources中的连接信息放入resolvedDataSources管理
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    // 测试数据源连接是否有效
    public boolean testDatasource(String key, String driveClass, String url, String username, String password) {
        try {
            Class.forName(driveClass);
            DriverManager.getConnection(url, username, password);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public Map<Object, Object> getDynamicTargetDataSources() {
        return dynamicTargetDataSources;
    }

    public void setDynamicTargetDataSources(Map<Object, Object> dynamicTargetDataSources) {
        this.dynamicTargetDataSources = dynamicTargetDataSources;
    }

    public Object getDynamicDefaultTargetDataSource() {
        return dynamicDefaultTargetDataSource;
    }

    public void setDynamicDefaultTargetDataSource(Object dynamicDefaultTargetDataSource) {
        this.dynamicDefaultTargetDataSource = dynamicDefaultTargetDataSource;
    }
}

package spring.boot.dynamicdatasource.conf;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.xa.DruidXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 顷强强 on 2018/3/5.
 */
@Configuration
@MapperScan(value = "spring.boot.dynamicdatasource.dao.mapper", sqlSessionFactoryRef = "sqlSessionFactoryBean")
public class DataSourceConfig {

    @Bean(name = "defaultDB")
    @ConfigurationProperties(prefix = "spring.datasource.default-db") // application.properteis中对应属性的前缀
    public DataSource dataSource1() {
        DataSource build = DataSourceBuilder.create()
//                .type(DruidXADataSource.class)
//                .password("root").username("root")
//                .driverClassName("com.mysql.jdbc.Driver")
//                .url("jdbc:mysql://127.0.0.1/leoao_coach?characterEncoding=UTF-8")
                .build();
        try {
            System.out.println("+++++++"+String.valueOf(build.getConnection()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return build;

    }




    @Bean(name = "logDB")
    @ConfigurationProperties(prefix = "spring.datasource.log-db") // application.properteis中对应属性的前缀
    public DataSource dataSource2() {
        return DataSourceBuilder.create()
//                .type(DruidXADataSource.class)
//                .password("root").username("root")
//                .driverClassName("com.mysql.jdbc.Driver")
//                .url("jdbc:mysql://127.0.0.1/log_test?characterEncoding=UTF-8")
                .build();
    }

    /**
     * 动态数据源: 通过AOP在不同数据源之间动态切换
     * @return
     */
    @Bean(name = "dynamicDS1")
    public DynamicDataSource dataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(dataSource1());

        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap(5);
        dsMap.put("defaultDB", dataSource1());
        dsMap.put("logDB", dataSource2());

        dynamicDataSource.setTargetDataSources(dsMap);

        return dynamicDataSource;
    }


    @Bean
    @Primary
    @Qualifier("sqlSessionFactoryBean")
    public SqlSessionFactory sqlSessionFactoryBean(@Qualifier("dynamicDS1") DynamicDataSource dynamicDS1) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dynamicDS1);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

//    @Bean
//    public DataSourceTransactionManager transactionManager(@Qualifier("dynamicDS1") DynamicDataSource dynamicDS1) {
//        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
//        transactionManager.setDataSource(dynamicDS1);
//        return transactionManager;
//    }
}

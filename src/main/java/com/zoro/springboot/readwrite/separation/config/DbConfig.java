package com.zoro.springboot.readwrite.separation.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.zoro.springboot.readwrite.separation.datasource.DbThreadLocal;
import com.zoro.springboot.readwrite.separation.datasource.DynamicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zoro
 * @version 1.0
 * @date 2020/11/15 21:22
 * @desc
 */

@Configuration
@MapperScan(basePackages = "com.zoro.springboot.readwrite.separation.mapper")
public class DbConfig {

    @Bean
    @ConfigurationProperties(prefix = "master.datasource")
    @Primary
    public DataSource writeDataSource() {
        return new DruidDataSource();
    }
    @Bean
    @ConfigurationProperties(prefix = "slave.datasource")
    public DataSource readDataSource() {
        return new DruidDataSource();
    }

    @Bean
    public AbstractRoutingDataSource routingDataSource() {
        DynamicDataSource dataSource = new DynamicDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>(2);
        targetDataSources.put(DbThreadLocal.WRITE, writeDataSource());
        targetDataSources.put(DbThreadLocal.READ, readDataSource());
        dataSource.setDefaultTargetDataSource(writeDataSource());
        dataSource.setTargetDataSources(targetDataSources);
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(routingDataSource());
        /*sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/*.xml"));*/
        return sessionFactory.getObject();
    }

    @Bean
    public PlatformTransactionManager dataSourceTransactionManager() {
        return new DataSourceTransactionManager(routingDataSource());
    }

}

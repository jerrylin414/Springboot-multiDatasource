package com.lzy.pnaWeb.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.lzy.pnaWeb.mapper.primary",
        sqlSessionFactoryRef = "pSqlSessionFactory")
public class PrimaryConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource dataSource1() {
        // 底层会自动拿到spring.datasource中的配置， 创建一个DruidDataSource
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public SqlSessionFactory pSqlSessionFactory()
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource1());
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:com/lzy/pnaWeb/mapper/primary/*.xml"));
        return sessionFactory.getObject();
    }

    public DataSourceTransactionManager pTransactionManager(){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource1());
        return dataSourceTransactionManager;
    }

    @Bean
    public TransactionTemplate pTransactionTemplate(){
        return new TransactionTemplate(pTransactionManager());
    }
}

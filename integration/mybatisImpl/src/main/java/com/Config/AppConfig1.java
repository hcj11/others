package com.Config;

import com.Mapper.test;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.DefaultLifecycleProcessor;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * mybatis  javaconfig 配置.
 * Created by hcj on 18-7-16.
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"com.Mapper"})
public class AppConfig1 {
  @Bean
  public DefaultLifecycleProcessor getDefaultLifecycleProcessor(){
    DefaultLifecycleProcessor defaultLifecycleProcessor = new DefaultLifecycleProcessor();
     defaultLifecycleProcessor.setTimeoutPerShutdownPhase(10000);
    return defaultLifecycleProcessor;
  }

  @Bean
  public DruidDataSource dataSource() {
    DruidDataSource ds = new DruidDataSource();
    ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
    ds.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8&useSSL=true");
    ds.setUsername("root");
    ds.setPassword("root");
    ds.setInitialSize(5);
    return ds;
  }

  //
  @Bean
  public PlatformTransactionManager dataSourceTransactionManager() {
    return new DataSourceTransactionManager(dataSource());
  }

  @Bean
  public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
    return new SqlSessionTemplate(sqlSessionFactory);
  }

  public static PropertySourcesPlaceholderConfigurer placehodlerConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
  }

  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    sessionFactory.setDataSource(dataSource());

    // 支持通配符加载方式,
    Resource[] resources1 = new PathMatchingResourcePatternResolver()
        .getResources("classpath:bean/*.xml");

    sessionFactory.setMapperLocations(
        resources1
    );
    sessionFactory.setTypeAliasesPackage("com/Domain"); // 扫包
    // 配置路径
    sessionFactory.setConfigLocation(new ClassPathResource("sqlMapConfig.xml"));
    return sessionFactory.getObject();
  }

  //  @Bean
//  public UserMapper userMapper(SqlSessionTemplate sqlSessionTemplate) throws Exception {
//    return sqlSessionTemplate.getMapper(UserMapper.class);
//  }
  // 包扫描
//  @Bean
//  public MapperScannerConfigurer mapperScannerConfigurer() {
//    MapperScannerConfigurer mScannerConfigurer = new MapperScannerConfigurer();
//    mScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
//    mScannerConfigurer.setBasePackage("com/Mapper"); // 扫mapper
//    // 只扫描test.class 类型注解的mapper
//    mScannerConfigurer.setAnnotationClass(test.class);
//    return mScannerConfigurer;
//
//  }

}
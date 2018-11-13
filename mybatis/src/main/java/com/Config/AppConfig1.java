package com.Config;

import com.Mapper.*;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
public class AppConfig1 {

  @Bean
  public DruidDataSource dataSource() {
    DruidDataSource ds = new DruidDataSource();
    ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
    ds.setUrl("jdbc:mysql://localhost:3306/import_server?characterEncoding=utf8&useSSL=true");
    ds.setUsername("root");
    ds.setPassword("root");
    ds.setInitialSize(5);
    return ds;
  }

  //
  @Bean
  public DataSourceTransactionManager dataSourceTransactionManager() {
    return new DataSourceTransactionManager(dataSource());
  }

//  @Bean
//  public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
//    return new SqlSessionTemplate(sqlSessionFactory);
//  }

  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    sessionFactory.setDataSource(dataSource());
    sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
        .getResources("classpath:bean/UserMapper.xml"));
    sessionFactory.setTypeAliasesPackage("com/Domain"); // 扫包
    return sessionFactory.getObject();
  }

  //  @Bean
//  public UserMapper userMapper(SqlSessionTemplate sqlSessionTemplate) throws Exception {
//    return sqlSessionTemplate.getMapper(UserMapper.class);
//  }
  // 包扫描
  @Bean
  public MapperScannerConfigurer mapperScannerConfigurer() {
    MapperScannerConfigurer mScannerConfigurer = new MapperScannerConfigurer();

    mScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
    mScannerConfigurer.setBasePackage("com/Mapper"); // 扫mapper
    // 只扫描test.class 类型注解的mapper
    mScannerConfigurer.setAnnotationClass(test.class);
    return mScannerConfigurer;
  }

}
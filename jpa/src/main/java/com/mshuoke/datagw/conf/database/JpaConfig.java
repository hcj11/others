package com.mshuoke.datagw.conf.database;

import java.util.Properties;
import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
@EnableJpaRepositories(value = {"com.mshuoke.datagw.repository"},entityManagerFactoryRef = "emf")
public class JpaConfig {

  //  @Primary
  @Bean(value = "JpaDataBase")
  public DataSource dataSource() {

//    type: com.zaxxer.hikari.HikariDataSource
//    url: jdbc:mysql://192.168.2.141:3306/import_server?useUnicode=true&characterEncoding=utf8&useSSL=false
//    username: mso
//    password: mso
//    hikari:
//    data-source-properties:
//    cachePrepStmts: true
//    prepStmtCacheSize: 250
//    prepStmtCacheSqlLimit: 2048
//    useServerPrepStmts: true

    BasicDataSource ds = new BasicDataSource();
    ds.setUrl(
        "jdbc:mysql://127.0.0.1:3306/import_server?useUnicode=true&characterEncoding=utf8&useSSL=false");
    ds.setUsername("root");
    ds.setPassword("root");
    return ds;
  }

  //  @Primary
  @Bean
  public LocalContainerEntityManagerFactoryBean emf(
      @Qualifier(value = "JpaDataBase") DataSource dataSource,
      JpaVendorAdapter jpaVendorAdapter) {

    Properties props = new Properties();
    props.setProperty("hibernate.ddl-auto", "update");
    LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
    emf.setDataSource(dataSource);
    emf.setPersistenceUnitName("import_log");
    emf.setJpaVendorAdapter(jpaVendorAdapter);
    emf.setPackagesToScan("com.mshuoke.datagw.domain.pojo");
    emf.setJpaProperties(props);
    return emf;
  }

  //  @Primary
  @Bean
  public JpaVendorAdapter jpaVendorAdapter() {

    HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
    adapter.setDatabase(Database.MYSQL);
    adapter.setShowSql(true);
    adapter.setGenerateDdl(true);
    adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");

    return adapter;
  }

  @Configuration
  @EnableTransactionManagement
  public static class TransactionConfig implements TransactionManagementConfigurer {

    @Inject
    private EntityManagerFactory emf;

    public PlatformTransactionManager annotationDrivenTransactionManager() {
      JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(emf);
      return transactionManager;
    }
  }
}
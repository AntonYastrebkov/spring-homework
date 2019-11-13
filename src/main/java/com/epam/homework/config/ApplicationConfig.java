package com.epam.homework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
// @ComponentScan(basePackages = {"com.epam.homework", "com.epam.security.SecurityService"})
@ImportResource("file:SecurityModule/src/main/resources/configuration.xml")
// @PropertySource(value = "file:src/main/resources/database.properties")
@EnableAspectJAutoProxy
@EnableJpaRepositories(basePackages = "com.epam.homework.dao")
public class ApplicationConfig extends WebMvcConfigurationSupport {

//    @Value("${url}")
//    private String url;
//    @Value("${db.user}")
//    private String username;
//    @Value("${password}")
//    private String password;
//    @Value("file:src/main/resources/schema.sql")
//    private Resource schemaScript;
//
//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
//
//    @Bean
//    public EntityManagerFactory entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean em
//                = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource());
//        em.setPackagesToScan("com.epam.homework.entity");
//
//        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//        em.setJpaProperties(additionalProperties());
//        em.afterPropertiesSet();
//        return em.getNativeEntityManagerFactory();
//    }
//
//    private Properties additionalProperties() {
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
//        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
//
//        return properties;
//    }
//
//    @Bean
//    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
//        return new PersistenceExceptionTranslationPostProcessor();
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory());
//
//        return transactionManager;
//    }
//
////    @Bean
////    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
////        JpaTransactionManager transactionManager = new JpaTransactionManager();
////        transactionManager.setEntityManagerFactory(emf);
////
////        return transactionManager;
////    }
//
////    @Bean
////    public EntityManagerFactory entityManagerFactory() {
////        LocalContainerEntityManagerFactoryBean factoryBean =
////                new LocalContainerEntityManagerFactoryBean();
////        factoryBean.setPersistenceUnitManager(persistanceUnitManger());
////        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
////        factoryBean.setJpaProperties(jpaProperties());
////        factoryBean.afterPropertiesSet();
////        return factoryBean.getNativeEntityManagerFactory();
////    }
////
////    private Properties jpaProperties() {
////        Properties hibernateProp = new Properties();
////        hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
////        hibernateProp.put("hibernate.hbm2ddl.auto", "create-drop");
////        hibernateProp.put("hibernate.format_sql", true);
////        hibernateProp.put("hibernate.use_sql_comments", true);
////        hibernateProp.put("hibernate.show_sql", true);
////        return hibernateProp;
////    }
////
////    private PersistenceUnitManager persistanceUnitManger() {
////        DefaultPersistenceUnitManager unitManager =
////                new DefaultPersistenceUnitManager();
////        unitManager.setPackagesToScan("com.epam.homework.entity");
////        unitManager.setDefaultDataSource(dataSource());
////        return unitManager;
////    }
////
////    private DataSource dataSource() {
////        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
////        dataSource.setDriver(new Driver());
////        dataSource.setUrl(url);
////        dataSource.setUsername(username);
////        dataSource.setPassword(password);
////        return dataSource;
////    }
////
////    @Bean
////    public PlatformTransactionManager transactionManager() {
////        return new JpaTransactionManager(entityManagerFactory());
////    }
//
//    @Bean
//    public DataSource dataSource() {
//        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
//        dataSource.setDriver(new Driver());
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        return dataSource;
//    }

//    @Bean
//    public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
//        final DataSourceInitializer initializer = new DataSourceInitializer();
//        initializer.setDataSource(dataSource);
//        initializer.setDatabasePopulator(databasePopulator());
//        return initializer;
//    }
//
//    @Bean
//    public JdbcTemplate jdbcTemplate() {
//        return new JdbcTemplate(dataSource());
//    }

//    private DatabasePopulator databasePopulator() {
//        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
//        populator.addScript(schemaScript);
//        return populator;
//    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
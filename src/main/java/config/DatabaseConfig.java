package config;

import javax.sql.DataSource;
import org.h2.Driver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
@ComponentScan("config")
@PropertySource("classpath:db.properties")
public class DatabaseConfig {

  @Value("${url}")
  private String url;
  @Value("${username}")
  private String username;
  @Value("${password}")
  private String password;
  @Value("classpath:schema.sql")
  private Resource schemaScript;

  String schema = "classpath:schema.sql";

  @Bean
  public DataSource dataSource() {
    SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
    dataSource.setDriver(new Driver());
    dataSource.setUrl(url);
    dataSource.setUsername("user");
    dataSource.setPassword(password);
    return dataSource;
  }

  @Bean
  public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
    final DataSourceInitializer initializer = new DataSourceInitializer();
    initializer.setDataSource(dataSource);
    initializer.setDatabasePopulator(databasePopulator());
    return initializer;
  }

  @Bean
  public JdbcTemplate jdbcTemplate() {
    return new JdbcTemplate(dataSource());
  }

  private DatabasePopulator databasePopulator() {
    ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
    populator.addScript(schemaScript);
    return populator;
  }
}
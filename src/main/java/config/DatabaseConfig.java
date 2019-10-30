package config;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@PropertySource("classpath:/db.properties")
public class DatabaseConfig {

  @Value("${url}")
  private String url;
  @Value("${username}")
  private String username;
  @Value("${password}")
  private String password;

  @Value("classpath:/schema.sql")
  private Resource schemaScript;

  @Bean
  public DataSource hikariDatasource() {
    HikariDataSource dataSource = new HikariDataSource();
    dataSource.setJdbcUrl(url);
    dataSource.setUsername(username);
    dataSource.setPassword(password);
    dataSource.setMaximumPoolSize(10);
    DatabasePopulatorUtils.execute(databasePopulator(), dataSource);
    return dataSource;
  }

  @Bean
  public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
    final DataSourceInitializer initializer =  new DataSourceInitializer();
    initializer.setDataSource(dataSource);
    initializer.setDatabasePopulator(databasePopulator());
    return initializer;
  }

  @Bean
  public JdbcTemplate jdbcTemplate() {
    return new JdbcTemplate(hikariDatasource());
  }

  private DatabasePopulator databasePopulator() {
    ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
    populator.addScript(schemaScript);
    return  populator;
  }
}
package config;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

@PropertySource("classpath:/db.properties")
public class DatabaseConfig {

  @Value("${url}")
  private String url;
  @Value("${username}")
  private String username;
  @Value("${password}")
  private String password;

  @Bean
  public DataSource hikariDatasource() {
    HikariDataSource hikariDataSource = new HikariDataSource();
    hikariDataSource.setJdbcUrl(url);
    hikariDataSource.setUsername(username);
    hikariDataSource.setPassword(password);
    hikariDataSource.setMaximumPoolSize(10);
    return hikariDataSource;
  }

  @Bean
  public JdbcTemplate jdbcTemplate() {
    return new JdbcTemplate(hikariDatasource());
  }
}
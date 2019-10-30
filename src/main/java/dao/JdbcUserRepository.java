package dao;

import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcUserRepository implements UserRepository {

  String 

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public JdbcUserRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public User saveUser(User user) {
    jdbcTemplate.update("");
    return null;
  }

  @Override
  public User findUserByEmail(String email) {
    return null;
  }

  @Override
  public void subscribe(String userEmail, String promoCode) {

  }
}

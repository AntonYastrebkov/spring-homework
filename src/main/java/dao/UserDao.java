package dao;

import entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserDao {

    User user = new User();

    @Bean
    public User getUser() {
        return user;
    }

    public Long getUserId() {
        return user.getId();
    }

    public String getName() {
        return user.getName();
    }

    public String getPhoneNumber() {
        return user.getPhoneNumber();
    }

    public String getEmail() {
        return user.getEmail();
    }

    public String getPassword() {
        return user.getPassword();
    }
}

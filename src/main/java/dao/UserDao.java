package dao;

import entities.User;

public class UserDao {
    User user = new User();

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

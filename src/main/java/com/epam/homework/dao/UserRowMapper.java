package com.epam.homework.dao;

import com.epam.homework.entity.User;
import com.epam.homework.entity.UserRole;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {

        Long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String email = resultSet.getString("email");
        String phoneNumber = resultSet.getString("phoneNumber");
        String password = resultSet.getString("password");
        String subscription = resultSet.getString("subscription");
        UserRole userRole = UserRole.valueOf(resultSet.getString("userRole"));

        return User.builder()
                .id(id)
                .name(name)
                .email(email)
                .phoneNumber(phoneNumber)
                .password(password)
                .subscription(subscription)
                .userRole(userRole)
                .build();
    }
}

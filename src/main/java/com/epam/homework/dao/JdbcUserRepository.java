package com.epam.homework.dao;

import com.epam.homework.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcUserRepository implements UserRepository {

    String INSERT = "insert into USERS (name, email, phoneNumber, password, subscription, userRole)"
            + " values(?,?,?,?,?,?)";
    String FIND_BY_EMAIL = "select id, name, email, phoneNumber, password,"
            + " subscription, userRole from USERS where email=?";
    String UPDATE_SUBSCRIPTION = "update USERS set subscription=? where email=?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User saveUser(User user) {
        jdbcTemplate.update(INSERT,
                user.getName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getPassword(),
                user.getSubscription(),
                user.getUserRole().name());
        return user;
    }

    @Override
    public User findUserByEmail(String email) {
        return jdbcTemplate.queryForObject(FIND_BY_EMAIL, new UserRowMapper(), email);
    }

    @Override
    public void subscribe(String userEmail, String promoCode) {
        jdbcTemplate.update(UPDATE_SUBSCRIPTION, promoCode, userEmail);
    }


}
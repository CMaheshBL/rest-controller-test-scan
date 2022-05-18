package com.rest.controller.test.dao;

import com.rest.controller.test.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Repository
public class UserDao implements IUserDao {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public boolean insertUser(User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource namedParameters = new MapSqlParameterSource
                ("password", user.getPassword())
                .addValue("first_name", user.getFirstName())
                .addValue("email", user.getEmail())
                .addValue("info", user.getInfo());
        int update = jdbcTemplate.update(INSERT_USER, namedParameters, keyHolder, new String[]{"id"});
        user.setId(keyHolder.getKey().longValue());
        return update > 0;
    }
}

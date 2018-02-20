/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.contactlistmvc.dao;

/**
 *
 * @author mgaffney
 */
import com.thesoftwareguild.contactlistmvc.dto.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserDaoDbImpl implements UserDao {
    // #1 - We need to update both the users and authorities tables

    private static final String SQL_INSERT_USER
            = "insert into users (username, password, enabled) values (?, ?, 1)";
    private static final String SQL_INSERT_AUTHORITY
            = "insert into authorities (username, authority) values (?, ?)";
    private static final String SQL_DELETE_USER
            = "delete from users where username = ?";
    private static final String SQL_DELETE_AUTHORITIES
            = "delete from authorities where username = ?";
    private static final String SQL_GET_ALL_USERS
            = "select username, password from users";
    private static final String SQL_GET_AUTHORITIES
            = "select authority from authorities where username = ?";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User addUser(User newUser) {
        // #2 - First insert user data into the users table and then insert data into
        // the authorities table (failing to do so will result in foreign key
        // constraint errors)
        jdbcTemplate.update(SQL_INSERT_USER, newUser.getUsername(), newUser.getPassword());

        // now insert user's roles
        List<String> authorities = newUser.getAuthorities();
        for (String authority : authorities) {
            jdbcTemplate.update(SQL_INSERT_AUTHORITY, newUser.getUsername(), authority);
        }

        return newUser;
    }

    @Override
    public void deleteUser(String username) {
        // #3 - First delete all authorities for this user
        jdbcTemplate.update(SQL_DELETE_AUTHORITIES, username);
        // #3 - Second delete the user - failing to do so will result in foreign
        // key constraint errors
        jdbcTemplate.update(SQL_DELETE_USER, username);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        users = jdbcTemplate.query(SQL_GET_ALL_USERS, new UserMapper());
        
        for(User u: users) {
            u.setAuthorities(jdbcTemplate.query(SQL_GET_AUTHORITIES
                    , new AuthorityMapper()
                    , u.getUsername()));
        }
        
        return users;
    }

    private class UserMapper implements RowMapper<User> {

        public User mapRow(ResultSet rs, int i) throws SQLException {
            User u = new User();
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            return u;
        }
    }

    private class AuthorityMapper implements RowMapper<String> {

        public String mapRow(ResultSet rs, int i) throws SQLException {
            return rs.getString("authority");
        }
    }
}
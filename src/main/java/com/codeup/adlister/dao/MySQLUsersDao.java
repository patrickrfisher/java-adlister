package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;
//import sun.security.krb5.Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUsersDao implements Users {
    private Connection connection = null;
    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public User findByUsername(String email) {
        String sql = "SELECT * FROM users WHERE email LIKE ?";
        String searchTermWithWildcards = "%" + email + "%";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, searchTermWithWildcards);
            ResultSet rs = stmt.executeQuery();
            rs.next();
                return new User(rs.getLong("id"),rs.getString("email"),rs.getString("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Long insert(User user) {
        String insertQuery="insert into users(email,password) values (?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(insertQuery,Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1,user.getEmail());
            stmt.setString(2,user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }
}

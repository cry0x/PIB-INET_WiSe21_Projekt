package com.forum.dao;

import com.forum.db.DatabaseConnection;
import com.forum.object.User;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("PostgresUserRepository")
public class UserRepositoryPostgres implements UserRepository {

    @Override
    public User selectUserById(int id) {
        try {
            String sql = String.format("SELECT * FROM users WHERE id = %s", id);
            ResultSet resultSet = DatabaseConnection.executeQuery(sql);

            if (resultSet.next()) {
                return new User(resultSet.getInt("id"),
                        resultSet.getString("lastname"),
                        resultSet.getString("firstname"),
                        resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();

        try {
            String sql = "SELECT * FROM users";
            ResultSet resultSet = DatabaseConnection.executeQuery(sql);

            while(resultSet.next()) {
                User user = new User(resultSet.getInt("id"),
                        resultSet.getString("lastname"),
                        resultSet.getString("firstname"),
                        resultSet.getString("email"));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public int addUser(User user) {
        try {
            String sql = String.format("INSERT INTO users(lastname, firstname, email) VALUES('%s', '%s', '%s')",
                    user.getLastname(),
                    user.getFirstname(),
                    user.getEmail());
            PreparedStatement preparedStatement = DatabaseConnection.preparedStatement(sql);

            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        return -1;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }
}

package forum.dao;

import forum.db.DatabaseConnection;
import forum.object.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    public UserRepositoryImpl() {
    }

    @Override
    public User getUserById(int id) {
        User user = new User();

        try {
            String sql = String.format("SELECT * FROM users WHERE id = %s", id);
            ResultSet resultSet = DatabaseConnection.executeQuery(sql);

            if (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setLastname(resultSet.getString("lastname"));
                user.setFirstname(resultSet.getString("firstname"));
                user.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();

        try {
            String sql = "SELECT * FROM users";
            ResultSet resultSet = DatabaseConnection.executeQuery(sql);

            while(resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLastname(resultSet.getString("lastname"));
                user.setFirstname(resultSet.getString("firstname"));
                user.setEmail(resultSet.getString("email"));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public void add(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }
}

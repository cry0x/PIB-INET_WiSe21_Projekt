package forum.db;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;

public class DatabaseConnection {

    private static Connection openConnection() throws SQLException {
        String dbUrl = "jdbc:postgresql://192.168.100.174:8081/forum";
        BasicDataSource connectionPool = new BasicDataSource();
        connectionPool.setUsername("root");
        connectionPool.setPassword("root");
        connectionPool.setDriverClassName("org.postgresql.Driver");
        connectionPool.setUrl(dbUrl);
        connectionPool.setInitialSize(1);

        return connectionPool.getConnection();
    }

    public static ResultSet executeQuery(String sql) throws SQLException {
        return openConnection().prepareStatement(sql).executeQuery();
    }
}

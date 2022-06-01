package repository.impl;

import connection.DBConnect;
import model.Users;
import repository.IUsersRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersRerositoryImpl implements IUsersRepository {
    private DBConnect dbConnect = new DBConnect();

    private static final String INSERT_USERS_SQL = "INSERT INTO users (name, country) VALUES (?, ?);";
    private static final String SELECT_USER_BY_COUNTRY = "select * from users where country like ?;";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?, country =? where id = ?;";
    private static final String SORT_BY_NAME = "SELECT * FROM user_manager.users order by `name`;";


    @Override
    public List<Users> getAllUsers() {
        List<Users> users = new ArrayList<>();
        Connection connection = dbConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String country = rs.getString("country");
                users.add(new Users(id, name, country));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    @Override
    public void saveUsers(Users users) {
        Connection connection = dbConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, users.getName());
            preparedStatement.setString(2, users.getCountry());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void deleteUser(int id) {
        Connection connection = dbConnect.getConnection();
        try {
            System.err.println("a");
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void editUser(int id, String name, String country) {
        Connection connection = dbConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, country);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public List<Users> searchByCountry(String searchValue) {
        List<Users> users = new ArrayList<>();
        Connection connection = dbConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_COUNTRY);
            preparedStatement.setString(1, "%" + searchValue + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String country = resultSet.getString("country");
                users.add(new Users(id, name, country));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<Users> sortByName() {
        List<Users> users = new ArrayList<>();
        Connection connection = dbConnect.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SORT_BY_NAME);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String country = resultSet.getString("country");
                users.add(new Users(id, name, country));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}

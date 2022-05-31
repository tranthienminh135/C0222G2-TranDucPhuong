package repository;

public class UserRepositoryImpl implements IUserRepository{
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "135233";

    private static final String INSERT_USERS_SQL = "INSERT INTO users (name, age) VALUES (?, ?);";
    private static final String SELECT_USER_BY_ID = "select id,name,age from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, age =? where id = ?;";
    
}

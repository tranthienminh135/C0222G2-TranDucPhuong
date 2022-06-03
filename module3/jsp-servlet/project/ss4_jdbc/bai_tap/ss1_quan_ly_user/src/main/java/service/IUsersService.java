package service;

import model.Users;

import java.util.List;

public interface IUsersService {
    List<Users> getAllUsers();

    void saveUsers(Users user);

    void deleteUser(int id);

    void editUser(int id, String name, String country);

    List<Users> searchByCountry(String searchValue);
}

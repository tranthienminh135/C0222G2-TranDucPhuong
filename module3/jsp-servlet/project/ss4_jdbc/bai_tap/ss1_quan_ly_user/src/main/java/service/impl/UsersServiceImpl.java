package service.impl;

import model.Users;
import repository.IUsersRepository;
import repository.impl.UsersRerositoryImpl;
import service.IUsersService;

import java.util.List;

public class UsersServiceImpl implements IUsersService {
    private IUsersRepository usersRepository = new UsersRerositoryImpl();

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.getAllUsers();
    }

    @Override
    public void saveUsers(Users user) {
        usersRepository.saveUsers(user);
    }

    @Override
    public void deleteUser(int id) {
        usersRepository.deleteUser(id);
    }

    @Override
    public void editUser(int id, String name, String country) {
        usersRepository.editUser(id, name, country);
    }

    @Override
    public List<Users> searchByCountry(String searchValue) {
        return usersRepository.searchByCountry(searchValue);
    }

    @Override
    public List<Users> sortByName() {
        return usersRepository.sortByName();
    }
}

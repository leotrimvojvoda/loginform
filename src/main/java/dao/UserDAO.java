package dao;

import entity.User;

import java.util.List;

public interface UserDAO {

    void addUser(User user);

    User getUserByEmail(String email);

    User getUserByID(int id);

    List<User> getAllUsers();

    void updateUser(User user);

    void deleteUser(User user);

}

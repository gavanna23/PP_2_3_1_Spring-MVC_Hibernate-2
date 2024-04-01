package web.userDao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void addUser(User user);

    void deleteUser(int id);

    void updateUser(int id, User updateUser);

}

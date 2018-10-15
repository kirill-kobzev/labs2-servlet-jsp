package servlets.dao;

import servlets.pojo.User;

public interface UserDao {
    boolean addUser(String login, String password);
    User getUserByLogin(String login);
}

package dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public void insertUser(User user) throws SQLException;

    public User selectUser(int id);

    public List<User> selectUserByCountry(String nameCountrySearch);

    public List<User> selectAllUsers();

    public List<User> selectAllUsersNameASC();

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(User user) throws SQLException;

    public User getUserById(int id);

    public void insertUserStore(User user);

    User getUserByIDStore(int id);

    boolean updateUserByIDStore(User user);

    boolean deleteUserByIDStore(int id) throws SQLException;
}

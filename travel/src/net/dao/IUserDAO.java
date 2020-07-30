package net.dao;
import net.beans.user;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    user selectUserLogin(String name, String pass) throws SQLException;
    user getUserInformationByID(int UID)throws SQLException;
    int insertUser(user user) throws SQLException;
    List<user> getMyFriend(int UID) throws SQLException;
}

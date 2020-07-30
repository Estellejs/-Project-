package net.service;

import net.beans.user;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    user checkUser(String name, String pass);
    int saveUser(user user);
    List<user> getMyFriend(int UID);
    user getUserInformationByID(int UID);
}

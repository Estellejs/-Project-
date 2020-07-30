package net.service;

import net.beans.user;
import net.dao.IUserDAO;
import net.dao.userDaoImpl;

import java.sql.SQLException;
import java.util.List;

public class userServiceImpl implements IUserService  {

    private IUserDAO dao;
    public userServiceImpl(){
        dao=new userDaoImpl();
    }
    @Override
    public user checkUser(String name,String pass) {
        try {
            return dao.selectUserLogin(name,pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    @Override
    public int saveUser(user user){
        try {
            return dao.insertUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<user> getMyFriend(int UID) {
        try {
            return dao.getMyFriend(UID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public user getUserInformationByID(int UID) {
        try {
            return dao.getUserInformationByID(UID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

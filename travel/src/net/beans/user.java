package net.beans;

import java.util.Date;

public class user {
    private int UID;
    private String Email;
    private String UserName;
    private String Pass;
    private int State;
    private Date DateJoined;
    private Date DateLastModified;

    public user(){
        super();
    }
    public user(String Email, String userName, String Pass, Date dateLastModified){
        this.Email=Email;
        this.Pass=Pass;
        this.UserName=userName;
    }


    public int getUID() {
        return UID;
    }

    public Date getDateJoined() {
        return DateJoined;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public int getState() {
        return State;
    }

    public void setState(int state) {
        State = state;
    }

    public void setDateJoined(Date dateJoined) {
        DateJoined = dateJoined;
    }

    public Date getDateLastModified() {
        return DateLastModified;
    }

    public void setDateLastModified(Date dateLastModified) {
        DateLastModified = dateLastModified;
    }
}

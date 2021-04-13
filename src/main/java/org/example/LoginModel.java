package org.example;
import java.security.MessageDigest;

public class LoginModel {

    private String username, password;


    public LoginModel(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean validateLogin(){

        LoginValidator loginValidator = new LoginValidator();

        return loginValidator.queryLoginDatabase(username, password);
    }
}

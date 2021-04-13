package org.example;

import com.opensymphony.xwork2.ActionSupport;

public class LoginActivity extends ActionSupport {

    private String username, password;

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

    public String execute(){
        LoginModel loginModel = new LoginModel(username, password);

        if(loginModel.validateLogin()){
            return SUCCESS;
        }
        else {
            System.out.println("WTF");
            return ERROR;
        }
    }




}

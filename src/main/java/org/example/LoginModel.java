package org.example;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class LoginModel {

    private String username, password;


    public LoginModel(String username, String password)
    {
        this.username = username;
        this.password = hashPassword(password);
        System.out.println(this.password);
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

    // Hash password before validating in the database
    public String hashPassword(String inputPassword)
    {
        try
        {
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            byte[] hashedPassword = md.digest(inputPassword.getBytes(StandardCharsets.UTF_8));
            return toHexString(hashedPassword);
        }catch(Exception ex){
            System.out.println("HERE ERROR:" + ex);
        }
        return "";
    }
    // Convert Hex to String
    public static String toHexString(byte[] hash)
    {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 32)
        {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }
}

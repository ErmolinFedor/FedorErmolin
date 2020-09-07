package hw5.beans;

import java.util.Locale;
import java.util.ResourceBundle;

public class User {
    private String name;
    private String login;
    private String password;

    public User(String name) {
        this.name = name;
        ResourceBundle resourceBundle = ResourceBundle.getBundle(name, Locale.ENGLISH);
        login = resourceBundle.getString("login");
        password = resourceBundle.getString("password");
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}

package main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String Login;
    private String password;

    public long getId() {
        return id;
    }

    public UserAccount setId(long id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return Login;
    }

    public UserAccount setLogin(String login) {
        Login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserAccount setPassword(String password) {
        this.password = password;
        return this;
    }
}

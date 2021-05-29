package main.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.File;

@Entity
public class UserQueries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String login;
    private File photo;
    @Column(columnDefinition = "varchar(5000)")
    private String text;

    public UserQueries(long id , String login , File photo , String text) {
        this.id = id;
        this.login = login;
        this.photo = photo;
        this.text = text;
    }

    public UserQueries() {
    }

    public long getId() {
        return id;
    }

    public UserQueries setId(long id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public UserQueries setLogin(String login) {
        this.login = login;
        return this;
    }

    public File getPhoto() {
        return photo;
    }

    public UserQueries setPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    public String getText() {
        return text;
    }

    public UserQueries setText(String text) {
        this.text = text;
        return this;
    }
}

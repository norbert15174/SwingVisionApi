package main.entity;

import javax.persistence.*;
import java.sql.Blob;

@Entity
public class UserQueries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String login;
    @Lob
    @Column(columnDefinition="LONGBLOB")
    private Blob photo;
    @Column(columnDefinition = "varchar(5000)")
    private String text;
    private String fileName;

    public UserQueries() {
    }

    public UserQueries(long id , String login , String text , String fileName) {
        this.id = id;
        this.login = login;
        this.text = text;
        this.fileName = fileName;
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

    public Blob getPhoto() {
        return photo;
    }

    public UserQueries setPhoto(Blob photo) {
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

    public String getFileName() {
        return fileName;
    }

    public UserQueries setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }
}

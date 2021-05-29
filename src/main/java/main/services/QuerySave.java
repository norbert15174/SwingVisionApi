package main.services;

import main.GUI.AppGUI;
import main.entity.UserAccount;
import main.entity.UserQueries;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

import static main.GUI.GUI.jf;


public class QuerySave {
    public static boolean querySave(String login, String text, File file){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(UserQueries.class);
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.getCurrentSession();
        UserQueries querySave = new UserQueries();
        querySave.setLogin(login);
        querySave.setText(text);
        querySave.setPhoto(file);
        session.beginTransaction();
        session.save(querySave);
        session.getTransaction().commit();
        factory.close();
        return true;
    }
}

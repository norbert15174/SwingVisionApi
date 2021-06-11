package main.services;

import main.Main;
import main.entity.UserQueries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.sql.rowset.serial.SerialBlob;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;


public class QuerySave {
    private static Logger logger = LogManager.getLogger(QuerySave.class);
    public static boolean querySave(String login, String text, File file) throws IOException, SQLException {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(UserQueries.class);
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.getCurrentSession();
        UserQueries querySave = new UserQueries();
        querySave.setLogin(login);
        querySave.setText(text);
        querySave.setPhoto(new SerialBlob(Files.readAllBytes(file.toPath())));
        querySave.setFileName(file.getName());
        session.beginTransaction();
        session.save(querySave);
        session.getTransaction().commit();
        factory.close();
        logger.info("Item has been added");
        return true;
    }
}

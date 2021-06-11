package main.services;

import main.GUI.AppGUI;
import main.GUI.GUI;
import main.entity.UserAccount;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import javax.swing.*;
import java.awt.*;
import java.util.List;




public class Login {

    public static String account;
    private static Logger logger = LogManager.getLogger(Login.class);
    public static boolean loginToApp(String login, String password){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(UserAccount.class);
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        String query = "FROM UserAccount WHERE login='" + login +"'";
        Query queryToSave = session.createQuery(query);
        List <UserAccount> user = queryToSave.getResultList();
        session.getTransaction().commit();
        factory.close();
        if(user.isEmpty()){
            if(!Register.registerToApp(login,password)){
                logger.error("Account couldn't be registered");
                return false;
            }
            GUI.jf.setVisible(false);
            account = login;
            AppGUI.startApp();
            logger.info("New account has been added!");
            return true;
        }
        if(user.get(0).getLogin().matches(login) && user.get(0).getPassword().matches(password)){
            GUI.jf.setVisible(false);
            account = login;
            AppGUI.startApp();
            logger.info("Login properly!");
            return true;
        }else{
            logger.info("Wrong password!");
            GUI.wrong.setText("WRONG PASSWORD");
            GUI.jf.validate();
            return false;
        }

    }
}

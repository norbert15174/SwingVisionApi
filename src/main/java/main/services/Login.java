package main.services;

import main.GUI.AppGUI;
import main.entity.UserAccount;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static main.GUI.GUI.jf;


public class Login {
    public static boolean loginToApp(String login, String password){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(UserAccount.class);
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        UserAccount user = session.get(UserAccount.class,1L);
        session.getTransaction().commit();
        factory.close();
        if(user.getLogin().matches(login) && user.getPassword().matches(password)){
            jf.setVisible(false);
            AppGUI.startApp();
        }
        return false;
    }
}

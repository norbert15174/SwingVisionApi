package main.services;

import main.entity.UserAccount;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Register {
    private static Logger logger = LogManager.getLogger(Register.class);
    public static boolean registerToApp(String login, String password){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(UserAccount.class);
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.getCurrentSession();
        UserAccount user = new UserAccount();
        user.setLogin(login);
        user.setPassword(password);
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        factory.close();
        logger.info("Account has been registered!");
        return true;
    }
}

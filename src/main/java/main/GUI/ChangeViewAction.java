package main.GUI;


import main.entity.UserAccount;
import main.entity.UserQueries;
import main.services.Login;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class ChangeViewAction implements ActionListener {

    public static boolean isUsed = false;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(!isUsed) isUsed = true;
        AppGUI.frame.getContentPane().remove(1);
        try {
            AppGUI.frame.getContentPane().add(getUserStoredAction());
        } catch ( SQLException throwables ) {
            throwables.printStackTrace();
        }
        AppGUI.frame.validate();
    }

    public JScrollPane getUserStoredAction() throws SQLException {
        JPanel posts = new JPanel();
        List<UserQueries> queries = findAllUserActions();
        posts.setPreferredSize(new Dimension(1800,queries.size()*1450));
        for(UserQueries query : queries){

            JPanel panel = new JPanel();
            panel.setPreferredSize(new Dimension(1800,1350));
            JLabel filePath = new JLabel();
            JTextPane header = new JTextPane();
            header.setPreferredSize(new Dimension(1800,100));
            header.setContentType("text/html");
            header.setEditable(false); // as before
            header.setBackground(Color.DARK_GRAY);
            header.setText("<html><p style='color:white; font-size: 30px; color: orange;' >" + query.getFileName() + "</p><html>");
            panel.add(header);
            JTextPane textPanel = new JTextPane();
            textPanel.setContentType("text/html");
            textPanel.setEditable(false); // as before
            textPanel.setBackground(Color.DARK_GRAY);
            textPanel.setText("<html><p style='padding: 50px 20px 50px 20px; width: 700px; background-color: #212623; font-size:15px; color:white;' >" + query.getText() + "</p><html>");
            ImageIcon imageIcon = null;
            imageIcon = new ImageIcon(new ImageIcon(query.getPhoto().getBytes(1, (int) query.getPhoto().length()))
                    .getImage()
                    .getScaledInstance(600, 1200, Image.SCALE_DEFAULT));
            filePath.setIcon(imageIcon);
            panel.add(textPanel);
            panel.add(filePath);
            posts.add(panel);
        }
        return new JScrollPane(posts,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }

    public List <UserQueries> findAllUserActions(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(UserQueries.class);
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        String query = "FROM UserQueries u WHERE login='" + Login.account +"'";
        Query queryToSave = session.createQuery(query);
        List <UserQueries> user = queryToSave.getResultList();
        session.getTransaction().commit();
        factory.close();
        return user;
    }


}

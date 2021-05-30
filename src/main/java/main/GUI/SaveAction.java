package main.GUI;

import main.services.Login;
import main.services.QuerySave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class SaveAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            QuerySave.querySave(Login.account,ChooseAction.text,new File(ChooseAction.currentPath));
        } catch ( IOException | SQLException e ) {
            e.printStackTrace();
        }
//        System.out.println("asd");
//        AppGUI.frame.getContentPane().remove(1);
//        AppGUI.frame.getContentPane().add(new JTextField("asd"));
//        AppGUI.frame.validate();
    }
}

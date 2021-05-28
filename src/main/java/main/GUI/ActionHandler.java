package main.GUI;

import main.services.Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {
    public ActionHandler() {
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String login = GUI.login.getText();
        String password = GUI.password.getText();
        if( Login.loginToApp(login,password)) System.out.println("true");
    }
}

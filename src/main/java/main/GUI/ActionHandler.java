package main.GUI;

import main.services.Login;
import main.vision.TextDetector;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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

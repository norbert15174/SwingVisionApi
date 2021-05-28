package main;


import main.GUI.AppGUI;
import main.GUI.GUI;
import main.entity.UserAccount;
import main.services.Login;
import main.services.Register;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        //TextDetector.detectText("t3qWG.png");
        //GUI.createAndShowPanel();
        AppGUI.startApp();
        //Register.registerToApp("axe89","najlepszy");
        //Login.loginToApp("axe89","najlepdsszy");
    }


}
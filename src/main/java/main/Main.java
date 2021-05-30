package main;


import main.GUI.AppGUI;
import main.GUI.ChangeViewAction;
import main.GUI.GUI;
import main.entity.UserAccount;
import main.services.Login;
import main.services.QuerySave;
import main.services.Register;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;


public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        //TextDetector.detectText("t3qWG.png");
        GUI.createAndShowPanel();
//        ChangeViewAction.asd();
//        //AppGUI.startApp();
//       Register.registerToApp("axe89","najlepszy");
//        QuerySave.querySave("asd","dsadsa", new File("C:\\Users\\Norbert\\Downloads\\Slajd7.JPG"));
//        Login.loginToApp("axe89","najlepdsszy");




    }


}
package main;




import java.io.IOException;
import java.sql.SQLException;

import main.GUI.GUI;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.DefaultConfiguration;


public class Main {

    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException, SQLException {
        //TextDetector.detectText("t3qWG.png");
        GUI.createAndShowPanel();
        logger.info("The application has been properly started");
        // log4j2 setup
//        Configurator.initialize(new DefaultConfiguration());
//        Configurator.setRootLevel(Level.INFO);
//        logger.trace("Entering application.");
//        logger.trace("Exiting application.");
//        ChangeViewAction.asd();
//        //AppGUI.startApp();
//       Register.registerToApp("axe89","najlepszy");
//        QuerySave.querySave("asd","dsadsa", new File("C:\\Users\\Norbert\\Downloads\\Slajd7.JPG"));
//        Login.loginToApp("axe89","najlepdsszy");




    }


}
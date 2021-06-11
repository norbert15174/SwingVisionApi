package main.GUI;

import main.services.Login;
import main.services.QuerySave;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class SaveAction implements ActionListener {

    private static Logger logger = LogManager.getLogger(SaveAction.class);
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(ChooseAction.isSaved){
            logger.error("You can't save this photo or you didn't choose correct photo or you tried to save the same photo once again");
            ChooseAction.setError("You can't save this photo or you didn't choose correct photo or you tried to save the same photo once again");
            ChooseAction.display();
            ChangeViewAction.isUsed = false;
        }else{
            try {
                QuerySave.querySave(Login.account,ChooseAction.text,new File(ChooseAction.currentPath));
                ChooseAction.setOk("Item has been added");
                logger.info("Item has been added");
                ChooseAction.isSaved = true;
            } catch ( IOException | SQLException e ) {
                logger.error("Item couldn't be added to database (QuerySave)");
            }
        }

    }
}

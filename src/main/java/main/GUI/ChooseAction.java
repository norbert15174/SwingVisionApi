package main.GUI;

import main.vision.TextDetector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.regex.Pattern;


public class ChooseAction implements ActionListener {

    public static String currentPath;
    public static String text;
    public static boolean isSaved = true;
    private static final Logger logger = LogManager.getLogger(ChooseAction.class);

    public ChooseAction() {
    }

    public void actionPerformed(ActionEvent evt)
    {
        JFileChooser window = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        window.setPreferredSize(new Dimension(1000,600));

        int checkIfChosen = window.showOpenDialog(null);
        if (checkIfChosen == JFileChooser.APPROVE_OPTION)
        {
            String fileName = window.getSelectedFile().getName();
            Pattern compiledPattern = Pattern.compile(".*[.]jpg|.*[.]png|.*[.]jpeg");
            if(compiledPattern.matcher(fileName).matches())
            {

                this.currentPath = window.getSelectedFile().getAbsolutePath();
                try {
                    text = TextDetector.detectText(window.getSelectedFile().getAbsolutePath());
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon(currentPath)
                            .getImage()
                            .getScaledInstance(700 , 1000 , Image.SCALE_DEFAULT));
                    AppGUI.filePath.setVisible(true);
                    AppGUI.filePath.setIcon(imageIcon);
                    AppGUI.textPanel.setText("<html><p style='padding: 50px 20px 50px 20px; width: 700px; background-color: #212623; font-size:15px; color:white;' >" + text + "</p><html>");
                    isSaved = false;
                    display();
                    ChangeViewAction.isUsed = false;
                } catch ( Exception e ) {
                    display();
                    setError("PHOTO DOESN'T INCLUDE TEXT");
                    logger.error("Photo doesn't include text");
                    ChangeViewAction.isUsed = false;
                    isSaved = true;
                }
            }else{
                display();
                ChangeViewAction.isUsed = false;
                isSaved = true;
                logger.info("File doesn't match file type (png,jpg)");
                setError("File doesn't match file type (png,jpg)");
            }
        }

    }
    public static void setError(String text){
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\Users\\Norbert\\Desktop\\SEMESTR 6\\untitled2\\wrong-295503_960_720.png")
                .getImage()
                .getScaledInstance(300 , 300 , Image.SCALE_DEFAULT));
        AppGUI.filePath.setVisible(true);
        AppGUI.filePath.setIcon(imageIcon);
        AppGUI.textPanel.setText("<html><p style='padding: 50px 20px 50px 20px; width: 700px; background-color: #212623; font-size:15px; color:white;' >" + text + "</p><html>");
    }

    public static void setOk(String text){
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\Users\\Norbert\\Desktop\\SEMESTR 6\\untitled2\\Symbol_OK.svg.png")
                .getImage()
                .getScaledInstance(300 , 300 , Image.SCALE_DEFAULT));
        AppGUI.filePath.setVisible(true);
        AppGUI.filePath.setIcon(imageIcon);
        AppGUI.textPanel.setText("<html><p style='padding: 50px 20px 50px 20px; width: 700px; background-color: #212623; font-size:15px; color:white;' >" + text + "</p><html>");
    }

    public static void display(){
        if(ChangeViewAction.isUsed){
            AppGUI.frame.getContentPane().getComponent(1).setVisible(false);
            AppGUI.frame.getContentPane().remove(1);
            AppGUI.frame.getContentPane().add(AppGUI.scrollBar);
            AppGUI.frame.invalidate();
        }
    }
}

package main.GUI;

import main.vision.TextDetector;


import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class ChooseAction implements ActionListener {

    private String currentPath;

    public ChooseAction() {
    }

    public void actionPerformed(ActionEvent evt)
    {
        JFileChooser window = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        window.setPreferredSize(new Dimension(1000,600));

        int checkIfChosen = window.showOpenDialog(null);
        if (checkIfChosen == JFileChooser.APPROVE_OPTION)
        {
            this.currentPath = window.getSelectedFile().getAbsolutePath();
            try {
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(currentPath)
                        .getImage()
                        .getScaledInstance(700, 1000, Image.SCALE_DEFAULT));
                AppGUI.filePath.setIcon(imageIcon);
                AppGUI.textPanel.setText("<html><p style='padding: 50px 20px 50px 20px; width: 700px; background-color: #212623; font-size:15px; color:white;' >" + TextDetector.detectText(window.getSelectedFile().getAbsolutePath()) + "</p><html>");
            } catch ( IOException e ) {
                e.printStackTrace();
            }
        }
    }
}

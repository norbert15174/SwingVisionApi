package main.GUI;


import main.vision.TextDetector;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static javax.swing.SwingUtilities.updateComponentTreeUI;

public class AppGUI extends JFrame implements ActionListener {
    // Jlabel to show the files user selects
    public static JLabel filePath = new JLabel();
    public static JLabel q = new JLabel();
    public static JTextPane photo = new JTextPane();

    // a default constructor
    AppGUI()
    {
    }

    public static JButton createOpenButton(String text){
        JButton jb = new JButton("<html><p style='font-size:20px;background-color: #043a45; padding: 10px; border-radius: 10px;'> " + text + " </p><html>");
        jb.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        jb.setForeground(Color.WHITE);
        jb.setSize(new Dimension(200,50));
        return jb;
    }

    public static void startApp()
    {
        try {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        photo.setContentType("text/html"); // let the text pane know this is what you want
        photo.setEditable(false); // as before
        photo.setBackground(Color.DARK_GRAY);
        // frame to contains GUI elements
        JFrame f = new JFrame("TEXT DETECTOR");
        // set the size of the frame
        f.setSize(1800, 1000);
        // set the frame's visibility
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // button to open open dialog
        JButton button2 = createOpenButton("Choose Photo");
        JButton button3 = createOpenButton("Save Result");
        JButton button4 = createOpenButton("Show Your Work");
        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.decode("#525252"));
        jPanel.setPreferredSize(new Dimension(1800,100));
        jPanel.add(button2,Component.BOTTOM_ALIGNMENT);
        jPanel.add(button3,Component.BOTTOM_ALIGNMENT);
        jPanel.add(button4,Component.BOTTOM_ALIGNMENT);
        AppGUI f1 = new AppGUI();
        // add action listener to the button to capture user
        // response on buttons
        button2.addActionListener(f1);
        // make a panel to add the buttons and labels
        JPanel p = new JPanel();
        // add buttons to the frame
        f.getContentPane().add(jPanel,BorderLayout.NORTH);

        p.setPreferredSize(new Dimension(1800,1000));
        // set the label to its initial value
        // add panel to the frame
        JScrollPane scrollBar=new JScrollPane(p,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        p.add(filePath);
        p.add(photo);
        p.add(q);
        p.setBackground(Color.DARK_GRAY);
        f.add(scrollBar);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent evt)
    {


        // if the user presses the save button show the save dialog
        String com = evt.getActionCommand();

            // create an object of JFileChooser class
            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            j.setPreferredSize(new Dimension(1000,600));

        int r = j.showOpenDialog(null);
            // if the user selects a file
            if (r == JFileChooser.APPROVE_OPTION)
            {
                // set the label to the path of the selected file
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(j.getSelectedFile().getAbsolutePath()).getImage().getScaledInstance(700, 1000, Image.SCALE_DEFAULT));
                filePath.setIcon(imageIcon);

                try {
                    photo.setText("<html><p style='padding: 50px 20px 50px 20px; width: 700px; background-color: #212623; font-size:15px; color:white;' >" + TextDetector.detectText(j.getSelectedFile().getAbsolutePath()) + "</p><html>");
                } catch ( IOException e ) {
                    e.printStackTrace();
                }
            }


    }
}

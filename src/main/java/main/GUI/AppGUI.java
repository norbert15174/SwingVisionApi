package main.GUI;


import main.vision.TextDetector;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static javax.swing.SwingUtilities.updateComponentTreeUI;

public class AppGUI extends JFrame{
    public static JLabel filePath = new JLabel();
    public static JTextPane textPanel = new JTextPane();
    public static JScrollPane scrollBar;
    public static JFrame frame = new JFrame("TEXT DETECTOR");
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

    public static void setTextPanelLook(){
        textPanel.setContentType("text/html");
        textPanel.setEditable(false); // as before
        textPanel.setBackground(Color.DARK_GRAY);
    }

    public static void createButtons(JPanel jPanel){
        JButton button2 = createOpenButton("Choose Photo");
        JButton button3 = createOpenButton("Save Result");
        JButton button4 = createOpenButton("Show Your Work");
        jPanel.add(button2,Component.BOTTOM_ALIGNMENT);
        jPanel.add(button3,Component.BOTTOM_ALIGNMENT);
        jPanel.add(button4,Component.BOTTOM_ALIGNMENT);
        button2.addActionListener(new ChooseAction());
        button4.addActionListener(new ChangeViewAction());
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

        frame.setSize(1800, 1000);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addPanelsToJFrame(frame);


    }

    public static void addPanelsToJFrame(JFrame frame){
        JPanel container = new JPanel();
        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.decode("#525252"));
        jPanel.setPreferredSize(new Dimension(1800,100));
        setTextPanelLook();
        createButtons(jPanel);
        container.setPreferredSize(new Dimension(1800,1000));
        scrollBar=new JScrollPane(container,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        container.add(filePath);
        container.add(textPanel);
        container.setBackground(Color.DARK_GRAY);
        frame.getContentPane().add(jPanel,BorderLayout.NORTH);
        frame.add(scrollBar);
        frame.setVisible(true);
    }

}

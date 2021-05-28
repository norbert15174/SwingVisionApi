package main.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Pattern;

public class GUI {
    public static JFrame jf = new JFrame("Text Detector APP");
    public static JTextField login = new JTextField(20);
    public static JTextField password = new JTextField(20);

    public static void createAndShowPanel(){
        JPanel jpFirst = new JPanel();
        jpFirst.setBackground(Color.decode("#2e2d2d"));
        jpFirst.setPreferredSize(new Dimension(1800,800));
        JPanel jp = new JPanel(new GridLayout(2,1,0,0));
        jp.setBackground(Color.decode("#2e2d2d"));
        JPanel jpLogin = new JPanel(new GridLayout(2,1,0,0));
        jpLogin.add(createLoginPage("Login"));
        jpLogin.add(jp.add(createTextField(login)));
        JPanel jpRegister = new JPanel(new GridLayout(2,1,0,0));
        jpRegister.add(createLoginPage("Password"));
        jpRegister.add(jp.add(createTextField(password)));
        jp.setPreferredSize(new Dimension(600,250));
        jpFirst.setBorder(BorderFactory.createEmptyBorder(300,0,0,0));

        jpLogin.setPreferredSize(new Dimension(600,150));
        jpRegister.setPreferredSize(new Dimension(600,150));
        jpRegister.setBackground(new Color(52, 52, 46));
        jpLogin.setBackground(new Color(52, 52, 46));
        jp.add(jpLogin);
        jp.add(jpRegister);
        jpFirst.add(jp);

        jf.getContentPane().add(createButton("Log In"),BorderLayout.SOUTH);
        jf.getContentPane().add(jpFirst);
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static JTextField createTextField(JTextField outField){
        outField.setPreferredSize(new Dimension(400,30));
        outField.setFont(new Font("Serif", Font.PLAIN, 30));
        outField.setBackground(Color.decode("#262626"));
        outField.setForeground(Color.orange);
        outField.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        return outField;
    }

    private static JTextField createLoginPage(String text){

        JTextField jTextField =  new JTextField();

        jTextField.setFont(new Font("Serif", Font.PLAIN, 32));
        jTextField.setForeground(Color.orange);
        jTextField.setBackground(new Color(52, 52, 46));
        jTextField.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        jTextField.setEditable(false);
        jTextField.setText(text);

        return jTextField;
    }

    public static JButton createButton(String name){
        JButton jb = new JButton(name);
        jb.setBackground(Color.ORANGE);
        jb.setFont(new Font("Serif", Font.PLAIN, 20));
        jb.setForeground(Color.decode("#2e2d2d"));
        jb.setPreferredSize(new Dimension(1500, 100));
        jb.addActionListener(new ActionHandler());
        return jb;
    }


}

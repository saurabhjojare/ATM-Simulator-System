package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class BalanceEquiry extends JFrame implements ActionListener {
    String pinnumber;
    JButton back;
    BalanceEquiry(String pinnumber) {

        this.pinnumber = pinnumber;

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img2 = img.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(0,0,700,700);
        add(image);

        back = new JButton("Back");
        back.setBounds(80,330,120,30);
        back.addActionListener(this);
        image.add(back);

        Conn c = new Conn();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel text = new JLabel("Current Balance "+balance);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,18));
        text.setBounds(80,150,200,35);
        image.add(text);

        getContentPane().setBackground(Color.WHITE);
        setSize(600,510);
        setLocation(390,100);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEquiry("");
    }
}

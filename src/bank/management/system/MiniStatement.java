package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class MiniStatement extends JFrame {
    MiniStatement(String pinnumber) {
        setTitle("Mini Statement");

        setLayout(null);

        JLabel mini = new JLabel();
        add(mini);

        JLabel card = new JLabel();
        card.setBounds(20,30,300,20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,420,300,20);
        add(balance);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number:    " + rs.getString("cardnumber").substring(0, 4) + " XXXX XX" + rs.getString("cardnumber").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Conn conn = new Conn();
            int totalBalance = 0;
            ResultSet rs = conn.s.executeQuery("SELECT * FROM bank where pin = '"+pinnumber+"'");
            while (rs.next()) {
            mini.setText(mini.getText() + "<html>"+rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");

            if (rs.getString("type").equals("Deposit")) {
                totalBalance += Integer.parseInt(rs.getString("amount"));
                } else {
                totalBalance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your Current Balance "+totalBalance);
        } catch (Exception e) {
            System.out.println(e);
        }

        mini.setBounds(20,90,400,200);

        setSize(400,500);
        setLocation(500,100);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}

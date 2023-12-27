package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {
    JTextField amount;
    JButton withdrawl, back;
    String pinnumber;
    Withdrawl(String pinnumber) {
        this.pinnumber = pinnumber;

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img2 = img.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(0,0,700,700);
        add(image);

        JLabel text = new JLabel("Enter Amount");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(80,160,200,35);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(80,200,150,25);
        image.add(amount);

        withdrawl = new JButton("Withdraw");
        withdrawl.setBounds(225,330,120,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        back = new JButton("Back");
        back.setBounds(78,330,120,30);
        back.addActionListener(this);
        image.add(back);

        getContentPane().setBackground(Color.WHITE);
        setSize(600,510);
        setLocation(390,100);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdrawl) {
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null,"Enter Amount");
            } else {
                try {
                    Conn conn = new Conn();
                    String query = "insert into bank values('" + pinnumber + "', '" + date + "', 'Withdrawl', '" + number + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " Withdrawl Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else if(ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdrawl("");

    }
}

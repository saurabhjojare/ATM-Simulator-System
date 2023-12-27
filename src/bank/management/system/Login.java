package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton login, signup, clear;
    JLabel text, cardno, pin;
    JTextField cardTextField;
    JPasswordField pinTextField;
    public Login() {

        setTitle("Login");

        setLayout(null);

        cardno = new JLabel("Card Number");
        cardno.setFont(new Font("Osward", Font.BOLD, 18));
        cardno.setBounds(40,80,400,40);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(220, 90,204,30);
        cardTextField.setFont(new Font("Arial", Font.BOLD,14));
        add(cardTextField);

        pin = new JLabel("Pin");
        pin.setFont(new Font("Osward", Font.BOLD, 18));
        pin.setBounds(40,140,400,40);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(220, 147,204,30);
        pinTextField.setFont(new Font("Arial", Font.BOLD,14));
        add(pinTextField);

        login = new JButton("Sign In");
        login.setBounds(220,200,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("Clear");
        clear.setBounds(324,200,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("Sign Up");
        signup.setBounds(220,250,204,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);

        setSize(480, 410);
        setVisible(true);
        setLocation(440,135);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if (ae.getSource() == login) {
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";

            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number Or Pin");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else if (ae.getSource() == signup) {
            setVisible(false);
            new signupOne().setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Login();
    }
}
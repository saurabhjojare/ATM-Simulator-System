package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class signupThree extends JFrame implements ActionListener {
    JRadioButton savingsAccount, currentAccount, recurringAccount, fixedDeposite;
    JCheckBox atmcard, internetBanking, mobileBanking, alerts, chequeBook, eStatement;
    JButton submit, cancel;
    String formno;
    signupThree(String formno) {
        setLayout(null);
        this.formno = formno;

        setTitle("Page 3 - Account Details");

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 18));
        type.setBounds(50,30,300,30);
        add(type);

        savingsAccount = new JRadioButton("Savings Account");
        savingsAccount.setFont(new Font("Raleway", Font.BOLD, 18));
        savingsAccount.setBackground(Color.WHITE);
        savingsAccount.setBounds(60,60,200,30);
        add(savingsAccount);

        fixedDeposite = new JRadioButton("Fixed Deposite");
        fixedDeposite.setFont(new Font("Raleway", Font.BOLD, 18));
        fixedDeposite.setBackground(Color.WHITE);
        fixedDeposite.setBounds(260,60,300,30);
        add(fixedDeposite);

        currentAccount = new JRadioButton("Current Account");
        currentAccount.setFont(new Font("Raleway", Font.BOLD, 18));
        currentAccount.setBackground(Color.WHITE);
        currentAccount.setBounds(60,100,200,30);
        add(currentAccount);

        recurringAccount = new JRadioButton("Recurring Account");
        recurringAccount.setFont(new Font("Raleway", Font.BOLD, 18));
        recurringAccount.setBackground(Color.WHITE);
        recurringAccount.setBounds(260,100,300,30);
        add(recurringAccount);

        ButtonGroup groupAccount = new ButtonGroup();
        groupAccount.add(savingsAccount);
        groupAccount.add(fixedDeposite);
        groupAccount.add(currentAccount);
        groupAccount.add(recurringAccount);

        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD, 18));
        card.setBounds(80,140,300,30);
        add(card);

        JLabel number = new JLabel("XXX-XXXX-XXX-4184");
        number.setFont(new Font("Raleway", Font.BOLD, 18));
        number.setBounds(300,150,300,30);
        add(number);

        JLabel cardDetail = new JLabel("Your 16 Digit Card Number");
        cardDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        cardDetail.setBounds(80,160,300,30);
        add(cardDetail);

        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway", Font.BOLD, 18));
        pin.setBounds(80,190,300,30);
        add(pin);

        JLabel pinNumber = new JLabel("XXX");
        pinNumber.setFont(new Font("Raleway", Font.BOLD, 18));
        pinNumber.setBounds(300,200,300,30);
        add(pinNumber);

        JLabel pinDetail = new JLabel("Your 4 Digit PIN");
        pinDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pinDetail.setBounds(80,210,300,30);
        add(pinDetail);

        JLabel services = new JLabel("Services Required");
        services.setFont(new Font("Raleway", Font.BOLD, 18));
        services.setBounds(80,250,300,30);
        add(services);

        atmcard = new JCheckBox("ATM Card");
        atmcard.setBackground(Color.WHITE);
        atmcard.setFont(new Font("Raleway", Font.BOLD, 16));
        atmcard.setBounds(100,280,150,30);
        add(atmcard);

        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setBackground(Color.WHITE);
        internetBanking.setFont(new Font("Raleway", Font.BOLD, 16));
        internetBanking.setBounds(280,280,300,30);
        add(internetBanking);

        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setBackground(Color.WHITE);
        mobileBanking.setFont(new Font("Raleway", Font.BOLD, 16));
        mobileBanking.setBounds(100,320,180,30);
        add(mobileBanking);

        alerts = new JCheckBox("Email/SMS Alerts");
        alerts.setBackground(Color.WHITE);
        alerts.setFont(new Font("Raleway", Font.BOLD, 16));
        alerts.setBounds(280,320,300,30);
        add(alerts);

        chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setBackground(Color.WHITE);
        chequeBook.setFont(new Font("Raleway", Font.BOLD, 16));
        chequeBook.setBounds(100,360,150,30);
        add(chequeBook);

        eStatement = new JCheckBox("E-Statement");
        eStatement.setBackground(Color.WHITE);
        eStatement.setFont(new Font("Raleway", Font.BOLD, 16));
        eStatement.setBounds(280,360,300,30);
        add(eStatement);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(400,410,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(40,410,100,30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);
        setSize(560,510);
        setLocation(420,100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String type = null;
            if (savingsAccount.isSelected()) {
                type = "Saving Account";
            } else if (fixedDeposite.isSelected()) {
                type = "Fixed Deposite";
            } else if (currentAccount.isSelected()) {
                type = "Current Account";
            } else if (recurringAccount.isSelected()) {
                type = "Recurring Account";
            }
            Random random = new Random();
            String cardnumber = String.format("%016d", Math.abs(new Random().nextLong() % 90000000L + 5040936000000000L)).replaceAll("(.{4})", "$1 ").trim();

            String pinnumber = String.format("%04d", Math.abs(random.nextInt() % 10000));
            String facility = " ";
            if (atmcard.isSelected()) {
                facility = facility + "ATM Card";
            } else if (internetBanking.isSelected()) {
                facility = facility + "Internet Banking";
            } else if (mobileBanking.isSelected()) {
                facility = facility + "Mobile Banking";
            } else if (alerts.isSelected()) {
                facility = facility + "Email/SMS Alerts";
            } else if (chequeBook.isSelected()) {
                facility = facility + "Cheque Book";
            } else if (eStatement.isSelected()) {
                facility = facility + "E-Statement";
            }
            try {
                    if (type.equals("")) {
                        JOptionPane.showMessageDialog(null,"Type is Required");
                    } else {
                        Conn conn = new Conn();
                        String query1 = "insert into signupthree values('"+formno+"','"+type+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";

                        String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";

                        conn.s.executeUpdate(query1);
                        conn.s.executeUpdate(query2);

                        JOptionPane.showMessageDialog(null, "Card Number: "+cardnumber + "\n Pin: " +pinnumber);

                        setVisible(false);
                        new Deposit(pinnumber).setVisible(false);
                    }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if(ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String args[]) {
        new signupThree("");
    }
}

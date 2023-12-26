package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton onehundred, fivehundred, onethousand, twothousand, fivethousand, tenthousand, back;
    String pinnumber;
    FastCash(String pinnumber) {

        this.pinnumber = pinnumber;
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img2 = img.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(0,0,700,700);
        add(image);

        JLabel text = new JLabel("Select Amount");
        text.setBounds(179,220,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,14));
        image.add(text);

        onehundred = new JButton("Rs 100");
        onehundred.setBounds(120,331,120,24);
        onehundred.addActionListener(this);
        image.add(onehundred);

        fivehundred = new JButton("Rs 500");
        fivehundred.setBounds(258,331,131,24);
        fivehundred.addActionListener(this);
        image.add(fivehundred);

        onethousand = new JButton("Rs 1000");
        onethousand.setBounds(120,361,120,24);
        onethousand.addActionListener(this);
        image.add(onethousand);

        twothousand = new JButton("Rs 2000");
        twothousand.setBounds(258,361,131,24);
        twothousand.addActionListener(this);
        image.add(twothousand);

        fivethousand = new JButton("Rs 5000");
        fivethousand.setBounds(120,391,120,24);
        fivethousand.addActionListener(this);
        image.add(fivethousand);

        tenthousand = new JButton("Rs 10000");
        tenthousand.setBounds(258,391,131,24);
        tenthousand.addActionListener(this);
        image.add(tenthousand);

        back = new JButton("Back");
        back.setBounds(120,420,120,24);
        back.addActionListener(this);
        image.add(back);

        getContentPane().setBackground(Color.WHITE);
        setSize(700,700);
        setLocation(340,17);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query  = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Successfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("");

    }
}

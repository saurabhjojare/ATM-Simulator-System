package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class signupOne extends JFrame implements ActionListener {
    long random;
    JTextField nameTextField, middleNameTextField, dobTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinTextField;
    JRadioButton male, female, married, single;
    JButton next;
    JDateChooser dateChooser;
    signupOne() {

        setLayout(null);
        setTitle("Page 1");

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("Application Form ("+random+")");
        formno.setFont(new Font("Raleway", Font.BOLD, 23));
        formno.setBounds(210,25,600,40);
        add(formno);

        JLabel personalDetails = new JLabel("Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 18));
        personalDetails.setBounds(270,90,300,30);
        add(personalDetails);

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Raleway", Font.BOLD, 18));
        name.setBounds(80,140,300,30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD,14));
        nameTextField.setBounds(290,145,300,23);
        add(nameTextField);

        JLabel middleName = new JLabel("Middle Name");
        middleName.setFont(new Font("Raleway", Font.BOLD, 18));
        middleName.setBounds(80,180,300,30);
        add(middleName);

        middleNameTextField = new JTextField();
        middleNameTextField.setFont(new Font("Raleway", Font.BOLD,14));
        middleNameTextField.setBounds(290,185,300,23);
        add(middleNameTextField);

        JLabel dob = new JLabel("Date Of Birth");
        dob.setFont(new Font("Raleway", Font.BOLD, 18));
        dob.setBounds(80,220,300,30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(290,225,300,23);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);

        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Raleway", Font.BOLD, 18));
        gender.setBounds(80,260,300,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(290,265,60,30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(360,265,80,30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email = new JLabel("Email");
        email.setFont(new Font("Raleway", Font.BOLD, 18));
        email.setBounds(80,300,300,30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD,14));
        emailTextField.setBounds(290,305,300,23);
        add(emailTextField);

        JLabel marital = new JLabel("Marital Status");
        marital.setFont(new Font("Raleway", Font.BOLD, 18));
        marital.setBounds(80,340,300,30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(290,340,90,30);
        married.setBackground(Color.WHITE);
        add(married);

        single = new JRadioButton("Single");
        single.setBounds(380,340,80,30);
        single.setBackground(Color.WHITE);
        add(single);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(single);

        JLabel address = new JLabel("Address");
        address.setFont(new Font("Raleway", Font.BOLD, 18));
        address.setBounds(80,380,300,30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD,14));
        addressTextField.setBounds(290,385,300,23);
        add(addressTextField);

        JLabel city = new JLabel("City");
        city.setFont(new Font("Raleway", Font.BOLD, 18));
        city.setBounds(80,420,300,30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD,14));
        cityTextField.setBounds(290,425,300,23);
        add(cityTextField);

        JLabel state = new JLabel("State");
        state.setFont(new Font("Raleway", Font.BOLD, 18));
        state.setBounds(80,460,300,30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD,14));
        stateTextField.setBounds(290,465,300,23);
        add(stateTextField);

        JLabel pin = new JLabel("Pin Code");
        pin.setFont(new Font("Raleway", Font.BOLD, 18));
        pin.setBounds(80,500,300,30);
        add(pin);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD,14));
        pinTextField.setBounds(290,505,300,23);
        add(pinTextField);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD,14));
        next.setBounds(510,560,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(700,700);
        setLocation(340,17);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random; // long
        String name = nameTextField.getText(); // setText
        String middleName = middleNameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }
        String email = emailTextField.getText();
        String marital = null;
        if(married.isSelected()) {
            marital = "Married";
        } else if (single.isSelected()) {
            marital = "Single";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();

        try {
            if(name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            } else {
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+middleName+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"', '"+state+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new signupTwo(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        new signupOne();
    }
}

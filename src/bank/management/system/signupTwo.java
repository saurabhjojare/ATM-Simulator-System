package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class signupTwo extends JFrame implements ActionListener {
    JTextField panTextField, aadharTextField;
    JRadioButton syes, sno, eyes, eno;
    JButton next;
    JComboBox religionBox, categoryBox,  incomeBox, educationBox, occupationBox;
    String formno;
     signupTwo(String formno) {

        setLayout(null);
        this.formno = formno;
        setTitle("Page 2");

        JLabel additionalDetails = new JLabel("Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 18));
        additionalDetails.setBounds(270,90,300,30);
        add(additionalDetails);

        JLabel religion = new JLabel("Religion");
        religion.setFont(new Font("Raleway", Font.BOLD, 18));
        religion.setBounds(80,140,300,30);
        add(religion);

        String valReligion[] = {"Hindu","Sikh","Christian"};
        religionBox = new JComboBox(valReligion);
        religionBox.setBounds(290,145,300,23);
        religionBox.setBackground(Color.WHITE);
        add(religionBox);


        JLabel category = new JLabel("Category");
        category.setFont(new Font("Raleway", Font.BOLD, 18));
        category.setBounds(80,180,300,30);
        add(category);

        String valCategory[] = {"General","OBC","SC","ST"};
        categoryBox = new JComboBox(valCategory);
        categoryBox.setBounds(290,185,300,23);
        categoryBox.setBackground(Color.WHITE);
        add(categoryBox);

        JLabel income = new JLabel("Income");
        income.setFont(new Font("Raleway", Font.BOLD, 18));
        income.setBounds(80,220,300,30);
        add(income);

        String valIncome[] = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
        incomeBox = new JComboBox(valIncome);
        incomeBox.setBounds(290,225,300,23);
        incomeBox.setBackground(Color.WHITE);
        add(incomeBox);

        JLabel education = new JLabel("Education");
        education.setFont(new Font("Raleway", Font.BOLD, 18));
        education.setBounds(80,260,300,30);
        add(education);

        String valEducation[] = {"Non Graduate","Bachelor's","Master's","Doctorate"};
        educationBox = new JComboBox(valEducation);
        educationBox.setBounds(290,265,300,23);
        educationBox.setBackground(Color.WHITE);
        add(educationBox);

        JLabel occupation = new JLabel("Occupation");
        occupation.setFont(new Font("Raleway", Font.BOLD, 18));
        occupation.setBounds(80,300,300,30);
        add(occupation);

        String valOccupation[] = {"Salaried","Self Employed","Business","Student","Retired"};
        occupationBox = new JComboBox(valOccupation);
        occupationBox.setBounds(290,305,300,23);
        occupationBox.setBackground(Color.WHITE);
        add(occupationBox);

        JLabel pan = new JLabel("Pan Number");
        pan.setFont(new Font("Raleway", Font.BOLD, 18));
        pan.setBounds(80,340,300,30);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD,14));
        panTextField.setBounds(290,345,300,23);
        add(panTextField);

        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 18));
        aadhar.setBounds(80,380,300,30);
        add(aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD,14));
        aadharTextField.setBounds(290,385,300,23);
        add(aadharTextField);

        JLabel seniorcitizen = new JLabel("Senior Citizen");
        seniorcitizen.setFont(new Font("Raleway", Font.BOLD, 18));
        seniorcitizen.setBounds(80,420,300,30);
        add(seniorcitizen);

        syes = new JRadioButton("Yes");
        syes.setBounds(290,425,90,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(380,425,80,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup sgroup = new ButtonGroup();
        sgroup.add(syes);
        sgroup.add(sno);

        JLabel existingaccount = new JLabel("Existing Account");
        existingaccount.setFont(new Font("Raleway", Font.BOLD, 18));
        existingaccount.setBounds(80,460,300,30);
        add(existingaccount);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(290,465,90,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(380,465,80,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup egroup = new ButtonGroup();
        egroup.add(eyes);
        egroup.add(eno);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD,14));
        next.setBounds(510,500,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(700,700);
        setLocation(340,17);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        String religion = (String) religionBox.getSelectedItem();
        String category = (String) categoryBox.getSelectedItem();
        String income = (String) incomeBox.getSelectedItem();
        String education = (String) educationBox.getSelectedItem();
        String occupation = (String) occupationBox.getSelectedItem();

        String seniorcitizen = null;
        if(syes.isSelected()) {
            seniorcitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorcitizen = "No";
        }

        String existingaccount = null;
        if(eyes.isSelected()) {
            existingaccount = "Yes";
        } else if (eno.isSelected()) {
            existingaccount = "No";
        }

        String pan = panTextField.getText();
        String aadhar = aadharTextField.getText();


        try {
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
                c.s.executeUpdate(query);

            setVisible(false);
            new signupThree(formno).setVisible(true);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        new signupTwo("");
    }
}

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
        setTitle("Page 2 - Additional Details");

        JLabel religion = new JLabel("Religion");
        religion.setFont(new Font("Raleway", Font.BOLD, 18));
        religion.setBounds(50,40,300,30);
        add(religion);

        String valReligion[] = {"Hindu","Sikh","Christian"};
        religionBox = new JComboBox(valReligion);
        religionBox.setBounds(290,45,200,23);
        religionBox.setBackground(Color.WHITE);
        add(religionBox);

        JLabel category = new JLabel("Category");
        category.setFont(new Font("Raleway", Font.BOLD, 18));
        category.setBounds(50,80,300,30);
        add(category);

        String valCategory[] = {"General","OBC","SC","ST"};
        categoryBox = new JComboBox(valCategory);
        categoryBox.setBounds(290,85,200,23);
        categoryBox.setBackground(Color.WHITE);
        add(categoryBox);

        JLabel income = new JLabel("Income");
        income.setFont(new Font("Raleway", Font.BOLD, 18));
        income.setBounds(50,120,300,30);
        add(income);

        String valIncome[] = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
        incomeBox = new JComboBox(valIncome);
        incomeBox.setBounds(290,125,200,23);
        incomeBox.setBackground(Color.WHITE);
        add(incomeBox);

        JLabel education = new JLabel("Education");
        education.setFont(new Font("Raleway", Font.BOLD, 18));
        education.setBounds(50,160,300,30);
        add(education);

        String valEducation[] = {"Non Graduate","Bachelor's","Master's","Doctorate"};
        educationBox = new JComboBox(valEducation);
        educationBox.setBounds(290,165,200,23);
        educationBox.setBackground(Color.WHITE);
        add(educationBox);

        JLabel occupation = new JLabel("Occupation");
        occupation.setFont(new Font("Raleway", Font.BOLD, 18));
        occupation.setBounds(50,200,300,30);
        add(occupation);

        String valOccupation[] = {"Salaried","Self Employed","Business","Student","Retired"};
        occupationBox = new JComboBox(valOccupation);
        occupationBox.setBounds(290,205,200,23);
        occupationBox.setBackground(Color.WHITE);
        add(occupationBox);

        JLabel pan = new JLabel("Pan Number");
        pan.setFont(new Font("Raleway", Font.BOLD, 18));
        pan.setBounds(50,240,300,30);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD,14));
        panTextField.setBounds(290,245,200,23);
        add(panTextField);

        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 18));
        aadhar.setBounds(50,280,300,30);
        add(aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD,14));
        aadharTextField.setBounds(290,285,200,23);
        add(aadharTextField);

        JLabel seniorcitizen = new JLabel("Senior Citizen");
        seniorcitizen.setFont(new Font("Raleway", Font.BOLD, 18));
        seniorcitizen.setBounds(50,320,300,30);
        add(seniorcitizen);

        syes = new JRadioButton("Yes");
        syes.setBounds(290,325,90,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(380,325,80,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup sgroup = new ButtonGroup();
        sgroup.add(syes);
        sgroup.add(sno);

        JLabel existingaccount = new JLabel("Existing Account");
        existingaccount.setFont(new Font("Raleway", Font.BOLD, 18));
        existingaccount.setBounds(50,360,300,30);
        add(existingaccount);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(290,365,90,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(380,365,80,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup egroup = new ButtonGroup();
        egroup.add(eyes);
        egroup.add(eno);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD,14));
        next.setBounds(410,410,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(560,510);
        setLocation(400,120);
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

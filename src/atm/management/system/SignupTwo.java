package atm.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField phoneTextField,nicTextField;
    JButton nextButton;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category,income,educational,occupation;
    String formNo;


    SignupTwo(String formNo){
        this.formNo = formNo;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        //label for page 1
        JLabel additionalDetails = new JLabel("Page 1: Additional Details");
        additionalDetails.setFont(new Font("Railway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);


        //making labels and text fields of the form

        //name and name text field
        JLabel name = new JLabel("Religion : ");
        name.setFont(new Font("Railway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

          //String[] valReligion = {"Buddism","Hindu","Islam","Christianity"};
          //JComboBox religion = new JComboBox(valReligion);

        String[] valReligion = {"Buddism", "Hindu", "Islam", "Christianity"};
        religion = new JComboBox<>(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel fname = new JLabel("Category : ");
        fname.setFont(new Font("Railway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        String[] valcategory = {"General", "OBC", "SC", "Other"};
        category = new JComboBox<>(valcategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);


        //date of birth and date of birth jcalander
        JLabel dob = new JLabel("Income : ");
        dob.setFont(new Font("Railway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        dob.setForeground(Color.BLACK);
        add(dob);

        String[] valincome = {"Null", "<1,50,000", "<2,50,000", "<5,00,000", "upto 10,00,000" };
        income = new JComboBox<>(valincome);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);



        //gender and gender radio buttons
        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Railway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        JLabel email = new JLabel("Qualification : ");
        email.setFont(new Font("Railway", Font.BOLD, 20));
        email.setBounds(100, 310, 200, 30);
        add(email);


        String[] valeducational = {"None Graduate", "Graduate", "Post Graduate", "Doctorate", "Other" };
        educational = new JComboBox<>(valeducational);
        educational.setBounds(300, 315, 400, 30);
        educational.setBackground(Color.WHITE);
        add(educational);




        //marital status and marital status radio buttons
        JLabel marital = new JLabel("Occupation : ");
        marital.setFont(new Font("Railway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        String[] valoccupation = {"Salaried", "Self Employed", "Business", "Student", "Retired","Other" };
        occupation = new JComboBox<>(valoccupation);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);




        //address and address text field
        JLabel address = new JLabel("Phone No : ");
        address.setFont(new Font("Railway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        phoneTextField = new JTextField();
        phoneTextField.setFont(new Font("Railway", Font.BOLD, 14));
        phoneTextField.setBounds(300, 440, 400, 30);
        add(phoneTextField);



        //province and province text field
        JLabel province = new JLabel("NIC No : ");
        province.setFont(new Font("Railway", Font.BOLD, 20));
        province.setBounds(100, 490, 200, 30);
        add(province);

        nicTextField = new JTextField();
        nicTextField.setFont(new Font("Railway", Font.BOLD, 14));
        nicTextField.setBounds(300, 490, 400, 30);
        add(nicTextField);


        //city and city text field
        JLabel seniorcitizen = new JLabel("Senior Citizen : ");
        seniorcitizen.setFont(new Font("Railway", Font.BOLD, 20));
        seniorcitizen.setBounds(100, 540, 200, 30);
        add(seniorcitizen);

        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup seniorgroup = new ButtonGroup();
        seniorgroup.add(syes);
        seniorgroup.add(sno);



        //postal code and postal code text field
        JLabel existingacc = new JLabel("Existing Account : ");
        existingacc.setFont(new Font("Railway", Font.BOLD, 20));
        existingacc.setBounds(100, 590, 200, 30);
        add(existingacc);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup exixtinggroup = new ButtonGroup();
        exixtinggroup.add(eyes);
        exixtinggroup.add(eno);


        //next button
        nextButton = new JButton("Next");
        nextButton.setBounds(550, 650, 150, 30);
        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.WHITE);
        nextButton.setFont(new Font("Railway", Font.BOLD, 14));
        nextButton.addActionListener(this);
        add(nextButton);




        getContentPane().setBackground(Color.WHITE);

        //setting frame properties
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        String name = phoneTextField.getText();
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) educational.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();


        String seniorcitizen = null;
        if (syes.isSelected()){
            seniorcitizen = "Yes";
        }
        else if (sno.isSelected()){
            seniorcitizen = "No";
        }
        String existingacc = null;
        if (eyes.isSelected()){
            existingacc = "Yes";
        }else if (eno.isSelected()){
            existingacc = "No";
        }
        String sphone = phoneTextField.getText();
        String snic = nicTextField.getText();




        try{

                Conn c = new Conn();
                String query = "insert into signuptwo values('" + formNo + "','" + sreligion + "','" + scategory + "','"   + sincome + "','"  + soccupation + "','" + sphone + "','" + snic + "','" + seniorcitizen + "','" + existingacc + "')";
                c.st.executeUpdate(query);

                setVisible(false);
                new SignupThree(formNo).setVisible(true);

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }

}

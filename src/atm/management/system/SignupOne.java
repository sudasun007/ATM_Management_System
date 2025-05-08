package atm.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class SignupOne extends JFrame implements ActionListener {

    long ran;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,provinceTextField,cityTextField,pcodeTextField;
    JButton nextButton;
    JRadioButton male,female,preferNotToSay,married,unmarried,other;
    JDateChooser dateChooser;

    SignupOne(){
        
        setLayout(null);

        Random random = new Random();
        ran =Math.abs(random.nextLong() % 9000L + 1000L);

        //label for form no
        JLabel formNo = new JLabel("APPLICATION FORM NO : " + ran);
        formNo.setFont(new Font("Railway", Font.BOLD, 38));
        formNo.setBounds(140, 20, 600, 40);
        add(formNo);

        //label for page 1
        JLabel PersonalDetails = new JLabel("Page 1: Personal Details");
        PersonalDetails.setFont(new Font("Railway", Font.BOLD, 22));
        PersonalDetails.setBounds(290, 80, 400, 30);
        add(PersonalDetails);


        //making labels and text fields of the form

        //name and name text field
        JLabel name = new JLabel("Name : ");
        name.setFont(new Font("Railway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Railway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);

        //father name and father name text field
        JLabel fname = new JLabel("Father's Name : ");
        fname.setFont(new Font("Railway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Railway", Font.BOLD, 14));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);


        //date of birth and date of birth jcalander
        JLabel dob = new JLabel("Date Of Birth : ");
        dob.setFont(new Font("Railway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        dob.setForeground(Color.BLACK);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        add(dateChooser);


        //gender and gender radio buttons
        JLabel gender = new JLabel("Gender : ");
        gender.setFont(new Font("Railway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(420, 290, 80, 30);
        female.setBackground(Color.WHITE);
        add(female);

        preferNotToSay = new JRadioButton("Prefer Not To Say");
        preferNotToSay.setBounds(540, 290, 200, 30);
        preferNotToSay.setBackground(Color.WHITE);
        add(preferNotToSay);

        //group the radio buttons
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(preferNotToSay);


        //email and email text field
        JLabel email = new JLabel("Email : ");
        email.setFont(new Font("Railway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Railway", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);


        //marital status and marital status radio buttons
        JLabel marital = new JLabel("Marital Status : ");
        marital.setFont(new Font("Railway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(420, 390, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(540, 390, 60, 30);
        other.setBackground(Color.WHITE);
        add(other);

        //marital status groups
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);


        //address and address text field
        JLabel address = new JLabel("Address : ");
        address.setFont(new Font("Railway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Railway", Font.BOLD, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);



        //province and province text field
        JLabel province = new JLabel("Province : ");
        province.setFont(new Font("Railway", Font.BOLD, 20));
        province.setBounds(100, 490, 200, 30);
        add(province);

        provinceTextField = new JTextField();
        provinceTextField.setFont(new Font("Railway", Font.BOLD, 14));
        provinceTextField.setBounds(300, 490, 400, 30);
        add(provinceTextField);


        //city and city text field
        JLabel city = new JLabel("City : ");
        city.setFont(new Font("Railway", Font.BOLD, 20));
        city.setBounds(100, 540, 200, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Railway", Font.BOLD, 14));
        cityTextField.setBounds(300, 540, 400, 30);
        add(cityTextField);


        //postal code and postal code text field
        JLabel pcode = new JLabel("Postal Code : ");
        pcode.setFont(new Font("Railway", Font.BOLD, 20));
        pcode.setBounds(100, 590, 200, 30);
        add(pcode);

        pcodeTextField = new JTextField();
        pcodeTextField.setFont(new Font("Railway", Font.BOLD, 14));
        pcodeTextField.setBounds(300, 590, 400, 30);
        add(pcodeTextField);


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

        String formNo = "" + ran;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        //String dob = dateChooser.getDateEditor().getUiComponent().getToolTipText();
        Date selectedDate = dateChooser.getDate();
        String dob = selectedDate != null ? new SimpleDateFormat("yyyy-MM-dd").format(selectedDate) : "";

        String gender = null;
        if (male.isSelected()){
            gender = "Male";
        }
        else if (female.isSelected()){
            gender = "Female";
        }
        else if (preferNotToSay.isSelected()){
            gender = "Prefer Not To Say";
        }
        String email = emailTextField.getText();
        String marital = null;
        if (married.isSelected()){
            marital = "Married";
        }else if (unmarried.isSelected()){
            marital = "Unmarried";
        } else if (other.isSelected()) {
            marital = "Other";
        }
        String address = addressTextField.getText();
        String province = provinceTextField.getText();
        String city = cityTextField.getText();
        String pcode = pcodeTextField.getText();



        try{
            if (name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is required");
                return;
            }
            if (fname.equals("")){
                JOptionPane.showMessageDialog(null,"Father's Name is required");
                return;
            }
//            if (dob.equals("")){
//                JOptionPane.showMessageDialog(null,"Date of Birth is required");
//            }
            else if (dob.equals("")) {
                JOptionPane.showMessageDialog(null, "Date of Birth is required");
                return;
            }
            if (gender.equals("")){
                JOptionPane.showMessageDialog(null,"Gender is required");
                return;
            }
            if (email.equals("")){
                JOptionPane.showMessageDialog(null,"Email is required");
                return;
            }
            if (marital.equals("")){
                JOptionPane.showMessageDialog(null,"Marital Status is required");
                return;
            }
            if (address.equals("")){
                JOptionPane.showMessageDialog(null,"Address is required");
                return;
            }
            if (province.equals("")){
                JOptionPane.showMessageDialog(null,"Province is required");
                return;
            }
            if (city.equals("")){
                JOptionPane.showMessageDialog(null,"City is required");
                return;
            }
            if (pcode.equals("")){
                JOptionPane.showMessageDialog(null,"Postal Code is required");
                return;
            }
            else {
//                Conn c = new Conn();
//                String query = "insert into signup values('" + formNo + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + province + "','" + city + "','" + pcode + "')";
//                c.st.executeUpdate(query);
//
//                setVisible(false);
//                new SignupTwo(formNo).setVisible(true);

                Conn c = new Conn();
                String query = "insert into signup values('" + formNo + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + province + "','" + city + "','" + pcode + "')";
                c.st.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formNo).setVisible(true);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupOne();
    }

}

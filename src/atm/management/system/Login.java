package atm.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.SelectableChannel;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton LoginButton,SignupButton,clearButton;
    JTextField cardNoTextField;
    JPasswordField pinTextField;

    Login(){ //costructor

        setTitle("Automated Teller Machine");
        setLayout(null);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image image = icon.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon newIcon = new ImageIcon(image);

        //add image lable on frame
        JLabel label = new JLabel(newIcon);
        label.setBounds(70,10,100,100);
        add(label);//put label on the frame

        //add title on frame
        JLabel title = new JLabel("Welcome to ATM");
        title.setFont(new Font("Arial",Font.BOLD,38));
        title.setBounds(200,40,400,40);
        add(title);

        //add card number on frame
        JLabel cardNo = new JLabel("Card No : ");
        cardNo.setFont(new Font("Railway",Font.BOLD,28));
        cardNo.setBounds(120,150,400,30);
        add(cardNo);

        //add pin on frame
        JLabel pin = new JLabel("PIN : ");
        pin.setFont(new Font("Railway",Font.BOLD,28));
        pin.setBounds(120,250,150,30);
        add(pin);

        //make card text field
        cardNoTextField = new JTextField();
        cardNoTextField.setBounds(300,150,297,30);
        cardNoTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardNoTextField);

        //make pin text field
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,250,297,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);


        //make buttons
        //Signin button
        LoginButton = new JButton("Sign In");
        LoginButton.setBounds(200,350,150,30);
        LoginButton.setBackground(Color.BLACK);
        LoginButton.setForeground(Color.WHITE);
        LoginButton.addActionListener(this);
        add(LoginButton);

        //Signup button
        SignupButton = new JButton("Sign Up");
        SignupButton.setBounds(450,350,150,30);
        SignupButton.setBackground(Color.BLACK);
        SignupButton.setForeground(Color.WHITE);
        SignupButton.addActionListener(this);
        add(SignupButton);

        //clear button
        clearButton = new JButton("Clear");
        clearButton.setBounds(325,450,150,30);
        clearButton.setBackground(Color.BLACK);
        clearButton.setForeground(Color.WHITE);
        clearButton.addActionListener(this);
        add(clearButton);

        getContentPane().setBackground(Color.WHITE);


        setSize(800,600);//frame size
        setVisible(true);//frame visibility
        setLocation(350,200);//set location

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == clearButton){
             cardNoTextField.setText("");
             pinTextField.setText("");
        } else if (ae.getSource() == LoginButton) {

            Conn conn = new Conn();
            String card_number = cardNoTextField.getText();
            String pin = pinTextField.getText();

            String query = "SELECT * FROM login WHERE card_number = '" + card_number + "' AND pin = '" + pin + "'";
            try{
                ResultSet resultSet = conn.st.executeQuery(query);

                if (resultSet.next()){
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null,"Invalid Card Number or PIN.");
                }
            }catch (Exception e){
                System.out.println(e);
            }


        } else if (ae.getSource() == SignupButton) {
                setVisible(false);
                new SignupOne().setVisible(true);



        }
    }

    public static void main(String[] args) {

        new Login();
    }
}

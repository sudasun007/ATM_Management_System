package atm.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame  implements ActionListener {

    JPasswordField pinField,repinField;
    JButton change,back;
    String pin; // instance variable to hold original PIN


    PinChange(String pin){
        this.pin = pin;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);


        JLabel text = new JLabel("Change the PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Railway",Font.BOLD,16));
        text.setBounds(250,280,500,35);
        image.add(text);

        JLabel pintext = new JLabel("New PIN : ");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("Railway",Font.BOLD,16));
        pintext.setBounds(165,320,180,25);
        image.add(pintext);

        pinField = new JPasswordField();
        pinField.setFont(new Font("Railway",Font.BOLD,25));
        pinField.setBounds(330,320,180,25);
        image.add(pinField);

        JLabel repintext = new JLabel("Re-Enter New PIN : ");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("Railway",Font.BOLD,16));
        repintext.setBounds(165,360,180,25);
        image.add(repintext);

        repinField = new JPasswordField();
        repinField.setFont(new Font("Railway",Font.BOLD,25));
        repinField.setBounds(330,360,180,25);
        image.add(repinField);

        change = new JButton("Change");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);



        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){

        if (ae.getSource() == change){
            try{

                String npin = pinField.getText();
                String repin = repinField.getText();

                if(!npin.equals(repin)){
                    JOptionPane.showMessageDialog(null,"Entered PIN do not match.");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter the new PIN.");
                    return;
                }
                if(repin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Re-Enter the new PIN.");
                    return;
                }

                Conn conn = new Conn();
                String query1 = "UPDATE bank SET pin = '" + repin + "' WHERE pin = '" + pin + "'";
                String query2 = "UPDATE login SET pin = '" + repin + "' WHERE pin = '" + pin + "'";
                String query3 = "UPDATE signupThree SET pin_number = '" + repin + "' WHERE pin_number = '" + pin + "'";



                conn.st.executeUpdate(query1);
                conn.st.executeUpdate(query2);
                conn.st.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"PIN has been changed successfully.");
                setVisible(false);
                new Transactions(repin).setVisible(true);


            }catch (Exception e){
                System.out.println(e);
            }
        }else {
            setVisible(false);
            new Transactions("").setVisible(true);
        }

    }


    public static void main(String[] args) {

        new PinChange("").setVisible(true);
    }
}

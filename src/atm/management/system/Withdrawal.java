package atm.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {

    JTextField amount;
    JButton withdraw,back;
    String pin;

    public Withdrawal(String pin){
        this.pin = pin;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);


        JLabel text = new JLabel("Enter the Amount to Withdraw : ");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Railway",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);


        amount = new JTextField();
        amount.setFont(new Font("Railway",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355,485,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);



        setSize(900,900);
        setLocation(300,0);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == withdraw){

            String number = amount.getText();
            Date date = new Date();

            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter the Amount to Withdraw.");
            }else {
                try{
                    Conn conn = new Conn();
                    String query = "INSERT INTO bank (pin, date, type, amount) VALUES('" + pin + "', '" + date + "', 'Withdrawal', '" + number + "')";
                    conn.st.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"RS " +number+ " has been Withdraw successfully.");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);

                }catch (Exception e){
                    System.out.println(e);
//                    JOptionPane.showMessageDialog(null,"Please Enter the Amount to Deposit.");
                }
            }

        } else if (ae.getSource()== back) {
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdrawal("");
    }

}

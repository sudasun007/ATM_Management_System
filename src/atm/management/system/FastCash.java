package atm.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;
import java.sql.ResultSet;


public class FastCash extends JFrame implements ActionListener {

    JButton deposit,withdrawal,back,op1,op2,op3,op4,op5,op6;
    String pin;

    FastCash(String pin){

        this.pin = pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);


        JLabel text = new JLabel("Select Withdrawal Amount");
        text.setBounds(200,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Railway",Font.BOLD,16));
        image.add(text);

        op1 = new JButton("Rs 100");
        op1.setBounds(170,415,150,30);
        op1.addActionListener(this);
        image.add(op1);

        op2 = new JButton("Rs 500");
        op2.setBounds(355,415,150,30);
        op2.addActionListener(this);
        image.add(op2);

        op3 = new JButton("Rs 1000");
        op3.setBounds(170,450,150,30);
        op3.addActionListener(this);
        image.add(op3);

        op4 = new JButton("Rs 2000");
        op4.setBounds(355,450,150,30);
        op4.addActionListener(this);
        image.add(op4);

        op5 = new JButton("Rs 5000");
        op5.setBounds(170,485,150,30);
        op5.addActionListener(this);
        image.add(op5);

        op6 = new JButton("Rs 10000");
        op6.setBounds(355,485,150,30);
        op6.addActionListener(this);
        image.add(op6);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);





        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);



    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==back){
            setVisible(false);
            new Transactions(pin).setVisible(true);

        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn conn = new Conn();
            try{
                ResultSet rs = conn.st.executeQuery("SELECT * FROM bank WHERE pin = '"+pin+"'");
                int balance = 0;
                while (rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance.");
                    return;

                }

                Date date = new Date();
                String query = "INSERT INTO bank VALUES('" + pin + "', '" + date + "', 'Withdrawal', '" + amount + "')";
                conn.st.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs " +amount+ " has been Withdraw successfully.");
                setVisible(false);
                new Transactions(pin).setVisible(true);

            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {

        new FastCash("");
    }
}

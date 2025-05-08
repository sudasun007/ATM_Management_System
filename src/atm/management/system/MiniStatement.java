package atm.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame   {

    MiniStatement(String pin){

        setTitle("Mini Statement");

        setLayout(null);

        JLabel mini = new JLabel();
        add(mini);

        JLabel bank = new JLabel("Ceylon Bank");
        bank.setBounds(140,20,200,20);
        bank.setFont(new Font("Railway",Font.BOLD,16));
        add(bank);

//        JLabel mini = new JLabel();
//        mini.setBounds(20,80,300,20);
//        add(mini);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);


        try {
            Conn conn = new Conn();
            int balance1 = 0;

            ResultSet rs = conn.st.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");

            StringBuilder statement = new StringBuilder();
            statement.append("<html>");

            while (rs.next()) {
                statement.append(rs.getString("date"))
                        .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(rs.getString("type")) // Use "type" instead of "mode" if that's the actual column
                        .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append("Rs ")
                        .append(rs.getString("amount"))
                        .append("<br><br>");


                        if (rs.getString("type").equals("Deposit")){
                            balance1 += Integer.parseInt(rs.getString("amount"));
                        }
                        else {
                            balance1 -= Integer.parseInt(rs.getString("amount"));
                        }
            }
            balance.setText("Your current account balance is Rs : " + balance1);

            statement.append("</html>");
            mini.setText(statement.toString());

        } catch (Exception e) {
            System.out.println(e);
        }



        mini.setBounds(20,110,400,200);



        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

    public static void main(String[] args) {

        new MiniStatement("");
    }
}

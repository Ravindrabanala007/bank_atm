
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class mini_stst extends JFrame implements ActionListener {
    String pin;
    JButton b1, b2;

    mini_stst(String pin) {
        getContentPane().setBackground(new Color(255, 204, 204));
        setSize(400, 600);
        setLocation(20, 20);
        setLayout(null);
        setTitle("ATM TRANSCATIONS");
        this.pin = pin;

        JLabel l1 = new JLabel();
        l1.setBounds(20, 140, 400, 200);
        add(l1);

        JLabel l2 = new JLabel("IRahal Bank");
        l2.setFont(new Font("System", Font.BOLD, 15));
        l2.setBounds(150, 20, 200, 20);
        add(l2);

        JLabel l3 = new JLabel("");
        l3.setBounds(20, 80, 300, 20);
        add(l3);

        JLabel l4 = new JLabel();
        l4.setBounds(20, 400, 300, 20);
        add(l4);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from login where pin ='" + pin + "'");

            while (resultSet.next()) {
                l3.setText("Card number" + resultSet.getString("card_no").substring(0, 4) + "XXXXXXXX"
                        + resultSet.getString("card_no").substring(12));
            }
            if(l3.getText().equals("")){
                l3.setText(pin);
            }

        } catch (Exception E) {
            E.printStackTrace();
        }

        try {
            int balance = 0;
            Conn c1 = new Conn();
            ResultSet resultset = c1.statement.executeQuery("select * from bank where pin ='" + pin + "'");

            while (resultset.next()) {
                l1.setText(l1.getText() + "<html>" + resultset.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + resultset.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultset.getString("amount")
                        + "<br><br><html>");
                if (resultset.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(resultset.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultset.getString("amount"));
                }
            }

            l4.setText(" Your Total Balance" + balance);

        } catch (Exception e) {
            e.printStackTrace();
        }

        b1 = new JButton("Exit");
        b1.setBounds(20, 500, 100, 25);
        b1.setForeground(Color.white);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            setVisible(false);
            new Main_Class(pin);

        }
    }

    public static void main(String[] args) {
        new mini_stst("1234");
    }

}

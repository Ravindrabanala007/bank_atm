import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Fast_cash extends JFrame implements ActionListener {

    JButton b1, b2, b3, b4, b5, b6, b7;
    String pin;
    JLabel l2;

    Fast_cash(String pin) {
        setSize(1550, 1080);
        setLocation(0, 0);
        setLayout(null);
        setTitle("ATM TRANSCATIONS");
        this.pin = pin;

        ImageIcon icon = new ImageIcon(
                "C:\\Users\\ravin\\OneDrive\\Desktop\\java\\java_bank_project\\bank_icon\\atm2.png");
        Image scaledImage = icon.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(0, 0, 1550, 830);
        add(imageLabel);
        JLabel l1 = new JLabel("SELECT WITHDRAWAL AMOUNT");
        l1.setFont(new Font("System", Font.BOLD, 18));
        l1.setBounds(450, 180, 700, 35);
        l1.setForeground(Color.white);
        imageLabel.add(l1);

        l2 = new JLabel();
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setBounds(450, 220, 700, 35);
        l2.setForeground(Color.white);
        imageLabel.add(l2);
        int balance = 0;
        try {
            Conn c1 = new Conn();
            ResultSet resultset = c1.statement.executeQuery("select * from bank where pin ='" + pin + "'");

            while (resultset.next()) {
                if (resultset.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(resultset.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultset.getString("amount"));
                }
            }
            l2.setText("CURRENT BALANCE :" + balance);
        } catch (Exception E) {
            E.printStackTrace();
        }

        b1 = new JButton("RS. 100");
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setForeground(Color.white);
        b1.setBackground(new Color(65, 125, 128));
        b1.setBounds(410, 274, 150, 35);
        b1.addActionListener(this);
        imageLabel.add(b1);

        b2 = new JButton("RS. 500");
        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setForeground(Color.white);
        b2.setBackground(new Color(65, 125, 128));
        b2.setBounds(660, 274, 180, 35);
        b2.addActionListener(this);
        imageLabel.add(b2);

        b3 = new JButton("RS. 1000");
        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setForeground(Color.white);
        b3.setBackground(new Color(65, 125, 128));
        b3.setBounds(410, 318, 150, 35);
        b3.addActionListener(this);
        imageLabel.add(b3);

        b4 = new JButton("RS. 2000");
        b4.setFont(new Font("Arial", Font.BOLD, 14));
        b4.setForeground(Color.white);
        b4.setBackground(new Color(65, 125, 128));
        b4.setBounds(660, 318, 180, 35);
        b4.addActionListener(this);
        imageLabel.add(b4);

        b5 = new JButton("RS. 5000");
        b5.setFont(new Font("Arial", Font.BOLD, 14));
        b5.setForeground(Color.white);
        b5.setBackground(new Color(65, 125, 128));
        b5.setBounds(410, 364, 150, 35);
        b5.addActionListener(this);
        imageLabel.add(b5);

        b6 = new JButton("RS. 10,000");
        b6.setFont(new Font("Arial", Font.BOLD, 14));
        b6.setForeground(Color.white);
        b6.setBackground(new Color(65, 125, 128));
        b6.setBounds(660, 364, 180, 35);
        b6.addActionListener(this);
        imageLabel.add(b6);
        b7 = new JButton("BACK");
        b7.setFont(new Font("Arial", Font.BOLD, 14));
        b7.setForeground(Color.white);
        b7.setBackground(new Color(65, 125, 128));
        b7.setBounds(660, 406, 180, 35);
        b7.addActionListener(this);
        imageLabel.add(b7);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b7) {
            setVisible(false);
            new Main_Class(pin);
        } else {
            try {
                String amount = ((JButton) e.getSource()).getText().substring(4);
                Date date = new Date();
                Conn c1 = new Conn();
                ResultSet resultset = c1.statement.executeQuery("select * from bank where pin ='" + pin + "'");
                int balance1 = 0;

                while (resultset.next()) {
                    if (resultset.getString("type").equals("Deposit")) {
                        balance1 += Integer.parseInt(resultset.getString("amount"));
                    } else {
                        balance1 -= Integer.parseInt(resultset.getString("amount"));
                    }
                }
                String num = "17";
                if (e.getSource() != b7 && balance1 < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                c1.statement.executeUpdate(
                        "insert into bank values('" + pin + "','" + date + "','Withdrawl','" + amount + "')");
                JOptionPane.showMessageDialog(null, "Rs." + amount + "Debited  Successfully");

                setVisible(false);
                new Main_Class(pin);

            } catch (Exception E) {
                E.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new Fast_cash("1234");
    }

}

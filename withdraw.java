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
import javax.swing.JTextField;

public class withdraw extends JFrame implements ActionListener {

    String pin;
    JTextField t1;
    JButton b1, b2;

    withdraw(String pin) {
        setSize(1550, 1000);
        setLocation(0, 0);
        setLayout(null);
        setTitle("DEPOSIT");
        this.pin = pin;

        ImageIcon icon = new ImageIcon(
                "C:\\Users\\ravin\\OneDrive\\Desktop\\java\\java_bank_project\\bank_icon\\atm2.png");
        Image scaledImage = icon.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(0, 0, 1550, 830);
        add(imageLabel);
        JLabel l1 = new JLabel("MAXIMUM WITDRAW IS RS.10,000");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(460, 180, 700, 35);
        l1.setForeground(Color.white);
        imageLabel.add(l1);
        JLabel l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setBounds(460, 220, 400, 35);
        l2.setForeground(Color.white);
        imageLabel.add(l2);
        t1 = new JTextField();
        t1.setBackground(new Color(65, 125, 128));
        t1.setForeground(Color.white);
        t1.setBounds(460, 260, 320, 25);
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        imageLabel.add(t1);

        b1 = new JButton("CASH WITHDRAW");
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setForeground(Color.white);
        b1.setBackground(new Color(65, 125, 128));
        b1.setBounds(660, 362, 180, 35);
        b1.addActionListener(this);
        imageLabel.add(b1);

        b2 = new JButton("BACK");
        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setForeground(Color.white);
        b2.setBackground(new Color(65, 125, 128));
        b2.setBounds(660, 406, 180, 35);
        b2.addActionListener(this);
        imageLabel.add(b2);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String amount = t1.getText();
            Date date = new Date();
            if (e.getSource() == b1) {
                if (t1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter the Amount you want to withdrawal");
                } else {
                    Conn c1 = new Conn();
                    ResultSet resultset = c1.statement.executeQuery("select * from bank where pin ='" + pin + "'");
                    int balance = 0;
                    while (resultset.next()) {
                        if (resultset.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(resultset.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(resultset.getString("amount"));
                        }
                    }
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    c1.statement.executeUpdate(
                            "insert into bank values('" + pin + "','" + date + "','Withdrawl','" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs." + amount + "Debited  Successfully");

                    new Main_Class(pin);
                    setVisible(false);

                }

            } else if (e.getSource() == b2) {
                setVisible(false);
                new Main_Class(pin);
            }

        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new withdraw("1234");
    }

}

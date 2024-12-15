import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class deposit extends JFrame implements ActionListener {
    String pin;
    JTextField t1;
    JButton b1, b2;

    deposit(String pin) {
        setSize(1550, 1000);
        setLocation(0, 0);
        setLayout(null);
        setTitle("ATM");
        this.pin = pin;

        ImageIcon icon = new ImageIcon(
                "C:\\Users\\ravin\\OneDrive\\Desktop\\java\\java_bank_project\\bank_icon\\atm2.png");
        Image scaledImage = icon.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(0, 0, 1550, 830);
        add(imageLabel);
        JLabel l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(460, 180, 400, 35);
        l1.setForeground(Color.white);
        imageLabel.add(l1);
        t1 = new JTextField();
        t1.setBackground(new Color(65, 125, 128));
        t1.setForeground(Color.white);
        t1.setBounds(460, 230, 320, 25);
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        imageLabel.add(t1);

        b1 = new JButton("DEPOSIT");
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setForeground(Color.white);
        b1.setBackground(new Color(65, 125, 128));
        b1.setBounds(700, 362, 150, 35);
        b1.addActionListener(this);
        imageLabel.add(b1);

        b2 = new JButton("BACK");
        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setForeground(Color.white);
        b2.setBackground(new Color(65, 125, 128));
        b2.setBounds(700, 406, 150, 35);
        b2.addActionListener(this);
        imageLabel.add(b2);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        try {
            String amount = t1.getText();
            Date date = new Date();
            if (e.getSource() == b1) {
                if (t1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter the Amount");
                } else {
                    Conn c1 = new Conn();
                    c1.statement.executeUpdate(
                            "insert into bank values('" + pin + "','" + date + "','Deposit','" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs." + amount + "Deposited Successfully");
                    setVisible(false);

                }

            } else if (e.getSource() == b2) {
                setVisible(false);

            }
        } catch (Exception E) {
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new deposit("1234");
    }

}


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Balance_Enquiry extends JFrame implements ActionListener {
    String pin;
    JLabel l2;
    JButton b1, b2;

    public Balance_Enquiry(String pin) {
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

        JLabel l1 = new JLabel("CURRENT BALANCE IS Rs ");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(430, 180, 700, 35);
        l1.setForeground(Color.white);
        imageLabel.add(l1);

        l2 = new JLabel();
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setBounds(430, 220, 400, 35);
        l2.setForeground(Color.white);
        imageLabel.add(l2);
        int balance = 0;
        try {
            Conn c1 = new Conn();
            ResultSet resultset = c1.statement.executeQuery("select * from bank where pin ='" + pin + "'");
            
            while (resultset.next()) {
                if (resultset.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(resultset.getString("amount"));
                }
                else {
                    balance -= Integer.parseInt(resultset.getString("amount"));
                }
            }
            l2.setText("" + balance);
        } catch (Exception E) {
            E.printStackTrace();
        }

        b1 = new JButton("BACK");
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setForeground(Color.white);
        b1.setBackground(new Color(65, 125, 128));
        b1.setBounds(660, 406, 180, 35);
        b1.addActionListener(this);
        imageLabel.add(b1);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
       
            if (e.getSource() == b1) {
                new Main_Class(pin);
            }
               
    }
    public static void main(String[] args) {
        new Balance_Enquiry(null);
    }

}

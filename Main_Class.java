import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main_Class extends JFrame implements ActionListener {
    JButton b1, b2, b3, b4, b5, b6, b7;
    String pin;

    Main_Class(String pin) {
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
        JLabel l1 = new JLabel("PLEASE SELECT YOUR TRANSCATION");
        l1.setFont(new Font("System", Font.BOLD, 18));
        l1.setBounds(450, 180, 700, 35);
        l1.setForeground(Color.white);
        imageLabel.add(l1);

        b1 = new JButton("DEPOSIT");
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setForeground(Color.white);
        b1.setBackground(new Color(65, 125, 128));
        b1.setBounds(410, 274, 150, 35);
        b1.addActionListener(this);
        imageLabel.add(b1);

        b2 = new JButton("CASH WITHDRAW");
        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setForeground(Color.white);
        b2.setBackground(new Color(65, 125, 128));
        b2.setBounds(660, 274, 180, 35);
        b2.addActionListener(this);
        imageLabel.add(b2);

        b3 = new JButton("FAST CASH");
        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setForeground(Color.white);
        b3.setBackground(new Color(65, 125, 128));
        b3.setBounds(410, 318, 150, 35);
        b3.addActionListener(this);
        imageLabel.add(b3);

        b4 = new JButton("MINI STATEMENT");
        b4.setFont(new Font("Arial", Font.BOLD, 14));
        b4.setForeground(Color.white);
        b4.setBackground(new Color(65, 125, 128));
        b4.setBounds(660, 318, 180, 35);
        b4.addActionListener(this);
        imageLabel.add(b4);

        b5 = new JButton("PIN CHANGE");
        b5.setFont(new Font("Arial", Font.BOLD, 14));
        b5.setForeground(Color.white);
        b5.setBackground(new Color(65, 125, 128));
        b5.setBounds(410, 364, 150, 35);
        b5.addActionListener(this);
        imageLabel.add(b5);

        b6 = new JButton("BALANCE ENQUIRY");
        b6.setFont(new Font("Arial", Font.BOLD, 14));
        b6.setForeground(Color.white);
        b6.setBackground(new Color(65, 125, 128));
        b6.setBounds(660, 364, 180, 35);
        b6.addActionListener(this);
        imageLabel.add(b6);
        b7 = new JButton("EXIT");
        b7.setFont(new Font("Arial", Font.BOLD, 14));
        b7.setForeground(Color.white);
        b7.setBackground(new Color(65, 125, 128));
        b7.setBounds(660, 406, 180, 35);
        b7.addActionListener(this);
        imageLabel.add(b7);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            new deposit(pin);
            setVisible(false);

        }
        else if(e.getSource()==b2){
            new withdraw(pin);
            setVisible(false);
        }
        else if(e.getSource()==b3){
            
        }
        else if(e.getSource()==b4){
            
        }
        else if(e.getSource()==b5){
            
        }
        else if(e.getSource()==b6){
            new Balance_Enquiry(pin);
            setVisible(false);
        }
        else if(e.getSource()==b7){
            System.exit(0);
        }
    } 

    public static void main(String[] args) {
        new Main_Class("1234");
    }
}
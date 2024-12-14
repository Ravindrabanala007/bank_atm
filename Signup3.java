
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class Signup3 extends JFrame implements ActionListener {
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6;
    JButton submit, clear;

    Signup3() {
        getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setSize(850, 800);
        setLocation(450, 30);

        ImageIcon icon = new ImageIcon(
                "C:\\Users\\ravin\\OneDrive\\Desktop\\java\\java_bank_project\\bank_icon\\bank.png");
        Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(150, 5, 100, 100);
        add(imageLabel);

        setTitle("NEW ACCOUNT");
        JLabel l1 = new JLabel("Page 3:-");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(300, 40, 600, 40);
        add(l1);

        JLabel l2 = new JLabel("ADDITIONAL DETAILS :-");
        l2.setFont(new Font("Raleway", Font.BOLD, 22));
        l2.setBounds(300, 70, 600, 40);
        add(l2);

        JLabel l3 = new JLabel("Account-Type :");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        l3.setBounds(100, 150, 200, 30);
        add(l3);

        r1 = new JRadioButton("Saving-Account");
        r1.setBounds(130, 190, 200, 30);
        r1.setBackground(new Color(222, 255, 228));
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        add(r1);

        r2 = new JRadioButton("Fixed-Deposit");
        r2.setBounds(330, 190, 200, 30);
        r2.setBackground(new Color(222, 255, 228));
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        add(r2);
        r3 = new JRadioButton("Current-Account");
        r3.setBounds(130, 230, 200, 30);
        r3.setBackground(new Color(222, 255, 228));
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        add(r3);

        r4 = new JRadioButton("Recurring-Deposit-Account");
        r4.setBounds(330, 230, 250, 30);
        r4.setBackground(new Color(222, 255, 228));
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        add(r4);
        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(r1);
        bg1.add(r2);
        bg1.add(r3);
        bg1.add(r4);

        JLabel l4 = new JLabel("Card-No :");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        l4.setBounds(100, 290, 200, 30);
        add(l4);

        JLabel l5 = new JLabel("(your 16-Digits Card Number)");
        l5.setFont(new Font("Raleway", Font.BOLD, 12));
        l5.setBounds(100, 320, 200, 20);
        add(l5);

        JLabel l6 = new JLabel("XXXX-XXXX-XXXX-4841");
        l6.setFont(new Font("Raleway", Font.BOLD, 18));
        l6.setBounds(330, 290, 250, 30);
        add(l6);

        JLabel l7 = new JLabel("(It would appear on atm card/Cheque Book and the Statements)");
        l7.setFont(new Font("Raleway", Font.BOLD, 12));
        l7.setBounds(330, 320, 500, 20);
        add(l7);

        JLabel l8 = new JLabel("PIN :");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
        l8.setBounds(100, 370, 200, 30);
        add(l8);
        JLabel l9 = new JLabel("XXXX");
        l9.setFont(new Font("Raleway", Font.BOLD, 18));
        l9.setBounds(330, 370, 200, 30);
        add(l9);

        JLabel l10 = new JLabel("(4-Digits Password)");
        l10.setFont(new Font("Raleway", Font.BOLD, 12));
        l10.setBounds(100, 400, 200, 30);
        add(l10);
        JLabel l11 = new JLabel("Services-Required :");
        l11.setFont(new Font("Raleway", Font.BOLD, 18));
        l11.setBounds(100, 450, 200, 30);
        add(l11);

        c1 = new JCheckBox("ATM Card");
        c1.setBounds(130, 500, 200, 30);
        c1.setBackground(new Color(222, 255, 228));
        c1.setFont(new Font("Raleway", Font.BOLD, 14));
        add(c1);
        c2 = new JCheckBox("Internet Banking");
        c2.setBounds(330, 500, 200, 30);
        c2.setBackground(new Color(222, 255, 228));
        c2.setFont(new Font("Raleway", Font.BOLD, 14));
        add(c2);
        c3 = new JCheckBox("Mobile-Banking");
        c3.setBounds(130, 550, 200, 30);
        c3.setBackground(new Color(222, 255, 228));
        c3.setFont(new Font("Raleway", Font.BOLD, 14));
        add(c3);
        c4 = new JCheckBox("Email-Alerts ");
        c4.setBounds(330, 550, 200, 30);
        c4.setBackground(new Color(222, 255, 228));
        c4.setFont(new Font("Raleway", Font.BOLD, 14));
        add(c4);
        c5 = new JCheckBox("Cheque Book");
        c5.setBounds(130, 600, 200, 30);
        c5.setBackground(new Color(222, 255, 228));
        c5.setFont(new Font("Raleway", Font.BOLD, 14));
        add(c5);
        c6 = new JCheckBox("E-Statement");
        c6.setBounds(330, 600, 200, 30);
        c6.setBackground(new Color(222, 255, 228));
        c6.setFont(new Font("Raleway", Font.BOLD, 14));
        add(c6);
        JCheckBox c7 = new JCheckBox(
                "I here declares that the above entered details correct to the best of my knowledge.", true);
        c7.setBounds(100, 680, 700, 30);
        c7.setBackground(new Color(222, 255, 228));
        c7.setFont(new Font("Raleway", Font.BOLD, 14));
        add(c7);

        JLabel l12 = new JLabel("Form-no :");
        l12.setFont(new Font("Raleway", Font.BOLD, 18));
        l12.setBounds(660, 10, 100, 30);
        add(l12);
        JLabel l13 = new JLabel();
        l13.setFont(new Font("Raleway", Font.BOLD, 18));
        l13.setBounds(760, 10, 60, 30);
        add(l13);

        submit = new JButton("Submit");
        submit.setFont(new Font("Arial", Font.BOLD, 14));
        submit.setForeground(Color.white);
        submit.setBackground(Color.BLACK);
        submit.setBounds(220, 720, 150, 30);
        submit.addActionListener(this);
        add(submit);

        clear = new JButton("Clear");
        clear.setFont(new Font("Arial", Font.BOLD, 14));
        clear.setForeground(Color.white);
        clear.setBackground(Color.BLACK);
        clear.setBounds(420, 720, 100, 30);
        clear.addActionListener(this);
        add(clear);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new Signup3();
    }
}

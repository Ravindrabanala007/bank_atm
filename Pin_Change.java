
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Pin_Change extends JFrame implements ActionListener {
    String pin;
    JButton b1, b2;
    JPasswordField p1, p2;

    public Pin_Change(String pin) {

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

        JLabel l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD, 18));
        l1.setBounds(430, 180, 700, 35);
        l1.setForeground(Color.white);
        imageLabel.add(l1);

        JLabel l2 = new JLabel("New Pin: ");
        l2.setFont(new Font("System", Font.BOLD, 18));
        l2.setBounds(430, 220, 200, 35);
        l2.setForeground(Color.white);
        imageLabel.add(l2);

        p1 = new JPasswordField();
        p1.setForeground(Color.white);
        p1.setBackground(new Color(65, 125, 128));
        p1.setBounds(600, 220, 230, 30);
        p1.setFont(new Font("Arial", Font.BOLD, 14));
        imageLabel.add(p1);

        JLabel l3 = new JLabel("Re-Enter New Pin: ");
        l3.setFont(new Font("System", Font.BOLD, 18));
        l3.setBounds(430, 270, 200, 35);
        l3.setForeground(Color.white);
        imageLabel.add(l3);

        p2 = new JPasswordField();
        p2.setForeground(Color.white);
        p2.setBackground(new Color(65, 125, 128));
        p2.setBounds(600, 270, 230, 30);
        p2.setFont(new Font("Arial", Font.BOLD, 14));
        imageLabel.add(p2);

        b1 = new JButton("CHANGE PIN");
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
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            char[] pinArray1 = p1.getPassword();
            char[] pinArray2 = p2.getPassword();
    
            String pin1 = new String(pinArray1);
            String pin2 = new String(pinArray2);
    
            if (e.getSource() == b1) {
                if (!pin1.equals(pin2)) {
                    JOptionPane.showMessageDialog(null, "Entered PINs do not match");
                    return; // Exit early if PINs don't match
                }
    
                if (pin1.isEmpty() || pin2.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter the PIN");
                    return; // Exit early if PIN fields are empty
                }
    
                Conn c1 = new Conn();
                String query1 = "UPDATE bank SET pin = '" + pin1 + "' WHERE pin = '" + pin + "'";
                String query2 = "UPDATE login SET pin = '" + pin1 + "' WHERE pin = '" + pin + "'";
                String query3 = "UPDATE signup3 SET pin = '" + pin1 + "' WHERE pin = '" + pin + "'";
    
                c1.statement.executeUpdate(query1);
                c1.statement.executeUpdate(query2);
                c1.statement.executeUpdate(query3);
    
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Main_Class(pin);
            } else if (e.getSource() == b2) {
                setVisible(false);
                new Main_Class(pin);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    

    public static void main(String[] args) {
        new Pin_Change("4567");
    }

}

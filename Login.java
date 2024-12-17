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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class Login extends JFrame implements ActionListener {
    JLabel label1, label2, label3;
    JTextField tf1;
    JPasswordField pf1;
    JButton b1, b2, b3;

    Login() {
        setTitle("BANK MANAGEMENT SYSTEM");

        try {
            // Background image
            ImageIcon icon3 = new ImageIcon(
                    "C:\\Users\\ravin\\OneDrive\\Desktop\\java\\java_bank_project\\bank_icon\\backbg.png");
            Image scaledImage3 = icon3.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
            ImageIcon scaledIcon3 = new ImageIcon(scaledImage3);
            JLabel imageLabel3 = new JLabel(scaledIcon3);
            imageLabel3.setBounds(0, 0, 850, 480);
            add(imageLabel3); // Add background first

            // Bank icon
            ImageIcon icon = new ImageIcon(
                    "C:\\Users\\ravin\\OneDrive\\Desktop\\java\\java_bank_project\\bank_icon\\bank.png");
            Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            JLabel imageLabel = new JLabel(scaledIcon);
            imageLabel.setBounds(350, 10, 100, 100);
            imageLabel3.add(imageLabel); // Add to background label

            // Card icon
            ImageIcon icon1 = new ImageIcon(
                    "C:\\Users\\ravin\\OneDrive\\Desktop\\java\\java_bank_project\\bank_icon\\card.png");
            Image scaledImage1 = icon1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);
            JLabel imageLabel1 = new JLabel(scaledIcon1);
            imageLabel1.setBounds(630, 350, 100, 100);
            imageLabel3.add(imageLabel1); // Add to background label

            // Labels
            label1 = new JLabel("WELCOME TO IRAHAL BANK");
            label1.setForeground(Color.WHITE);
            label1.setFont(new Font("AvantGarde", Font.BOLD, 38));
            label1.setBounds(230, 125, 450, 40);
            imageLabel3.add(label1); // Add to background label

            label2 = new JLabel("CARD NO: ");
            label2.setFont(new Font("Ralway", Font.BOLD, 28));
            label2.setForeground(Color.WHITE);
            label2.setBounds(150, 190, 375, 30);
            imageLabel3.add(label2); // Add to background label

            label3 = new JLabel("PIN: ");
            label3.setFont(new Font("Ralway", Font.BOLD, 28));
            label3.setForeground(Color.WHITE);
            label3.setBounds(150, 250, 375, 30);
            imageLabel3.add(label3); // Add to background label

            // textfield
            tf1 = new JTextField();
            tf1.setBounds(320, 190, 230, 30);
            tf1.setFont(new Font("Arial", Font.BOLD, 14));
            imageLabel3.add(tf1);

            // password
            pf1 = new JPasswordField();
            pf1.setBounds(320, 250, 230, 30);
            pf1.setFont(new Font("Arial", Font.BOLD, 14));
            imageLabel3.add(pf1);

            b1 = new JButton("SIGN IN");
            b1.setFont(new Font("Arial", Font.BOLD, 14));
            b1.setForeground(Color.white);
            b1.setBackground(Color.BLACK);
            b1.setBounds(300, 300, 100, 30);
            b1.addActionListener(this);
            imageLabel3.add(b1);

            b2 = new JButton("CLEAR");
            b2.setFont(new Font("Arial", Font.BOLD, 14));
            b2.setForeground(Color.white);
            b2.setBackground(Color.BLACK);
            b2.setBounds(430, 300, 100, 30);
            b2.addActionListener(this);
            imageLabel3.add(b2);

            b3 = new JButton("SIGN UP");
            b3.setFont(new Font("Arial", Font.BOLD, 14));
            b3.setForeground(Color.white);
            b3.setBackground(Color.BLACK);
            b3.setBounds(300, 350, 230, 30);
            b3.addActionListener(this);
            imageLabel3.add(b3);

        } catch (Exception e) {
            System.out.println("Error loading image: " + e.getMessage());
        }

        // Configure frame settings
        setLayout(null);
        setSize(850, 480);
        setLocation(450, 200);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == b1) {
                String cardno=tf1.getText();
                char[] pin1=pf1.getPassword();
                String pin=new String(pin1);

                if (tf1.getText().equals("")|| pin.equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the fields");
                } 
                else {
                // Establish database connection
                Conn con1 = new Conn();
                
                // SQL query with placeholders
                String query = "select * from login where card_no = '"+cardno+"' and pin ='"+pin+"'";
                ResultSet resultSet=con1.statement.executeQuery(query);
                if(resultSet.next()){
                    setVisible(false);
                    new Main_Class(pin);

                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or pin");
                }
              

                setVisible(false);

                // Close resource
                con1.connection.close();
            }   
            } else if (e.getSource() == b2) {
                tf1.setText("");
                pf1.setText("");
            } else if (e.getSource() == b3) {
                new Signup();
                setVisible(false);
            } 
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}

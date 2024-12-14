import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.sql.*;

public class Signup extends JFrame implements ActionListener {
    JRadioButton jr1, jr2, m1, m2, m3;
    JButton b1;
    Random ran = new Random();
    JDateChooser datechoser;
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = "" + Math.abs(first4);

    JTextField t1, t2, t3, t4, t5, t6, t7;

    Signup() {
        setTitle("APPLICATION FORM");
        getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setSize(850, 800);
        setLocation(360, 40);

        ImageIcon icon = new ImageIcon(
                "C:\\Users\\ravin\\OneDrive\\Desktop\\java\\java_bank_project\\bank_icon\\bank.png");
        Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(25, 20, 100, 100);
        add(imageLabel); // Add to background label

        JLabel lab1 = new JLabel("APPLICATION FORM NO-" + first);
        lab1.setBounds(160, 20, 600, 40);
        lab1.setFont(new Font("Raleway", Font.BOLD, 38));
        add(lab1);

        JLabel lab2 = new JLabel("Page 1");
        lab2.setBounds(330, 70, 600, 30);
        lab2.setFont(new Font("Raleway", Font.BOLD, 22));
        add(lab2);

        JLabel lab3 = new JLabel("Personal Details");
        lab3.setBounds(290, 90, 600, 30);
        lab3.setFont(new Font("Raleway", Font.BOLD, 22));
        add(lab3);

        JLabel name = new JLabel("Name : ");
        name.setBounds(100, 190, 100, 30);
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        add(name);

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));
        t1.setBounds(300, 190, 400, 30);
        add(t1);
        // fathers
        JLabel fname = new JLabel("Father's Name : ");
        fname.setBounds(100, 240, 200, 30);
        fname.setFont(new Font("Raleway", Font.BOLD, 22));
        add(fname);
        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));
        t2.setBounds(300, 240, 400, 30);
        add(t2);

        // dob
        JLabel dob1 = new JLabel("D-O-B : ");
        dob1.setBounds(100, 290, 200, 30);
        dob1.setFont(new Font("Raleway", Font.BOLD, 22));
        add(dob1);
        datechoser = new JDateChooser();
        datechoser.setForeground(new Color(105, 105, 105));
        datechoser.setBounds(300, 290, 400, 30);
        add(datechoser);

        JLabel gender = new JLabel("Gender : ");
        gender.setBounds(100, 340, 200, 30);
        gender.setFont(new Font("Raleway", Font.BOLD, 22));
        add(gender);
        jr1 = new JRadioButton("MALE");
        jr1.setBounds(300, 340, 100, 30);
        jr1.setBackground(new Color(222, 255, 228));
        jr1.setFont(new Font("Raleway", Font.BOLD, 14));
        add(jr1);

        jr2 = new JRadioButton("FEMALE");
        jr2.setBounds(410, 340, 100, 30);
        jr2.setBackground(new Color(222, 255, 228));
        jr2.setFont(new Font("Raleway", Font.BOLD, 14));
        add(jr2);
        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(jr1);
        bg1.add(jr2);

        JLabel email1 = new JLabel("E-mail Address : ");
        email1.setBounds(100, 390, 200, 30);
        email1.setFont(new Font("Raleway", Font.BOLD, 22));
        add(email1);
        t3 = new JTextField();
        t3.setFont(new Font("Raleway", Font.BOLD, 14));
        t3.setBounds(300, 390, 400, 30);
        add(t3);

        JLabel maried = new JLabel("Married Status : ");
        maried.setBounds(100, 440, 200, 30);
        maried.setFont(new Font("Raleway", Font.BOLD, 22));
        add(maried);
        m1 = new JRadioButton("MARRIED");
        m1.setBounds(300, 440, 100, 30);
        m1.setBackground(new Color(222, 255, 228));
        m1.setFont(new Font("Raleway", Font.BOLD, 14));
        add(m1);
        m2 = new JRadioButton("UNMARRIED");
        m2.setBounds(410, 440, 150, 30);
        m2.setBackground(new Color(222, 255, 228));
        m2.setFont(new Font("Raleway", Font.BOLD, 14));
        add(m2);
        m3 = new JRadioButton("OTHER");
        m3.setBounds(540, 440, 100, 30);
        m3.setBackground(new Color(222, 255, 228));
        m3.setFont(new Font("Raleway", Font.BOLD, 14));
        add(m3);
        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(m1);
        bg2.add(m2);
        bg2.add(m3);

        JLabel add = new JLabel("Address : ");
        add.setBounds(100, 490, 200, 30);
        add.setFont(new Font("Raleway", Font.BOLD, 22));
        add(add);
        t5 = new JTextField();
        t5.setFont(new Font("Raleway", Font.BOLD, 14));
        t5.setBounds(300, 490, 400, 30);
        add(t5);

        JLabel city = new JLabel("City : ");
        city.setBounds(100, 540, 200, 30);
        city.setFont(new Font("Raleway", Font.BOLD, 22));
        add(city);
        t6 = new JTextField();
        t6.setFont(new Font("Raleway", Font.BOLD, 14));
        t6.setBounds(300, 540, 400, 30);
        add(t6);

        JLabel state = new JLabel("State : ");
        state.setBounds(100, 590, 200, 30);
        state.setFont(new Font("Raleway", Font.BOLD, 22));
        add(state);
        t7 = new JTextField();
        t7.setFont(new Font("Raleway", Font.BOLD, 14));
        t7.setBounds(300, 590, 400, 30);
        add(t7);

        JLabel pin = new JLabel("Pin-Code : ");
        pin.setBounds(100, 640, 200, 30);
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        add(pin);
        t4 = new JTextField();
        t4.setFont(new Font("Raleway", Font.BOLD, 14));
        t4.setBounds(300, 640, 400, 30);
        add(t4);
        b1 = new JButton("NEXT");
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setForeground(Color.white);
        b1.setBackground(Color.BLACK);
        b1.setBounds(620, 710, 80, 30);
        b1.addActionListener(this);
        add(b1);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String formno = first;
            String name = t1.getText();
            String fname = t2.getText();
            String dob = ((JTextField) datechoser.getDateEditor().getUiComponent()).getText();
            String gender = (jr1.isSelected()) ? "Male" : jr2.isSelected() ? "Female" : "null";
            String email = t3.getText();
            String mari = m1.isSelected() ? "Married" : m2.isSelected() ? "UnMarried" : "Other";
            String add = t5.getText();
            String city = t6.getText();
            String state = t7.getText();
            String pin = t4.getText();

            if (t1.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the fields");
            } else {

                // Establish database connection
                Conn con1 = new Conn();

                // SQL query with placeholders
                String query = "INSERT INTO signup (form_no, name, father_name, DOB, gender, Email, Married_status, address, city, State, pin) "
                        +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                // Use PreparedStatement to set parameters safely
                PreparedStatement pstmt = con1.connection.prepareStatement(query);
                pstmt.setString(1, formno); // Replace 'formno' with the correct variable
                pstmt.setString(2, name);
                pstmt.setString(3, fname);
                pstmt.setString(4, dob);
                pstmt.setString(5, gender);
                pstmt.setString(6, email);
                pstmt.setString(7, mari);
                pstmt.setString(8, add);
                pstmt.setString(9, city);
                pstmt.setString(10, state);
                pstmt.setString(11, pin);

                // Execute the query
                pstmt.executeUpdate();

                // Proceed to next step
                new Signup2(first);
                setVisible(false);

                // Close resources
                pstmt.close();
                con1.connection.close();
            }

        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new Signup();
    }
}

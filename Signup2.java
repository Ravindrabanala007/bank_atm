
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Signup2 extends JFrame implements ActionListener {
    String formno;
    JComboBox combobox, c2, c3, c4, c5;
    JTextField t1, t2;
    JRadioButton r1, r2, r3, r4;
    JButton next;

    public Signup2(String first) {
        getContentPane().setBackground(new Color(252, 208, 76));
        setLayout(null);
        setSize(850, 750);
        setLocation(450, 80);

        ImageIcon icon = new ImageIcon(
                "C:\\Users\\ravin\\OneDrive\\Desktop\\java\\java_bank_project\\bank_icon\\bank.png");
        Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(150, 5, 100, 100);
        add(imageLabel);
        formno = first;

        setTitle("NEW ACCOUNT");
        JLabel l1 = new JLabel("Page 2:-");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(300, 30, 600, 40);
        add(l1);

        JLabel l2 = new JLabel("ADDITIONAL DETAILS :-");
        l2.setFont(new Font("Raleway", Font.BOLD, 22));
        l2.setBounds(300, 60, 600, 40);
        add(l2);

        JLabel l3 = new JLabel("Religion :");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        l3.setBounds(100, 120, 100, 30);
        add(l3);

        String rel[] = { "HINDU", "MUSLIM", "SIKH", "CHRISTIAN", "OTHER" };

        combobox = new JComboBox(rel);
        combobox.setBackground(new Color(252, 208, 76));
        combobox.setFont(new Font("Raleway", Font.BOLD, 14));
        combobox.setBounds(300, 120, 320, 30);
        add(combobox);

        JLabel l4 = new JLabel("Catagory :");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        l4.setBounds(100, 170, 100, 30);
        add(l4);
        String rel2[] = { "GENERAL", "OBC", "SC", "ST", "OTHER" };

        c2 = new JComboBox(rel2);
        c2.setBackground(new Color(252, 208, 76));
        c2.setFont(new Font("Raleway", Font.BOLD, 14));
        c2.setBounds(300, 170, 320, 30);
        add(c2);

        JLabel l5 = new JLabel("Income :");
        l5.setFont(new Font("Raleway", Font.BOLD, 18));
        l5.setBounds(100, 220, 100, 30);
        add(l5);
        String rel3[] = { "NULL", "<1,00,000", "<2,50,000", "5,00,000", "upto 10,00,000", "above 10,00,000" };

        c3 = new JComboBox(rel3);
        c3.setBackground(new Color(252, 208, 76));
        c3.setFont(new Font("Raleway", Font.BOLD, 14));
        c3.setBounds(300, 220, 320, 30);
        add(c3);

        JLabel l6 = new JLabel("Educational :");
        l6.setFont(new Font("Raleway", Font.BOLD, 18));
        l6.setBounds(100, 270, 150, 30);
        add(l6);

        String edu[] = { "Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "otehrs" };

        c4 = new JComboBox(edu);
        c4.setBackground(new Color(252, 208, 76));
        c4.setFont(new Font("Raleway", Font.BOLD, 14));
        c4.setBounds(300, 270, 320, 30);
        add(c4);

        JLabel l7 = new JLabel("Occupation :");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));
        l7.setBounds(100, 320, 150, 30);
        add(l7);

        String occu[] = { "Salaried", "Self-Employed", "Business", "Student", "Retired", "other" };

        c5 = new JComboBox(occu);
        c5.setBackground(new Color(252, 208, 76));
        c5.setFont(new Font("Raleway", Font.BOLD, 14));
        c5.setBounds(300, 320, 320, 30);
        add(c5);

        JLabel l8 = new JLabel("Pan No :");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
        l8.setBounds(100, 370, 150, 30);
        add(l8);

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));
        t1.setBounds(300, 370, 320, 30);
        add(t1);

        JLabel l9 = new JLabel("Aadhar No :");
        l9.setFont(new Font("Raleway", Font.BOLD, 18));
        l9.setBounds(100, 420, 150, 30);
        add(l9);

        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));
        t2.setBounds(300, 420, 320, 30);
        add(t2);

        JLabel l10 = new JLabel("Senior-citizen :");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));
        l10.setBounds(100, 470, 150, 30);
        add(l10);

        r1 = new JRadioButton("Yes");
        r1.setBounds(300, 470, 100, 30);
        r1.setBackground(new Color(252, 208, 76));
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        add(r1);

        r2 = new JRadioButton("No");
        r2.setBounds(430, 470, 100, 30);
        r2.setBackground(new Color(252, 208, 76));
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        add(r2);
        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(r1);
        bg1.add(r2);

        JLabel l11 = new JLabel("Exisiting-Account :");
        l11.setFont(new Font("Raleway", Font.BOLD, 18));
        l11.setBounds(100, 520, 200, 30);
        add(l11);

        r3 = new JRadioButton("Yes");
        r3.setBounds(300, 520, 100, 30);
        r3.setBackground(new Color(252, 208, 76));
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        add(r3);

        r4 = new JRadioButton("No");
        r4.setBounds(430, 520, 100, 30);
        r4.setBackground(new Color(252, 208, 76));
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        add(r4);
        ButtonGroup bg2 = new ButtonGroup();
        bg1.add(r3);
        bg1.add(r4);

        JLabel l12 = new JLabel("Form-no :");
        l12.setFont(new Font("Raleway", Font.BOLD, 18));
        l12.setBounds(660, 10, 100, 30);
        add(l12);
        JLabel l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway", Font.BOLD, 18));
        l13.setBounds(760, 10, 60, 30);
        add(l13);

        next = new JButton("NEXT");
        next.setFont(new Font("Arial", Font.BOLD, 14));
        next.setForeground(Color.white);
        next.setBackground(Color.BLACK);
        next.setBounds(620, 600, 80, 30);
        next.addActionListener(this);
        add(next);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            String form_no = formno;
            String rel = (String) combobox.getSelectedItem();
            String cato = (String) c2.getSelectedItem();
            String educ = (String) c4.getSelectedItem();
            String incom = (String) c3.getSelectedItem();
            String occup = (String) c5.getSelectedItem();
            String pan_no = t1.getText();
            String aadhar_no = t2.getText();
            String Senio = r1.isSelected() ? "yes" : r1.isSelected() ? "No" : "NULL";
            String Ex_acc = r3.isSelected() ? "yes" : r4.isSelected() ? "No" : "NULL";

            if (t1.getText().equals("") || t2.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the fields");
            } else {

                // Establish database connection
                Conn con1 = new Conn();

                // SQL query with placeholders
                String query = "INSERT INTO signup2(form_no, religion,caegory, income, education, occupation, pan, aadhar,sinor_citizen, Existing_acc) "
                        +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                // Use PreparedStatement to set parameters safely
                PreparedStatement pstmt = con1.connection.prepareStatement(query);
                pstmt.setString(1, formno); // Replace 'formno' with the correct variable
                pstmt.setString(2, rel);
                pstmt.setString(3, cato);
                pstmt.setString(4, incom);
                pstmt.setString(5, educ);
                pstmt.setString(6, occup);
                pstmt.setString(7, pan_no);
                pstmt.setString(8, aadhar_no);
                pstmt.setString(9, Senio);
                pstmt.setString(10, Ex_acc);

                // Execute the query
                pstmt.executeUpdate();

                // Proceed to next step
                new Signup3(formno);

                setVisible(false);

                // Close resources
                pstmt.close();
                con1.connection.close();
            }

        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup2("1234");
    }

}

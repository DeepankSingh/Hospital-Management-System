package hospital_management_system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField textField;
    JPasswordField passwordField;
    JButton b1, b2;

    Login(){

        JLabel namelable = new JLabel("Username");
        namelable.setBounds(40, 20, 100, 30);
        namelable.setFont(new Font("Tahoma", Font.BOLD, 16));
        namelable.setForeground(Color.black);
        add(namelable);

        JLabel passwordlable = new JLabel("Password");
        passwordlable.setBounds(40, 70, 100, 30);
        passwordlable.setFont(new Font("Tahoma", Font.BOLD, 16));
        passwordlable.setForeground(Color.black);
        add(passwordlable);

        textField = new JTextField();
        textField.setBounds(150, 20, 150, 30);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField.setBackground(new Color(255,179,0));
        add(textField);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 150, 30);
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        passwordField.setBackground(new Color(255,179,0));
        add(passwordField);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(300, 300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(320, -30, 400, 300);
        add(label);

        b1 = new JButton("Login");
        b1.setBounds(40, 140, 120, 30);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(180, 140, 120, 30);
        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);


        getContentPane().setBackground(new Color(9,124,84,255));
        //every code will come above these lines otherwise they wouldn't be visible
        setSize(750,300);
        setLocation(400,270);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
    new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1){
            try{
                conn c = new conn();
                String user = textField.getText();
                String Pass = passwordField.getText();

                String q = "select * from login where ID='"+user+"' and PW='"+Pass+"'";
                ResultSet resultSet = c.statement.executeQuery(q);

                if (resultSet.next()){
                    new Reception();
                    setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            System.exit(10);

        }
    }
}


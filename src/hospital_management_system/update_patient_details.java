package hospital_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class update_patient_details extends JFrame {

    update_patient_details(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(90, 156, 163));
        panel.setBounds(5, 5, 940, 490);
        add(panel);


        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500, 60, 300,300);
        panel.add(label);

        JLabel label1 = new JLabel("Update Patient Details");
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setBounds(100, 10,260, 25);
        label1.setForeground(Color.WHITE);
        panel.add(label1);


        JLabel label2 = new JLabel("Name");
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setBounds(20, 100,100,25);
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(248, 100, 100, 300);
        panel.add(choice);
        try {
            conn con = new conn();
            ResultSet resultSet = con.statement.executeQuery("select * from Patient_Info");
            while (resultSet.next()){
                choice.add(resultSet.getString("Name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }



        JLabel label3 = new JLabel("Room Number");
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setForeground(Color.WHITE);
        label3.setBounds(20, 150,150,25);
        panel.add(label3);

        JTextField textFieldR = new JTextField();
        textFieldR.setBounds(248,150,140,20);
        panel.add(textFieldR);



        JLabel label4 = new JLabel("In-Time");
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setForeground(Color.WHITE);
        label4.setBounds(20, 200,100,25);
        panel.add(label4);

        JTextField textFieldIn = new JTextField();
        textFieldIn.setBounds(248,200,140,20);
        panel.add(textFieldIn);


        JLabel label5 = new JLabel("Amount paid (Rs)");
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        label5.setForeground(Color.WHITE);
        label5.setBounds(20, 250,150,25);
        panel.add(label5);

        JTextField textFieldA = new JTextField();
        textFieldA.setBounds(248,250,140,20);
        panel.add(textFieldA);

        JLabel label6 = new JLabel("Pending Amount (Rs)");
        label6.setFont(new Font("Tahoma", Font.BOLD, 14));
        label6.setForeground(Color.WHITE);
        label6.setBounds(20, 300,200,25);
        panel.add(label6);

        JTextField textFieldP = new JTextField();
        textFieldP.setBounds(248,300,140,20);
        panel.add(textFieldP);


        JButton button1 = new JButton("Update");
        button1.setFont(new Font("Tahoma", Font.BOLD, 14));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(70, 350, 100, 25);
        panel.add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conn c = new conn();
                    String q = choice.getSelectedItem();
                    String room = textFieldR.getText();
                    String time = textFieldIn.getText();
                    String amount = textFieldA.getText();
                    c.statement.executeUpdate("update Patient_Info set Room_Number = '"+room+"', Time = '"+time+"', Deposite = '"+amount+"' where name = '"+q+"'");
                    JOptionPane.showMessageDialog(null, "Updated Sucessfully");
                    setVisible(false);
                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });


        JButton button2 = new JButton("Back");
        button2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(220, 350, 100, 25);
        panel.add(button2);
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        JButton button3 = new JButton("Check");
        button3.setFont(new Font("Tahoma", Font.BOLD, 14));
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.setBounds(400, 350, 100, 25);
        panel.add(button3);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String q = "select * from Patient_Info where Name='"+id+"'";

                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    while (resultSet.next()){
                        textFieldR.setText(resultSet.getString("Room_Number"));
                        textFieldIn.setText(resultSet.getString("Time"));
                        textFieldA.setText(resultSet.getString("Deposite"));
                    }
                    ResultSet resultSet1 = c.statement.executeQuery("select * from room where room_no='"+textFieldR.getText()+"'");
                    while (resultSet1.next()){
                        String price = resultSet1.getString("Price");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(textFieldA.getText());
                        textFieldP.setText(""+amountPaid);
                    }



                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });









        setUndecorated(true);
        setSize(950,500);
        setLayout(null);
        setLocation(400, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new update_patient_details();
    }

}

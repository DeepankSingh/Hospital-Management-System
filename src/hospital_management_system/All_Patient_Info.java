package hospital_management_system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class All_Patient_Info extends JFrame {

    All_Patient_Info(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,990, 590);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,40,900,163);
        table.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(table);

        try{
            conn c = new conn();
            String q = "select * from Patient_Info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("ID");
        label1.setFont(new Font("Tahoma", Font.BOLD, 12));
        label1.setBounds(31,11,100,14);
        panel.add(label1);

        JLabel label2 = new JLabel("Number");
        label2.setFont(new Font("Tahoma", Font.BOLD, 12));
        label2.setBounds(150,11,100,14);
        panel.add(label2);

        JLabel label3 = new JLabel("Name");
        label3.setFont(new Font("Tahoma", Font.BOLD, 12));
        label3.setBounds(270,11,100,14);
        panel.add(label3);

        JLabel label4 = new JLabel("Gender");
        label4.setFont(new Font("Tahoma", Font.BOLD, 12));
        label4.setBounds(360,11,100,14);
        panel.add(label4);

        JLabel label5 = new JLabel("Disease");
        label5.setFont(new Font("Tahoma", Font.BOLD, 12));
        label5.setBounds(490,11,100,14);
        panel.add(label5);

        JLabel label6 = new JLabel("Room");
        label6.setFont(new Font("Tahoma", Font.BOLD, 12));
        label6.setBounds(600,11,100,14);
        panel.add(label6);

        JLabel label7 = new JLabel("Time");
        label7.setFont(new Font("Tahoma", Font.BOLD, 12));
        label7.setBounds(700,11,100,14);
        panel.add(label7);

        JLabel label18 = new JLabel("Deposit");
        label18.setFont(new Font("Tahoma", Font.BOLD, 12));
        label18.setBounds(800,11,100,14);
        panel.add(label18);

        JButton button = new JButton("Back");
        button.setBounds(430, 400, 100, 30);
        button.setFont(new Font("Tahoma", Font.BOLD, 14));
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(900, 600);
        setLayout(null);
        setLocation(300,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new All_Patient_Info();
    }
}

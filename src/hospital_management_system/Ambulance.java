package hospital_management_system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Ambulance extends javax.swing.JFrame {

    Ambulance(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(90,156,163));
        panel.setBounds(5,5,990,590);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,40,900,100);
        table.setBackground(new Color(90,156,163));
        table.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(table);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * from Ambulance");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Name");
        label1.setFont(new Font("Tahoma", Font.BOLD, 18));
        label1.setBounds(10,7,100,30);
        panel.add(label1);

        JLabel label2 = new JLabel("Gender");
        label2.setFont(new Font("Tahoma", Font.BOLD, 18));
        label2.setBounds(200,7,100,30);
        panel.add(label2);

        JLabel label3 = new JLabel("Car Name");
        label3.setFont(new Font("Tahoma", Font.BOLD, 18));
        label3.setBounds(380,7,100,30);
        panel.add(label3);

        JLabel label4 = new JLabel("Available");
        label4.setFont(new Font("Tahoma", Font.BOLD, 18));
        label4.setBounds(550,7,100,30);
        panel.add(label4);

        JLabel label5 = new JLabel("Location");
        label5.setFont(new Font("Tahoma", Font.BOLD, 18));
        label5.setBounds(750,7,100,30);
        panel.add(label5);


        JButton back = new JButton("Back");
        back.setFont(new Font("Tahoma", Font.BOLD, 18));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(500,500,100,30);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });






        setUndecorated(true);
        setSize(900,600);
        setLayout(null);
        setLocation(300,200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ambulance();
    }
}

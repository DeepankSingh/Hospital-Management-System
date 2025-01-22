package hospital_management_system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame {


    Choice choice;
    JTable table;
    SearchRoom(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(90,156,163));
        add(panel);

        JLabel For = new JLabel("Search For Room");
        For.setBounds(250,11,186,20);
        For.setFont(new Font("Tahoma",Font.BOLD,20));
        For.setForeground(Color.WHITE);
        panel.add(For);


        JLabel Status = new JLabel("Status :");
        Status.setBounds(100,70,60,30);
        Status.setFont(new Font("Tahoma",Font.BOLD,14));
        Status.setForeground(Color.WHITE);
        panel.add(Status);

        choice = new Choice();
        choice.setBounds(170,75,120,20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);


        table = new JTable();
        table.setBounds(0, 187, 700, 210);
        table.setBackground(new Color(90,156,163));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try {
            conn c = new conn();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e) {
            e.printStackTrace();
        }


        JLabel label1 = new JLabel("Room Number");
        label1.setBounds(5,155,120,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        label1.setForeground(Color.BLACK);
        panel.add(label1);

        JLabel label2 = new JLabel("Status");
        label2.setBounds(180,155,120,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.BLACK);
        panel.add(label2);

        JLabel label3 = new JLabel("Price");
        label3.setBounds(350,155,120,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.BLACK);
        panel.add(label3);

        JLabel label4 = new JLabel("Type");
        label4.setBounds(530,155,120,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.BLACK);
        panel.add(label4);

        JButton Search = new JButton("Search");
        Search.setBounds(200,420,120,25);
        Search.setForeground(Color.WHITE);
        Search.setBackground(Color.BLACK);
        panel.add(Search);
        Search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String q = "select * from Room where Availability = '"+choice.getSelectedItem()+"'";
                try{
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));

                }catch (Exception E){
                    E.printStackTrace();
                }
            }

        });

        JButton Back = new JButton("Back");
        Back.setBounds(380,420,120,25);
        Back.setForeground(Color.WHITE);
        Back.setBackground(Color.BLACK);
        panel.add(Back);
        Back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });



        setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setLocation(450, 250);
        setVisible(true);
    }
    public static void main(String[] args) {
        new SearchRoom();
    }
}

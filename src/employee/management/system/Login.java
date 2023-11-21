package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {
    JTextField tuse;
    JPasswordField tpas;
    JButton login,back;
    Login(){

        JLabel username = new JLabel("Username");
        username.setBounds(40,20,100,30);
        add(username);

        tuse= new JTextField("username",16);
        tuse.setBounds(150,20,150,30);
        add(tuse);

        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        add(password);

         tpas = new JPasswordField(16);
         tpas.setText("password");
        tpas.setDocument(new Limit(18));
         tpas.setBounds(150,70,150,30);
         add(tpas);

         login = new JButton("Login");
         login.setBounds(150,140,150,30);
         login.setBackground(Color.black);
         login.setForeground(Color.white);
         login.addActionListener(this);
         add(login);


        back = new JButton("Back");
        back.setBounds(150,180,150,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i22 = i11.getImage().getScaledInstance(600,400, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel img = new JLabel(i33);
        img.setBounds(350,10,600,400);
        add(img);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,600,300);
        add(image);



        setSize(600,300);
        setLocation(450,200);
        setLayout(null);
        setVisible(true);
        setBackground(Color.BLACK);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login){
            try{
                String username = tuse.getText();
                String pword = tpas.getText();

                conn conn = new conn();

                String query ="select * from login where username ='"+username+"'and password = '"+pword+"'";
                ResultSet resultSet = conn.statement.executeQuery(query);
                if(resultSet.next()){
                    setVisible(false);
                    new Main();
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid username or Password");
                }

            }catch (Exception E){
                E.printStackTrace();
            }

        }else if(e.getSource()==back){
            System.exit(90);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}

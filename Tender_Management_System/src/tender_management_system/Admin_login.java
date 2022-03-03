package tender_management_system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.regex.*;
public class Admin_login extends JFrame implements ActionListener{    
    JLabel email_lb;
    JLabel password_lb;
    JLabel l1;    
    JTextField email_tf;
    JPasswordField password_tf;    
    JButton login;
    JButton back;    
    Admin_login()
    {
        email_lb=new JLabel("EMAIL ID");
        password_lb=new JLabel("PASSWORD");       
        email_lb.setForeground(Color.WHITE);
        password_lb.setForeground(Color.WHITE);       
        email_tf=new JTextField();
        password_tf=new JPasswordField();        
        login=new JButton("LOG IN");
        back=new JButton("GO BACK");        
        email_lb.setBounds(50,50,120,40);
        password_lb.setBounds(50,150,120,40);
        email_tf.setBounds(230,50,200,40);
        password_tf.setBounds(230,150,200,40);
        login.setBounds(120,300,120,40);
        back.setBounds(300,300,120,40);        
        add(email_lb);
        add(password_lb);
        add(email_tf);
        add(password_tf);
        add(login);
        add(back);
        JLabel background;
        ImageIcon img = new ImageIcon ("C:\\Users\\Dell\\Pictures\\tender images\\Login.jpeg");
        background =new JLabel (img) ;
        background. setBounds (0,0,1200,800);
        add (background);       
        setTitle("ADMIN LOGIN");
        setSize(600, 600);
        getContentPane().setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);       
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){               
                new Menu();
                dispose();
            }       
        });
        login.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        Object obj_source=ae.getSource();
        if(obj_source==login){        
        try{
                String str_email=email_tf.getText();
                String str_password=password_tf.getText();
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/navin?characterEncoding=latin1","root", "Navin@12123");
                String query="select Email_ID,Admin_Password from Admin_Login where Email_ID=? and Admin_Password=?";
                PreparedStatement pstmt=con.prepareStatement(query);
                pstmt.setString(1, str_email);
                pstmt.setString(2, str_password);
                ResultSet res=pstmt.executeQuery();
                String email="^[A-Za-z0-9+_.]+@(.+)$";
                Pattern epat=Pattern.compile(email);
                Matcher ematch=epat.matcher(email_tf.getText());
                if(ematch.matches())
                {
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Invalid email id");
                }
                if(res.next())
                    {
                        JOptionPane.showMessageDialog(this,"Logged in successfully!!!");
                        new Admin_Action();
                        dispose();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this,"Check Email id and password");
                    }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        }
    }
    public static void main(String args[])
    {
        new Admin_login();
    }
}
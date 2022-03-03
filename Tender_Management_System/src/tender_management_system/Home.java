package tender_management_system;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;
import static java.lang.System.in;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.Action;
import java.sql.*;
public class Home extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,background,label;
    JButton menu,aboutus,feedback,logout;   
    Home(){
        aboutus=new JButton("About Us");
        aboutus.setBounds(1000,320,120, 50);
        add(aboutus);
        menu=new JButton("Menu");
        menu.setBounds(1000,180,120, 50);
        add(menu);
        logout=new JButton("Logout");
        logout.setBounds(1000,620,120, 50);
        add(logout);
        feedback=new JButton("Feedback");
        feedback.setBounds(1000,470, 120, 50);
        add(feedback);
        setTitle(" HOME PAGE ");        
        ImageIcon img1 = new ImageIcon("C:\\Users\\Dell\\Pictures\\tender images\\Logo.jpg"); 
        label=new JLabel("", img1, JLabel. CENTER);
        label.setSize (200,200);
        add (label) ;
        ImageIcon img = new ImageIcon ("C:\\Users\\Dell\\Pictures\\tender images\\Home.jpeg") ;
        background =new JLabel (img) ;
        background. setBounds (0,0,1200,800);
        add (background);
        setSize(1200,800);  
        setLayout(null);  
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        menu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                new Menu();
                dispose();
            }
        });
     feedback.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                new Feedback();
                dispose();
            }
        });
     logout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){ 
                JOptionPane.showMessageDialog(rootPane,"Thank you!!!");
                dispose();
            }
        });
    aboutus.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                new AboutUs();
                dispose();
            }
        });
}
    public static void main(String[] args) {
		new Home();
	}
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }  
}
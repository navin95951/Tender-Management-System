package tender_management_system;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
public class Menu extends JFrame {
    JFrame f2 ;
     Menu(){
  JLabel v1,v2,v3,v4;
  v3=new JLabel("....  Menu ....");
  v3.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
  v3.setForeground(Color.WHITE);
  JButton vb1,vb2,vb3,vb4;
  v1=new JLabel("If you are Admin  , click ");
  v1.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
  v1.setForeground(Color.WHITE);
  v2=new JLabel("If you are User , click");
  v2.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
  v2.setForeground(Color.WHITE);
  v4=new JLabel("If you are Supplier, click");
  v4.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
  v4.setForeground(Color.WHITE);
  vb1=new JButton("Admin");
  vb2=new JButton("User");
  vb3=new JButton("Go Back");
  vb4=new JButton("Supplier");
  v3.setBounds(530,35,150,50);
  v1.setBounds(450, 120, 500, 30);
  vb1.setBounds(640, 175, 100, 40);
  v2.setBounds(450,250,500,30);
  vb2.setBounds(640,305,100,40);
  v4.setBounds(450,380,500,30);
  vb4.setBounds(640,435,110,40);
  vb3.setBounds(850,580,120,40);
  add(v1);add(vb1);add(v2);add(vb2);add(v3);add(vb3);add(v4);add(vb4);
  setSize(1200,720);
  setLayout(null);  
  setVisible(true);
  setTitle(" MENU ");
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  setLocationRelativeTo(null);
  vb3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                new Home();
                dispose();
            }
        });
  vb1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                new Admin_login();
                dispose();
            }
        });
  vb2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                new Userlogin();
                dispose();
            }
        });
  vb4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                new Supplierlogin();
                dispose();
            }
        });
  JLabel background;
        ImageIcon img = new ImageIcon ("C:\\Users\\Dell\\Pictures\\tender images\\Menu.jpeg") ;
        background =new JLabel (img) ;
        background. setBounds (0,0,1200,720);
        add (background);
}
public static void main(String args[]){  
   new  Menu();  
}
}
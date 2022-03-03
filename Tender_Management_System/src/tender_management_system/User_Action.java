package tender_management_system;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
public class User_Action extends JFrame {
    JFrame f2 ;
    User_Action(){
  JLabel v1,v2,v3,v4;
  v3=new JLabel("......  User Action ......");
  v3.setFont(new Font("Bookman Old Style", Font.PLAIN, 30));
  v3.setForeground(Color.WHITE);
  JButton vb1,vb2,vb3,vb4;
  v1=new JLabel("To create Tender  , click ");
  v1.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
  v1.setForeground(Color.WHITE);
  v2=new JLabel("To view Bidding Details, click");
  v2.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
  v2.setForeground(Color.WHITE);
  v4=new JLabel("To approve or reject Tender , click");
  v4.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
  v4.setForeground(Color.WHITE);
  vb1=new JButton("New Tender");
  vb2=new JButton("Bidding ");
  vb3=new JButton("Go Back");
  vb4=new JButton("Select");
  v3.setBounds(420,35,350,50);
  v1.setBounds(400, 120, 500, 30);
  vb1.setBounds(590, 175, 170, 40);
  v2.setBounds(400,250,500,30);
  vb2.setBounds(590,305,170,40);
  v4.setBounds(400,380,500,30);
  vb4.setBounds(590,435,170,40);
  vb3.setBounds(850,580,170,40);
  add(v1);add(vb1);add(v2);add(vb2);add(v3);add(vb3);add(v4);add(vb4);
  setSize(1200,800);
  setLayout(null);  
  setVisible(true);
  setTitle(" User Action ");
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  setLocationRelativeTo(null);
  vb3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                new Userlogin();
                dispose();
            }
        });
  vb1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                new User_Tender();
                dispose();
            }
        });
  vb2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                new ViewForm_UBiddingValues1();
                dispose();
            }
        });
  vb4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                new Tender_Result();
                dispose();
            }
        });
        JLabel background;
        ImageIcon img = new ImageIcon ("C:\\Users\\Dell\\Pictures\\tender images\\Action.jpg") ;
        background =new JLabel (img) ;
        background. setBounds (0,0,1200,800);
        add (background);
}
public static void main(String args[]){  
   new  User_Action();  
}
}
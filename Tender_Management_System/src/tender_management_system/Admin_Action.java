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
public class  Admin_Action extends JFrame {
      JFrame f2 ;
      Admin_Action(){
  JLabel v1,v2,v3,v4,v5;
  v3=new JLabel("....  Admin Action ....");
  v3.setFont(new Font("Bookman Old Style", Font.PLAIN, 30));
  v3.setForeground(Color.white);
  JButton vb1,vb2,vb3,vb4,vb5;
  v1=new JLabel("To view Tender Details , click ");
  v1.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
  v1.setForeground(Color.white);
  v2=new JLabel("To view Supplier Details  , click");
  v2.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
  v2.setForeground(Color.white);
  v4=new JLabel("To view Bidding Details, click");
  v4.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
  v4.setForeground(Color.white);
  v5=new JLabel("To view Result Details, click");
  v5.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
  v5.setForeground(Color.white);
  vb1=new JButton("View Tender");
  vb2=new JButton("Supplier Details");
  vb3=new JButton("Go Back");
  vb4=new JButton("Bidding Detais");
  vb5=new JButton("Status");
  v3.setBounds(470,35,350,55);
  v1.setBounds(400, 120, 500, 30);
  vb1.setBounds(590, 175, 170, 40);
  v2.setBounds(400,250,500,30);
  vb2.setBounds(590,305,170,40);
  v4.setBounds(400,380,500,30);
  vb4.setBounds(590,435,170,40);
  v5.setBounds(400,490,500,30);
  vb5.setBounds(590,560,170,40);
  vb3.setBounds(850,620,150,40);
  add(v1);add(vb1);add(v2);add(vb2);add(v3);add(vb3);add(v4);add(vb4);
  add(v5);add(vb5);
  setSize(1200,800); 
  setLayout(null);  
  setVisible(true);
  setTitle(" Admin_Action ");
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  setLocationRelativeTo(null);
  vb3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){ 
                new Admin_login();
                dispose();
            }
        });
  vb1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                new View_User_Tender();
                dispose();
            }
        });
  vb2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                new View_Supplier_Details();
                dispose();
            }
        });
  vb4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                new ViewForm_BiddingValues1();
                dispose();
            }
        });
  vb5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                new ViewForm_TenderResult();
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
   new Admin_Action();  
}
}
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
public class  Supplier_Action extends JFrame {
  JLabel background;
  JFrame f2 ;
  Supplier_Action(){
  JLabel v1,v2,v3,v4;
  v3=new JLabel("....Supplier Action....");
  v3.setFont(new Font("Bookman Old Style", Font.PLAIN, 30));
  v3.setForeground(Color.WHITE);
  JButton vb1,vb2,vb3,vb4;
  v1=new JLabel("To view Tender Details , click ");
  v1.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
  v1.setForeground(Color.WHITE);
  v2=new JLabel("To Apply Tender  , click");
  v2.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
  v2.setForeground(Color.WHITE);
  v4=new JLabel("To view Result Details, click");
  v4.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
  v4.setForeground(Color.WHITE);  
  vb1=new JButton("View Tender");
  vb2=new JButton("Apply Tender");
  vb3=new JButton("Go Back");
  vb4=new JButton("Status");
  v3.setBounds(485,35,350,55);
  v1.setBounds(450, 120, 500, 30);
  vb1.setBounds(640, 175, 150, 40);
  v2.setBounds(450,250,500,30);
  vb2.setBounds(640,305,150,40);
  v4.setBounds(450,380,500,30);
  vb4.setBounds(640,435,150,40);
  vb3.setBounds(850,580,150,40);
  add(v1);add(vb1);add(v2);add(vb2);add(v3);add(vb3);add(v4);add(vb4);
  setSize(1200,800);  
  setLayout(null);  
  setVisible(true);
  setTitle(" Supplier_Action ");
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  setLocationRelativeTo(null);
  vb3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){               
                new Supplierlogin();
                dispose();
            }       
        }); 
  vb1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){                
                new View_User_STender();
                dispose();
            }       
        });  
  vb2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                new Apply_Tender();
                dispose();
            }        
        });  
  vb4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                new ViewForm_STenderResult();
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
   new   Supplier_Action();  
}
}
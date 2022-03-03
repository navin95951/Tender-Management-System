package tender_management_system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.regex.*;
public class Feedback extends JFrame implements ActionListener{
    JLabel lbl_Role = new JLabel("ROLE");
    JLabel lbl_ID = new JLabel("ID");
    JLabel lbl_Tender_ID = new JLabel("TENDER ID");
    JLabel lbl_Feedback = new JLabel("FEEDBACK");
    JTextField txt_ID = new JTextField();
    JTextArea txt_Feedback = new JTextArea();
    ButtonGroup buttongroup;
    JComboBox jcb_Role,jcb_Tender_ID;
    JButton register,back;
    Feedback()
    {
        buttongroup = new ButtonGroup();
        jcb_Role = new JComboBox();
        jcb_Tender_ID = new JComboBox();
        jcb_Role.addItem("User");
        jcb_Role.addItem("Supplier");
        register=new JButton("SUBMIT");
        back=new JButton("GO BACK");
        lbl_Role.setBounds(20,100,120,25);
        lbl_ID.setBounds(20,200,120,25);
        lbl_Tender_ID.setBounds(20,300,120,25);
        lbl_Feedback.setBounds(20,400,60,25);
        txt_ID.setBounds(230,200,120,25);
        txt_Feedback.setBounds(230, 400,120,80);
        jcb_Role.setBounds(230, 100, 120, 25);
        jcb_Tender_ID.setBounds(230, 300, 120, 25);
        register.setBounds(230, 550, 120, 25);
        back.setBounds(350, 550, 120, 25);
        add(lbl_Role);
        add(lbl_ID);
        add(lbl_Tender_ID);
        add(lbl_Feedback);
        add(txt_ID);
        add(txt_Feedback);
        add(jcb_Role);
        add(jcb_Tender_ID);
        add(register);
        add(back);        
        JLabel background;
        ImageIcon img = new ImageIcon ("C:\\Users\\Dell\\Pictures\\tender images\\Feedback.jpeg") ;
        background =new JLabel (img) ;
        background. setBounds (0,0,1200,720);
        add (background);
         try{
                   Class.forName("com.mysql.jdbc.Driver");
                   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/navin?characterEncoding=latin1","root", "Navin@12123");
                   String query="select Tender_ID from User_Tender";
                   PreparedStatement pstmt=con.prepareStatement(query);
                   ResultSet rst=pstmt.executeQuery();                   
                   while(rst.next()){
                      jcb_Tender_ID.addItem(rst.getInt("Tender_ID"));
                   }
                   jcb_Tender_ID.addActionListener((ActionListener) this);
            }
            catch(Exception ex){                
            }
        setTitle("FEEDBACK FORM");
        setSize(1200,720);
        getContentPane().setLayout(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);      
        register.addActionListener(this);
        back.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==register)
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/navin?characterEncoding=latin1","root", "Navin@12123");
                PreparedStatement ps=con.prepareStatement("insert into Feedback values(?,?,?,?)");
                ps.setString(1, jcb_Role.getSelectedItem().toString());
                ps.setString(2, txt_ID.getText().toString());
                ps.setString(3, jcb_Tender_ID.getSelectedItem().toString());
                ps.setString(4, txt_Feedback.getText().toString());
                ps.executeUpdate();
                con.setAutoCommit(true);
                JOptionPane.showMessageDialog(this, "THANK YOU FOR YOUR VALUABLE FEEDBACK:)");
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }        
        if(ae.getSource()==back)
        {
            new Home();
            dispose();
        }
    }
    public static void main(String args[])
    {
        new Feedback();
    }
}
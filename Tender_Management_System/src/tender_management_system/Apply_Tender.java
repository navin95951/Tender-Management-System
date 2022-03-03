package tender_management_system;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Apply_Tender extends JFrame implements ActionListener{
    JLabel lbl_Tender_id,lbl_Tender_Name,lbl_Tender_type,lbl_Supplier_id,lbl_Bidding_Value,lbl_Time_Period;
    JTextField txt_Tender_Name,txt_Tender_type,txt_Supplier_id,txt_Bidding_Value;
    ButtonGroup btngroup;
    JComboBox jcb_Time_Period,txt_Tender_id;
    JButton jbtn_submit,jbtn_back;
    Container c;
    public Apply_Tender(){
        c=getContentPane();
        c.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lbl_Tender_id = new JLabel("TENDER ID");
        lbl_Tender_Name = new JLabel("TENDER NAME");
        lbl_Tender_type = new JLabel("TENDER TYPE");
        lbl_Supplier_id = new JLabel("SUPPLIER ID");
        lbl_Bidding_Value = new JLabel("BIDDING VALUE");
        lbl_Time_Period = new JLabel("TIME PERIOD");
        txt_Tender_id = new JComboBox();
        txt_Tender_Name = new JTextField();
        txt_Tender_type = new JTextField();
        txt_Supplier_id = new JTextField();
        txt_Bidding_Value = new JTextField();
        btngroup=new ButtonGroup();
        jcb_Time_Period=new JComboBox();
        jcb_Time_Period.addItem("Within a month");
        jcb_Time_Period.addItem("6 to 8 months");
        jcb_Time_Period.addItem("1 to 2 years");
        jcb_Time_Period.addItem("2 to 3 years");
        jcb_Time_Period.addItem("More than 3 years");
        jbtn_submit=new JButton("SUBMIT");
        jbtn_back=new JButton("GO BACK");
        jbtn_submit.addActionListener(this);
        jbtn_back.addActionListener(this);
        lbl_Tender_id.setBounds(100, 80, 200, 25);
        lbl_Tender_Name.setBounds(100, 160, 200, 25);
        lbl_Tender_type.setBounds(100, 240, 200, 25);
        lbl_Supplier_id.setBounds(100, 320, 200, 25);
        lbl_Bidding_Value.setBounds(100, 400, 200, 25);
        lbl_Time_Period.setBounds(100, 480, 200, 25);
        jbtn_submit.setBounds(300, 600, 150, 25);
        jbtn_back.setBounds(450, 600, 150, 25);
        txt_Tender_id.setBounds(250, 80, 200, 25);
        txt_Tender_Name.setBounds(250, 160, 200, 25);
        txt_Tender_type.setBounds(250, 240, 200, 25);
        txt_Supplier_id.setBounds(250,320, 200, 25);
        txt_Bidding_Value.setBounds(250, 400, 200, 25);
        jcb_Time_Period.setBounds(250, 480, 200, 25);
        c.add(lbl_Tender_id);
        c.add(lbl_Tender_Name);
        c.add(lbl_Tender_type);
        c.add(lbl_Supplier_id);
        c.add(lbl_Bidding_Value);
        c.add(lbl_Time_Period);
        c.add(jbtn_submit);
        c.add(jbtn_back);
        c.add(txt_Tender_id);
        c.add(txt_Tender_Name);
        c.add(txt_Tender_type);
        c.add(txt_Supplier_id);
        c.add(txt_Bidding_Value);
        c.add(jcb_Time_Period);
        JLabel background;
        ImageIcon img = new ImageIcon ("C:\\Users\\Dell\\Pictures\\tender images\\Applytender.jpg") ;
        background =new JLabel (img) ;
        background. setBounds (0,0,1200,800);
        add (background);
            try{
                   Class.forName("com.mysql.jdbc.Driver");
                   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/navin?characterEncoding=latin1","root", "Navin@12123");
                   String query="select Tender_ID from User_Tender";
                   PreparedStatement pstmt=con.prepareStatement(query);
                   ResultSet rst=pstmt.executeQuery();
                   while(rst.next()){
                       txt_Tender_id.addItem(rst.getInt("Tender_ID"));
                   }
                   txt_Tender_id.addActionListener(this);
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this, " ---------- "+ ex.toString());
            }
        setTitle("APPLY TENDER  FORM");
        setSize(1200, 800);
        setVisible(true);
        setLocationRelativeTo(null);        
    }
    public void actionPerformed(ActionEvent e){
        Object obj=e.getSource();       
        Object itemselected=e.getSource();
             if(itemselected==txt_Tender_id){
               if(Integer.parseInt(txt_Tender_id.getSelectedItem().toString())>0){    
                try{
                    int int_id=Integer.parseInt(txt_Tender_id.getSelectedItem().toString());
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/navin?characterEncoding=latin1","root", "Navin@12123");
                    String query="select Tender_name,Tender_type from User_Tender where Tender_ID=?";
                    PreparedStatement pstmt=con.prepareStatement(query);
                    pstmt.setInt(1,int_id);
                    ResultSet rst=pstmt.executeQuery();
                    if(rst.next()){
                        txt_Tender_Name.setText(rst.getString("Tender_name"));
                        txt_Tender_type.setText(rst.getString("Tender_type"));
                    }
               }
               catch(Exception ex){
                  JOptionPane.showMessageDialog(this,"@@@@@@@@@@@@@@@"+ ex.toString());
               }
            }
               
        }
        if(obj==jbtn_submit){
            try{
                int int_Tender_ID = Integer.parseInt(txt_Tender_id.getSelectedItem().toString());
                String str_Tender_Name = txt_Tender_Name.getText();
                String str_Tender_type = txt_Tender_type.getText();
                int int_Supplier_id = Integer.parseInt(txt_Supplier_id.getText());
                String str_Bidding_Value = txt_Bidding_Value.getText();
                String str_Time_Period = jcb_Time_Period.getSelectedItem().toString();
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/navin?characterEncoding=latin1","root", "Navin@12123");
                PreparedStatement ps=conn.prepareStatement("insert into Apply_Tender values(?,?,?,?,?,?)");
                ps.setString(1, txt_Tender_id.getSelectedItem().toString());
                ps.setString(2,txt_Tender_Name.getText());
                ps.setString(3,txt_Tender_type.getText());
                ps.setString(4,txt_Supplier_id.getText());
                ps.setString(5,txt_Bidding_Value.getText());
                ps.setString(6,jcb_Time_Period.getSelectedItem().toString());
                ps.executeUpdate();
                conn.setAutoCommit(true);
                JOptionPane.showMessageDialog(this, "APPLICATION SUCCESS!");
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this, ex.toString());
            }
        }
        if(obj==jbtn_back)
        {
            new Supplier_Action();
            dispose();
        }
    } 
    public static void main(String args[]){
        new Apply_Tender();
    }
}
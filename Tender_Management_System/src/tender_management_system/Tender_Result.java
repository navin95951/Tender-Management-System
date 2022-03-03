package tender_management_system;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Tender_Result extends JFrame implements ActionListener{
    JLabel lbl_Tender_id,lbl_Tender_Name,lbl_Tender_type,lbl_bidding,lbl_Supplier_id,lbl_status;
    JTextField txt_Tender_Name,txt_Tender_type,txt_bidding,txt_Supplier_id;
    ButtonGroup btngroup;
    JRadioButton rdb_approve,rdb_reject;
    JComboBox txt_Tender_id;
    JButton jbtn_submit,jbtn_back;
    Container c;
    String str_status="";
    public Tender_Result(){
        c=getContentPane();
        c.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lbl_Tender_id = new JLabel("TENDER ID");
        lbl_Tender_Name = new JLabel("TENDER NAME");
        lbl_Tender_type = new JLabel("TENDER TYPE");
        lbl_bidding = new JLabel("BIDING VALUE");
        lbl_Supplier_id = new JLabel("SUPPLIER ID");
        lbl_status= new JLabel("TENDER STATUS");
        txt_Tender_id = new JComboBox();
        txt_Tender_Name = new JTextField();
        txt_Tender_type = new JTextField();
        txt_bidding = new JTextField();
        txt_Supplier_id = new JTextField();
        btngroup=new ButtonGroup();
        rdb_approve=new JRadioButton("APPROVE");
        rdb_reject=new JRadioButton("REJECT");
        btngroup.add(rdb_approve);
        btngroup.add(rdb_reject);
        jbtn_submit=new JButton("SUBMIT");
        jbtn_back=new JButton("GO BACK");
        jbtn_submit.addActionListener(this);
        jbtn_back.addActionListener(this);
        lbl_Tender_id.setBounds(100, 100, 200, 25);
        lbl_Tender_Name.setBounds(100, 200, 200, 25);
        lbl_Tender_type.setBounds(100, 300, 200, 25);
        lbl_bidding.setBounds(100, 400, 200, 25);
        lbl_Supplier_id.setBounds(100, 500, 200, 25);
        lbl_status.setBounds(700, 100, 120, 25);
        jbtn_submit.setBounds(800, 500, 150, 25);
        jbtn_back.setBounds(950, 500, 150, 25);
        rdb_approve.setBounds(850,100,120,25);
        rdb_reject.setBounds(970,100,120,25);
        txt_Tender_id.setBounds(250, 100, 200, 25);
        txt_Tender_Name.setBounds(250, 200, 200, 25);
        txt_Tender_type.setBounds(250, 300, 200, 25);
        txt_bidding.setBounds(250, 400, 200, 25);
        txt_Supplier_id.setBounds(250, 500, 200, 25);
        c.add(lbl_Tender_id);
        c.add(lbl_Tender_Name);
        c.add(lbl_Tender_type);
        c.add(lbl_bidding);
        c.add(lbl_Supplier_id);
        c.add(lbl_status);
        c.add(rdb_approve);
        c.add(rdb_reject);
        c.add(jbtn_submit);
        c.add(jbtn_back);
        c.add(txt_Tender_id);
        c.add(txt_Tender_Name);
        c.add(txt_Tender_type);
        c.add(txt_bidding);
        c.add(txt_Supplier_id);
        JLabel background;
        ImageIcon img = new ImageIcon ("C:\\Users\\Dell\\Pictures\\tender images\\Registration.jpg") ;
        background =new JLabel (img) ;
        background. setBounds (0,0,1200,800);
        add (background);  
        try{
                   txt_Tender_id.addItem("0");
                   Class.forName("com.mysql.jdbc.Driver");
                   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/navin?characterEncoding=latin1","root", "Navin@12123");
                   String query="select Tender_ID from Apply_Tender where Tender_ID NOT IN(select Tender_ID from Tender_Result)";
                   PreparedStatement pstmt=con.prepareStatement(query);
                   ResultSet rst=pstmt.executeQuery();
                   while(rst.next()){
                       txt_Tender_id.addItem(rst.getInt("Tender_ID"));
                   }
                   txt_Tender_id.addActionListener((ActionListener) this);
            }
            catch(Exception ex){  
            }
        setTitle("TENDER RESULT FORM");
        setSize(1200, 800);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    public void actionPerformed(ActionEvent e){  
        Object itemselected=e.getSource();
             if(itemselected==txt_Tender_id){
               if(Integer.parseInt(txt_Tender_id.getSelectedItem().toString())>0){
                try{
                    int int_eid=Integer.parseInt(txt_Tender_id.getSelectedItem().toString());
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/navin?characterEncoding=latin1","root", "Navin@12123");
                    String query="select Tender_name,Tender_type,Bidding_value,Supplier_ID from Apply_Tender where Tender_ID=?";
                    PreparedStatement pstmt=con.prepareStatement(query);
                    pstmt.setInt(1,int_eid);
                    ResultSet rst=pstmt.executeQuery();
                    if(rst.next()){
                        txt_Tender_Name.setText(rst.getString("Tender_name"));
                        txt_Tender_type.setText(rst.getString("Tender_type"));
                        txt_bidding.setText(rst.getString("Bidding_value"));
                        txt_Supplier_id.setText(rst.getString("Supplier_ID"));
                    }
               }
               catch(Exception ex){
                  JOptionPane.showMessageDialog(this,"@@@@@@@@@@@@@@@"+ ex.toString());
               }
            }
           }
        Object obj=e.getSource();
        if(obj==jbtn_submit){
            try{
                if(rdb_approve.isSelected())
                {
                    str_status="APPROVED";
                }
                else if(rdb_reject.isSelected())
                {
                    str_status="REJECTED";
                }
                int int_Tender_ID = Integer.parseInt(txt_Tender_id.getSelectedItem().toString());
                String str_Tender_Name = txt_Tender_Name.getText();
                String str_Tender_type = txt_Tender_type.getText();
                String str_Requirement = txt_bidding.getText();
                String str_Quantity = txt_Supplier_id.getText();
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/navin?characterEncoding=latin1","root", "Navin@12123");              
                PreparedStatement ps=conn.prepareStatement("insert into Tender_Result values(?,?,?,?,?,?)");
                ps.setString(1, txt_Tender_id.getSelectedItem().toString());
                ps.setString (2,txt_Tender_Name.getText());
                ps.setString(3,txt_Tender_type.getText());
                ps.setString(4,txt_bidding.getText());
                ps.setString(5,txt_Supplier_id.getText());
                ps.setString(6,str_status);
                ps.executeUpdate();
                conn.setAutoCommit(true);
                JOptionPane.showMessageDialog(this, "RESULT UPLOADED!");
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this, ex.toString());
            }
        }
        if(obj==jbtn_back)
        {
            new User_Action();
            dispose();
        }
    }
    public static void main(String args[]){
        new Tender_Result();
    }
}
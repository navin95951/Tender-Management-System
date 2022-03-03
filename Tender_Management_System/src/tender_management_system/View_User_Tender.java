package tender_management_system;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class View_User_Tender extends JFrame{
    JFrame f;
    static JTable table;
    public View_User_Tender() { 
        JComboBox Tender_ID = new JComboBox();
        JLabel Tender_ID1=new JLabel("Enter Tender_ID");
        Tender_ID1.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
        Tender_ID1.setForeground(Color.WHITE);
        Tender_ID1.setBounds(160,70,250,40);
        add( Tender_ID1);
        Tender_ID.setBounds(450,70,190,40);
        add(Tender_ID);
        JButton but,go;
        but=new JButton("view");
        go=new JButton("Go Back");
        but.setBounds(700, 70, 120, 40);
        add(but);
        go.setBounds(900, 620, 160, 40);
        add(go);
        JLabel background;
        ImageIcon img = new ImageIcon ("C:\\Users\\Dell\\Pictures\\tender images\\View.jpeg") ;
        background =new JLabel (img) ;
        background. setBounds (0,0,1200,800);
        add (background); 
        String column[]={"Tender_ID","Tender_Name","Tender_type","Requirement","Quantity","Starting_price","Time_Period","Open_Date","Closing_date"};
        setSize(1200, 800);
        setLayout(null); 
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("TENDER VIEW FORM ");
        go.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                new Admin_Action();
                dispose();
            }
        });
        try{
                   Class.forName("com.mysql.jdbc.Driver");
                   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/navin?characterEncoding=latin1","root", "Navin@12123");
                   String query="select Tender_ID from User_Tender where Tender_ID NOT IN(select Tender_ID from Tender_Result where Tender_Result.Status='APPROVED')";
                   PreparedStatement pstmt=con.prepareStatement(query);
                   ResultSet rst=pstmt.executeQuery();
                   while(rst.next()){
                   Tender_ID.addItem(rst.getInt("Tender_ID"));
                   }
                   Tender_ID.addActionListener((ActionListener) this);
            }
            catch(Exception ex){ 
            }
            but.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                display(Tender_ID.getSelectedItem().toString(),column);
            }
        });
    }
    public void display(String s,String[] column){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/navin?characterEncoding=latin1","root", "Navin@12123");
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(column);
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        String Tender_ID = "";
        String Tender_Name = "";
        String Tender_type = "";
        String Requirement = "";
        String Quantity ="";
        String Starting_price ="";
        String Time_Period ="";
        String Open_Date = "";
        String Closing_Date = "";
        PreparedStatement pst = con.prepareStatement("select * from User_Tender where Tender_ID='" +s+ "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
               Tender_ID  = rs.getString("Tender_ID");
               Tender_Name = rs.getString("Tender_Name");
               Tender_type = rs.getString("Tender_type");
               Requirement = rs.getString("Requirement");
               Quantity = rs.getString("Quantity");
               Starting_price = rs.getString("Starting_price");
               Time_Period  = rs.getString("Time_Period");
               Open_Date  = rs.getString("Open_Date");
               Closing_Date = rs.getString("Closing_Date");
               model.addRow(column);
               model.addRow(new Object[]{Tender_ID,Tender_Name,Tender_type,Requirement,Quantity,Starting_price,Time_Period,Open_Date,Closing_Date});
            }
         add(scroll);
         table.setBounds(50, 140, 900, 70);
         add(table);
        }catch(Exception e) {
         System.out.print(e);
      } 
    }
    public static void main(String[] args) {
        new View_User_Tender();
    } 
}
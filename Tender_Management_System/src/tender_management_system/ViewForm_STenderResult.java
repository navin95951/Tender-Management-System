package tender_management_system;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
public class ViewForm_STenderResult extends JFrame{
    JFrame f;
    static JTable table;
    public ViewForm_STenderResult() {   
        JComboBox Supplier_ID = new JComboBox();
        JLabel userName1=new JLabel("Enter Supplier_ID");
        userName1.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
        userName1.setForeground(Color.white);
        userName1.setBounds(160,70,250,40);add(userName1);Supplier_ID.setBounds(450,70,190,40);add(Supplier_ID);
        JButton but,go;
        but=new JButton("view");
        go=new JButton("Go Back");
        but.setBounds(700, 70, 120, 40);add(but);
        go.setBounds(900, 620, 160, 40);add(go);
        String column[]={"Tender_ID","Tender_Name","Tender_Type","Bidding_value","Supplier_ID","Tender_Status"};
        setSize(1200, 800);
        setLayout(null); 
        setVisible(true);
        setTitle(" VIEW FORM FOR TENDER RESULT");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JLabel background;
        ImageIcon img = new ImageIcon ("C:\\Users\\Dell\\Pictures\\tender images\\View.jpeg") ;
        background =new JLabel (img) ;
        background. setBounds (0,0,1200,800);
        add (background);
        try{
                   Class.forName("com.mysql.jdbc.Driver");
                   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/navin?characterEncoding=latin1","root", "Navin@12123");
                   String query="select Supplier_ID from Tender_Result";
                   PreparedStatement pstmt=con.prepareStatement(query);
                   ResultSet rst=pstmt.executeQuery();
                   while(rst.next()){
                       Supplier_ID.addItem(rst.getInt("Supplier_ID"));
                   }
                   Supplier_ID.addActionListener((ActionListener) this);
            }
            catch(Exception ex){  
            }
        but.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                display(Supplier_ID.getSelectedItem().toString(),column);
            }
        });
        go.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                new Supplier_Action();
                dispose();
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
        String Tender_Type = "";
        String Bidding_value= "";
        String Supplier_ID = "";
        String Tender_Status="";
        PreparedStatement pst = con.prepareStatement("select * from Tender_Result where Supplier_ID='" +s+ "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Tender_ID = rs.getString("Tender_ID");
                Tender_Name = rs.getString("Tender_Name");
                Tender_Type = rs.getString("Tender_Type");
                Bidding_value= rs.getString("Bidding_value");
                Supplier_ID = rs.getString("Supplier_ID");
                Tender_Status = rs.getString("Status");
                model.addRow(column);
                model.addRow(new Object[]{Tender_ID,Tender_Name,Tender_Type,Bidding_value,Supplier_ID,Tender_Status});
            }
            add(scroll);
            table.setBounds(50, 140, 900, 200);
          add(table);
        }catch(Exception e) {
         System.out.print(e);
      } 
    }
    public static void main(String[] args) {
        new ViewForm_STenderResult();
    } 
}
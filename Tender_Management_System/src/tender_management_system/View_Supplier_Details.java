package tender_management_system;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
public class View_Supplier_Details extends JFrame {
    JFrame f;
    static JTable table;
    public View_Supplier_Details() { 
        JComboBox Supplier_ID = new JComboBox();
        JLabel lb_supplier_id=new JLabel("Enter Supplier Id");
        lb_supplier_id.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
        lb_supplier_id.setForeground(Color.WHITE);
        lb_supplier_id.setBounds(70,70,300,40);
        add(lb_supplier_id);
        Supplier_ID.setBounds(450,70,130,40);
        add(Supplier_ID);
        JButton but,go;
        but=new JButton("view");
        but.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
        go=new JButton("Go Back");
        go.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
        but.setBounds(600, 70, 120, 40);
        add(but);
        go.setBounds(900, 620, 160, 40);
        add(go);          
        JLabel background;
        ImageIcon img = new ImageIcon ("C:\\Users\\Dell\\Pictures\\tender images\\View.jpeg") ;
        background =new JLabel (img) ;
        background. setBounds (0,0,1200,800);
        add (background); 
        String column[]={"Supplier_fname","Supplier_lname","Email_ID","Companyname","Role","Gender","Mobile","Address","City","State"};
        setSize(1200, 800);
        setLayout(null); 
        setVisible(true);
        setTitle(" VIEW FORM ");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        try{
                   Class.forName("com.mysql.jdbc.Driver");
                   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/navin?characterEncoding=latin1","root", "Navin@12123");
                   String query="select Supplier_ID from Supplier_Register";
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
                new Admin_Action();
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
        String supplierfname = "";
        String supplierlname = "";
        String EmailID= "";
        String companyname = "";
        String role="";
        String gender="";
        String mobile="";
        String address="";
        String city="";
        String state="";
        PreparedStatement pst = con.prepareStatement("select * from Supplier_Register where Supplier_ID='" +s+ "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                supplierfname = rs.getString("Supplier_fname");
                supplierlname = rs.getString("Supplier_lname");
                EmailID = rs.getString("Email_ID");
                companyname= rs.getString("Company_name");
                role=rs.getString("Supplier_role");
                gender=rs.getString("Gender");
                mobile=rs.getString("Mobile");
                address=rs.getString("Address");
                city=rs.getString("City");
                state=rs.getString("State");
                model.addRow(column);
                model.addRow(new Object[]{supplierfname,supplierlname,EmailID,companyname,role,gender,mobile,address,city,state});
            }
          add(scroll);
          table.setBounds(50, 140, 900, 200);
          add(table);
        }catch(Exception e) {
         System.out.print(e);
      } 
    }
    public static void main(String[] args) {
        new View_Supplier_Details();
    } 
}
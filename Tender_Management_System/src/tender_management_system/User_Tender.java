package tender_management_system;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class User_Tender extends JFrame implements ActionListener{
    JLabel lbl_Tender_id,lbl_Tender_Name,lbl_Tender_type,lbl_Requirement,lbl_Quantity,lbl_Starting_price,lbl_Time_Period,lbl_Open_Date,lbl_Closing_date;
    JTextField txt_Tender_id,txt_Tender_Name,txt_Tender_type,txt_Quantity,txt_Starting_price,txt_Open_Date,txt_Closing_date;
    JTextArea txt_Requirement;
    ButtonGroup btngroup;
    JComboBox day,month, year,cday,cmonth, cyear;
    JComboBox txt_Time_Period;
    JButton jbtn_submit,jbtn_back;
    Container c;
    public User_Tender(){
        c=getContentPane();
        c.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lbl_Tender_id = new JLabel("TENDER ID");
        lbl_Tender_Name = new JLabel("TENDER NAME");
        lbl_Tender_type = new JLabel("TENDER TYPE");
        lbl_Requirement = new JLabel("REQUIREMENT");
        lbl_Quantity = new JLabel("QUANTITY");
        lbl_Starting_price = new JLabel("STARTING PRICE");
        lbl_Time_Period = new JLabel("TIME PERIOD");
        lbl_Open_Date = new JLabel("OPEN DATE");
        lbl_Closing_date = new JLabel("CLOSING DATE");  
        txt_Tender_id = new JTextField();
        txt_Tender_Name = new JTextField();
        txt_Tender_type = new JTextField();
        txt_Requirement = new JTextArea();
        txt_Quantity = new JTextField();
        txt_Starting_price = new JTextField();
        txt_Time_Period = new JComboBox();
        txt_Time_Period.addItem("Within a month");
        txt_Time_Period.addItem("6 to 8 months");
        txt_Time_Period.addItem("1 to 2 years");
        txt_Time_Period.addItem("2 to 3 years");
        txt_Time_Period.addItem("More than 3 years");
        btngroup=new ButtonGroup();
        jbtn_submit=new JButton("SUBMIT");
        jbtn_back=new JButton("GO BACK");
        jbtn_submit.addActionListener(this);
        jbtn_back.addActionListener(this);
        lbl_Tender_id.setBounds(100, 100, 200, 25);
        lbl_Tender_Name.setBounds(100, 200, 200, 25);
        lbl_Tender_type.setBounds(100, 300, 200, 25);
        lbl_Requirement.setBounds(100, 400, 200, 25);
        lbl_Quantity.setBounds(600, 100, 200, 25);
        lbl_Starting_price.setBounds(600, 200, 120, 25);
        lbl_Time_Period.setBounds(600, 300, 200, 25);
        lbl_Open_Date.setBounds(600, 400, 200, 25);
        lbl_Closing_date.setBounds(600, 500, 200, 25);
        jbtn_submit.setBounds(400, 600, 150, 25);
        jbtn_back.setBounds(550, 600, 150, 25);
        txt_Tender_id.setBounds(250, 100, 200, 25);
        txt_Tender_Name.setBounds(250, 200, 200, 25);
        txt_Tender_type.setBounds(250, 300, 200, 25);
        txt_Requirement.setBounds(250, 400, 200, 100);
        txt_Quantity.setBounds(750, 100, 200, 25);
        txt_Starting_price.setBounds(750, 200, 200, 25);
        txt_Time_Period.setBounds(750, 300, 200, 25);
    String days []={"1", "2", "3", "4", "5","6","7","8","9","10", "11", "12", "13", "14","15","16", "17","18","19", "20", "21", "22","23","24","25", "26", "27", "28","29","30","31"};
    String months []={"Jan", "Feb", "Mar", "Apr", "May ", "Jun", "July", "Aug", "Sep", "Oct", "Nov", "Dec" };
    String years [] ={"2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"};
    day=new JComboBox (days);
    month=new JComboBox (months);
    year=new JComboBox (years);
    day.setBounds (750,400,50,20);
    month. setBounds (820,400, 50,20);
    year.setBounds (890,400,60,20);
    c.add (day);
    c.add (month);
    c.add (year);
    cday=new JComboBox (days);
    cmonth=new JComboBox (months);
    cyear=new JComboBox (years);
    cday.setBounds (750,500,50,20);
    cmonth. setBounds (820,500, 50,20);
    cyear.setBounds (890,500,60,20);
    c.add (cday);
    c.add (cmonth);
    c.add (cyear);
    c.add(lbl_Tender_id);
    c.add(lbl_Tender_Name);
    c.add(lbl_Tender_type);
    c.add(lbl_Requirement);
    c.add(lbl_Quantity);
    c.add(lbl_Starting_price);
    c.add(lbl_Time_Period);
    c.add(lbl_Open_Date);
    c.add(lbl_Closing_date);
    c.add(jbtn_submit);
    c.add(jbtn_back);
    c.add(txt_Tender_id);
    c.add(txt_Tender_Name);
    c.add(txt_Tender_type);
    c.add(txt_Requirement);
    c.add(txt_Quantity);
    c.add(txt_Starting_price);
    c.add(txt_Time_Period);
    JLabel background;
    ImageIcon img = new ImageIcon ("C:\\Users\\Dell\\Pictures\\tender images\\Registration.jpg") ;
    background =new JLabel (img) ;
    background. setBounds (0,0,1200,800);
    add (background);   
    setTitle("TENDER REGISTRATION FORM");
    setSize(1200, 800);
    setVisible(true);
    setLocationRelativeTo(null);
    }
    public void actionPerformed(ActionEvent e){
        Object obj=e.getSource();
        if(obj==jbtn_submit){
            try{
                int    int_Tender_ID = Integer.parseInt(txt_Tender_id.getText());
                String str_Tender_Name = txt_Tender_Name.getText();
                String str_Tender_type = txt_Tender_type.getText();
                String str_Requirement = txt_Requirement.getText();
                String str_Quantity = txt_Quantity.getText();
                String str_Starting_price = txt_Starting_price.getText();
                String str_Time_Period = txt_Time_Period.getSelectedItem().toString();
                String str_Open_Date = day.getSelectedItem().toString() +"/" +month.getSelectedItem().toString()+"/"+year.getSelectedItem().toString();
                String str_Closing_date = cday.getSelectedItem().toString() +"/" +cmonth.getSelectedItem().toString()+"/"+cyear.getSelectedItem().toString();                
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/example?characterEncoding=latin1";
                Connection conn=DriverManager.getConnection(url,"root","Navin@12123");                  
                PreparedStatement ps=conn.prepareStatement("insert into User_Tender values(?,?,?,?,?,?,?,?,?)");
                ps.setString(1, txt_Tender_id.getText().toString());              
                ps.setString (2,txt_Tender_Name.getText());
                ps.setString(3,txt_Tender_type.getText());
                ps.setString(4,txt_Requirement.getText());
                ps.setString(5,txt_Quantity.getText());
                ps.setString(6,txt_Starting_price.getText());
                ps.setString(7,txt_Time_Period.getSelectedItem().toString());
                ps.setString(8,day.getSelectedItem().toString() +"/" +month.getSelectedItem().toString()+"/"+year.getSelectedItem().toString());
                ps.setString(9,cday.getSelectedItem().toString() +"/" +cmonth.getSelectedItem().toString()+"/"+cyear.getSelectedItem().toString());
                ps.executeUpdate();
                conn.setAutoCommit(true);
                JOptionPane.showMessageDialog(this, "REGISTRATION SUCCESS!");
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
        new User_Tender();
    }
}
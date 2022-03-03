package tender_management_system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.regex.*;
public class Supplier_register extends JFrame implements ActionListener{
        JLabel supplierid_lb=new JLabel("SUPPLIER ID");
        JLabel supplierfname_lb=new JLabel("FIRST NAME");
        JLabel supplierlname_lb=new JLabel("LAST NAME");
	JLabel companyname_lb=new JLabel("COMPANY NAME");
	JLabel supplierrole_lb=new JLabel("POSITION");
        JLabel gender_lb=new JLabel("GENDER");
        JLabel email_lb=new JLabel("EMAIL ID");
        JLabel password=new JLabel("PASSWORD");
        JLabel confirmPassword=new JLabel("CONFIRM PASSWORD");
        JLabel mobNo=new JLabel("MOBILE NO");
        JLabel address_lb=new JLabel("ADDRESSS");
        JLabel city=new JLabel("CITY");
        JLabel state=new JLabel("STATE");
        JTextField supplierid_tf=new JTextField();
        JTextField supplierfname_tf=new JTextField();
        JTextField supplierlname_tf=new JTextField();
	JTextField companyname_tf=new JTextField();
	JTextField supplierrole_tf=new JTextField();
        JTextArea address_tf=new JTextArea();
        JTextField email_tf=new JTextField();
        JTextField mob_tf=new JTextField();
        JPasswordField password_pf=new JPasswordField();
        JPasswordField conPassword_pf=new JPasswordField();       
        ButtonGroup btngroup;
        JRadioButton male_rb,female_rb;
        JComboBox city_cb,state_cb;      
        String gender="";
        JButton register,reset,back;
        int count=0;   
    Supplier_register()
    {      
        setContentPane(new JLabel(new ImageIcon("E:\\BOOTCAMP\\PROJECT\\Tender management System")));       
        btngroup=new ButtonGroup();
        male_rb=new JRadioButton("Male");
        female_rb=new JRadioButton("Female");
        btngroup.add(male_rb);
        btngroup.add(female_rb);       
        city_cb=new JComboBox();
        state_cb=new JComboBox();      
        city_cb.addItem("Coimbatore");
        city_cb.addItem("Chennai");
        city_cb.addItem("Erode");
        city_cb.addItem("Karur");
        city_cb.addItem("Madurai");
        city_cb.addItem("Namakkal");
        city_cb.addItem("Trichy");
        city_cb.addItem("Salem");
        city_cb.addItem("Kochi");
        city_cb.addItem("Thiruvananthapuram");
        city_cb.addItem("Bangalore");
        city_cb.addItem("Mysore");
        state_cb.addItem("TAMIL NADU");
        state_cb.addItem("KARNATAKA");
        state_cb.addItem("KERALA");      
        register=new JButton("REGISTER");
        reset=new JButton("RESET");
        back=new JButton("GO BACK");       
        supplierid_lb.setBounds(20,50,120,25);
        supplierfname_lb.setBounds(20,125,120,25);
        supplierlname_lb.setBounds(20,200,120,25);
	companyname_lb.setBounds(20,275,120,25);
        gender_lb.setBounds(20,350,60,25);
        address_lb.setBounds(20,425,120,25);
        email_lb.setBounds(600,50,120,25);
        password.setBounds(600,125,120,25);
        confirmPassword.setBounds(600,200,150,25);
	supplierrole_lb.setBounds(600,275,120,25);
        mobNo.setBounds(600,350,120,25);
        city.setBounds(600,425,120,25);
        state.setBounds(600,500,120,25);
        supplierid_tf.setBounds(230, 50, 200, 25);
        supplierfname_tf.setBounds(230, 125, 200, 25);
        supplierlname_tf.setBounds(230, 200, 200, 25);
	companyname_tf.setBounds(230,275,200,25);
        male_rb.setBounds(230, 350, 100, 25);
        female_rb.setBounds(330, 350, 100, 25);
        address_tf.setBounds(230, 425, 200, 120);
        email_tf.setBounds(750, 50, 200, 25);
        password_pf.setBounds(750, 125, 200, 25);
        conPassword_pf.setBounds(750,200,200,25);
	supplierrole_tf.setBounds(750,275,200,25);
        mob_tf.setBounds(750, 350, 200, 25);
        city_cb.setBounds(750, 425, 200, 25);
        state_cb.setBounds(750, 500, 200, 25);
        register.setBounds(350, 600, 120, 25);
        reset.setBounds(550, 600, 120, 25);
        back.setBounds(750, 600, 120, 25);    
        add(supplierid_lb);
        add(supplierfname_lb);
        add(supplierlname_lb);
	add(companyname_lb);
        add(gender_lb);
        add(address_lb);
        add(email_lb);
        add(password);
        add(confirmPassword);
	add(supplierrole_lb);
        add(mobNo);
        add(city);
        add(state);      
        add(supplierid_tf);
        add(supplierfname_tf);
        add(supplierlname_tf);
	add(companyname_tf);
        add(male_rb);
        add(female_rb);
        add(address_tf);
        add(email_tf);
        add(password_pf);
        add(conPassword_pf);
	add(supplierrole_tf);
        add(mob_tf);
        add(city_cb);
        add(state_cb);      
        add(register);
        add(reset);
        add(back);
        JLabel background;
        ImageIcon img = new ImageIcon ("C:\\Users\\Dell\\Pictures\\tender images\\Registration.jpg") ;
        background =new JLabel (img) ;
        background. setBounds (0,0,1200,800);
        add (background);
        setTitle("SUPPLIER REGISTRATION FORM");
        setSize(1200,800);
        getContentPane().setLayout(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);       
        register.addActionListener(this);
        reset.addActionListener(this);
        back.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==register)
        {
            try
            {               
                if(male_rb.isSelected())
                {
                    gender="male";
                }
                else if(female_rb.isSelected())
                {
                    gender="female";
                }
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/navin?characterEncoding=latin1","root", "Navin@12123");
                PreparedStatement ps=conn.prepareStatement("insert into Supplier_Register values(?,?,?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1, supplierid_tf.getText().toString());
                ps.setString(2, supplierfname_tf.getText().toString());
                ps.setString(3, supplierlname_tf.getText().toString());
		ps.setString(4, companyname_tf.getText().toString());
                ps.setString(5, email_tf.getText().toString());
                ps.setString(6, password_pf.getText().toString());
		ps.setString(7, supplierrole_tf.getText().toString());
                ps.setString(8, gender);
                ps.setString(9, mob_tf.getText().toString());
                ps.setString(10, address_tf.getText().toString());
                ps.setString(11, city_cb.getSelectedItem().toString());
                ps.setString(12, state_cb.getSelectedItem().toString());              
                conn.setAutoCommit(true);
                if(password_pf.getText().equalsIgnoreCase(conPassword_pf.getText()))
                {
                    count++;
                }
               else
               {
                    JOptionPane.showMessageDialog(null, "Password did not match");
               }
                String email="^[A-Za-z0-9+_.]+@(.+)$";
                Pattern epat=Pattern.compile(email);
                Matcher ematch=epat.matcher(email_tf.getText());
                if(ematch.matches())
                {
                    count++;
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid email id");
                }
                Pattern pt=Pattern.compile("[6-9][0-9]{9}");
                Matcher pmatch=pt.matcher(mob_tf.getText());
                if(pmatch.find()&&pmatch.group().equals(mob_tf.getText()))
                {
                    count++;
                }
                else
               {
                    JOptionPane.showMessageDialog(null,"Invalid mobile number"); 
                }
               if(count==3)
               {
                   ps.executeUpdate();
                   JOptionPane.showMessageDialog(this,"Registered successfully!!!");
               }
               count=0;
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ae.getSource()==reset)
        {
            supplierid_tf.setText("");
            supplierfname_tf.setText("");
            supplierlname_tf.setText("");
            companyname_tf.setText("");
            address_tf.setText("");
            email_tf.setText("");
            password_pf.setText("");
            conPassword_pf.setText("");
            supplierrole_tf.setText("");
            mob_tf.setText("");
            city_cb.setSelectedItem("Coimbatore");
            state_cb.setSelectedItem("TAMIL NADU");
        }
        if(ae.getSource()==back)
        { 
            new Supplierlogin();
            dispose();
        }
    }
    public static void main(String args[])
    {
        new Supplier_register();
    }
}
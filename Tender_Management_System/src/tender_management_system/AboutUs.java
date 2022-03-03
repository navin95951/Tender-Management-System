package tender_management_system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;
public class AboutUs extends JFrame {
        public static void main(String[] args) {
		new AboutUs().setVisible(true);
	}
        AboutUs() {
               setTitle(" About Tender Management System");
               setSize(900,720);  
               setLayout(null);  
               setVisible(true);
               setDefaultCloseOperation(EXIT_ON_CLOSE);
               setBackground(Color.pink);
	       setLocationRelativeTo(null);
               JButton back;
               back=new JButton("Go Back");
               back.setBounds(700,620,90,40);
               add(back);
               back.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                new Home();
                dispose();
            }
        });
		JLabel lbl_1 = new JLabel("SKI TENDER MANAGEMENT");
		lbl_1.setFont(new Font("Times New Roman", Font.BOLD , 34));
                lbl_1.setForeground(Color.red);
		lbl_1.setBounds(39, 40, 531, 55);
		add(lbl_1);
		JLabel lbl_2 = new JLabel("");
		lbl_2.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
		lbl_2.setBounds(557, 60, 100, 21);
		add(lbl_2);
		JLabel lbl_4 = new JLabel("Contact us : ");
		lbl_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl_4.setBounds(57, 450, 600, 34);
		add(lbl_4);
		JLabel lbl_5 = new JLabel("Mobile : 9876543210");
		lbl_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl_5.setBounds(99,500, 600, 34);
		add(lbl_5);
		JLabel lbl_6 = new JLabel("Instagram : https://www.skitm.com/ski1905");
		lbl_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl_6.setBounds(99, 550, 600, 34);
		add(lbl_6);
                JLabel lbl_7 = new JLabel("email : skitm@gmail.com");
		lbl_7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl_7.setBounds(99, 600, 600, 34);
		add(lbl_7);
                JLabel lbl_8 = new JLabel("Admin: ");
		lbl_8.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl_8.setBounds(70, 122, 600, 35);
		add(lbl_8);
		JLabel lbl_9 = new JLabel("19tucs209 : Sachin");
		lbl_9.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl_9.setBounds(99, 170, 600, 34);
		add(lbl_9);
		JLabel lbl_10 = new JLabel("19tucs207 : Rubini");
		lbl_10.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl_10.setBounds(99, 220, 600, 34);
		add(lbl_10);
                JLabel lbl_11 = new JLabel("19tucs223 : Sneha Dharshini");
		lbl_11.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl_11.setBounds(99, 270, 600, 34);
		add(lbl_11);
                JLabel lbl_12 = new JLabel("19euit114 : Pradeep");
		lbl_12.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl_12.setBounds(99, 320, 600, 34);
		add(lbl_12);
                JLabel lbl_13 = new JLabel("19euit105 : Navin");
		lbl_13.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl_13.setBounds(99, 370, 600, 34);
		add(lbl_13);
                JLabel background;
        ImageIcon img = new ImageIcon ("C:\\Users\\Dell\\Pictures\\tender images\\Aboutus.jpeg") ;
        background =new JLabel (img) ;
        background. setBounds (0,0,900,720);
        add (background);	
	}
}
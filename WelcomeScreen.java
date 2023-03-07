/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_twitt;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
/**
 *
 * @author Lenovo
 */
public class WelcomeScreen extends JFrame {
    private JPanel contentPane;
    static ImageIcon img;
    static JLabel imgLabel;
	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public WelcomeScreen() {
		setBackground(new Color(128, 128, 128));
		setVisible(true);
		setTitle("Twitter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 699);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//img= new ImageIcon("./imagenes/Twittlogot.png");
		imgLabel = new JLabel("");
		imgLabel.setBounds(335, 12, 244, 117);
		contentPane.add(imgLabel);
		JLabel lblWelcome = new JLabel("Welcome To Twitter");
		lblWelcome.setFont(new Font("Dialog", Font.BOLD, 22));
		lblWelcome.setBounds(321, 220, 307, 29);
		contentPane.add(lblWelcome);
		
		JButton loginBtn = new JButton("Login ");
		loginBtn.setBackground(new Color(0, 0, 128));
		loginBtn.setForeground(new Color(255, 255, 255));
		loginBtn.setFont(new Font("Dialog", Font.BOLD, 18));
		loginBtn.setBounds(335, 304, 244, 40);
		contentPane.add(loginBtn);
		loginBtn.addActionListener(new ActionListener(){

	         //defining a method actionPerformed
	        public void actionPerformed(ActionEvent ae){ 
	        //	new SignInScreen();
	        	new SignInScreen();	
	        }});
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setForeground(Color.WHITE);
		btnCreateAccount.setFont(new Font("Dialog", Font.BOLD, 18));
		btnCreateAccount.setBackground(new Color(0, 0, 128));
		btnCreateAccount.setBounds(335, 386, 244, 40);
		contentPane.add(btnCreateAccount);
		btnCreateAccount.addActionListener(new ActionListener(){

	         //defining a method actionPerformed
	        public void actionPerformed(ActionEvent ae){ 
	        	new SignUpScreen();
                   
	        }});
               JButton salirBtn = new JButton("Login ");
		salirBtn.setBackground(new Color(0, 0, 128));
		salirBtn.setForeground(new Color(255, 255, 255));
		salirBtn.setFont(new Font("Dialog", Font.BOLD, 18));
		salirBtn.setBounds(335, 304, 244, 40);
		contentPane.add(salirBtn);
		salirBtn.addActionListener(new ActionListener(){
                     //defining a method actionPerformed
	        public void actionPerformed(ActionEvent ae){ 
	        	new SignUpScreen();
                   
                }
        }};


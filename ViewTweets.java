/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_twitt;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Lenovo
 */
public class ViewTweets extends JFrame {

	private JPanel contentPane;
	String username;
	
	/**
	 * Create the frame.
	 */
	public ViewTweets(String username) {
		this.username = username;
		setBackground(new Color(128, 128, 128));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("View Tweets");
		setVisible(true);
		setBounds(100, 100, 915, 608);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(262, 24, 70, 15);
		contentPane.add(label);
		
		JLabel lblViewTweets = new JLabel("View Tweets");
		lblViewTweets.setFont(new Font("Dialog", Font.BOLD, 20));
		lblViewTweets.setBounds(306, 24, 435, 44);
		contentPane.add(lblViewTweets);
		
		Panel setPanel = new Panel();
		setPanel.setBounds(22, 59, 869, 491);
		  binaryDataStore bn = new binaryDataStore();
		 ArrayList<TweetsDataHolder> tweetData =   bn.getTweetsData(username);
		  JLabel tdLb;
		  JLabel usernameLb;
		  JLabel tweetTimeLb;
		  JSeparator separator;
		  
			int x1= 121;
			int x2= 94;
			int x3 = 94; 
			int x4 = 207;
		  
		  for(int i=tweetData.size()-1;i>=0;i--) {
			  
			 
			    tdLb = new JLabel(tweetData.get(i).getContent());
				tdLb.setBounds(12,  x1, 665, 74);
				setPanel.add(tdLb);
				
				usernameLb = new JLabel(tweetData.get(i).getUsername());
				usernameLb.setBounds(12, x2, 114, 15);
				setPanel.add(usernameLb);
				
				tweetTimeLb = new JLabel(tweetData.get(i).getCreatetime());
				tweetTimeLb.setBounds(528, x3, 126, 15);
				setPanel.add(tweetTimeLb);
				
				separator = new JSeparator();
				separator.setBounds(22, x4, 655, 2);
				setPanel.add(separator);
			  
				 x1+=150;
				   x2+=150;
				   x3+=150;
				   x4+=150;
		  }
		  

		  
		  JScrollPane scrollPane = new JScrollPane(setPanel);
		    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	       scrollPane.setBounds(291, -14,980, 600);
	        contentPane.add(scrollPane);

	}

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_twitt;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.swing.JOptionPane;
/**
 *
 * @author Lenovo
 */
public class binaryDataStore {
	public binaryDataStore() {
        }

	public void WriteUserData(String name,String Username,String gender,String pass,String EntryDate,int age,boolean Accountstatus,String photoAdd) {
		try {
		    // create a writer
		FileOutputStream fos = new FileOutputStream(new File("\\"+"users.twc"),true);
	        DataOutputStream dout=new DataOutputStream(fos);
	        String folderName= Username;
		    name= name+",";
		    Username=Username+",";
		    gender=gender+",";
		    pass=pass+",";
		    EntryDate= EntryDate+",";
		    String ageVal=Integer.toString(age)+",";
		    String status= new Boolean(Accountstatus).toString()+",";
		    photoAdd=photoAdd+",";

		    // write data to file
		    dout.write(name.getBytes());
		    dout.write(Username.getBytes());
		    dout.write(gender.getBytes());
		    dout.write(pass.getBytes());
		    dout.write(EntryDate.getBytes());
		    dout.write(ageVal.getBytes());
		    dout.write(status.getBytes());
		    dout.write(photoAdd.getBytes());
		    dout.write("\n".getBytes());
		    File f1 = new File("//"+folderName);  
		      //Creating a folder using mkdir() method  
		    boolean bool = f1.mkdir();  
		      if(bool){  
		         System.out.println("Folder is created successfully");  
		         File file1 = new File(f1+"/followers.twc");
		         File file2 = new File(f1+"/tweets.twc");
		         File file3 = new File(f1+"/followings.twc");
		         if (file1.createNewFile()&&file2.createNewFile()&&file3.createNewFile()) {
		           System.out.println("File created: " + file1.getName());
		           System.out.println("File created: " + file2.getName());
		           System.out.println("File created: " + file3.getName());
		         } else {
		           System.out.println("File already exists.");
		         }
		      }else{  
		         System.out.println("Error Found!");  
		      }  
		    // close the writer
		    fos.close();
		
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
	}

	public  ArrayList<UserDataClass> readUserDataFromFile() {
		
		 ArrayList<UserDataClass> getUserData= new  ArrayList<UserDataClass>();
		try {
		    // create a reader
		    FileInputStream fis = new FileInputStream(new File("//"+"/users.twc"));
		    
		    // specify UTF_16 characer encoding
		    InputStreamReader reader = new InputStreamReader(fis, StandardCharsets.US_ASCII);

		    // read one byte at a time
		    int ch;
		    String s="";
		    while ((ch = reader.read()) != -1) {
		      // System.out.print((char) ch);
		      s=s+String.valueOf((char)ch); 
		      if((char)ch=='\n') {
		    	 
		    	  String[] allData = s.split(",");
		    	  ArrayList<followerClass> follwersList = readFollowers(allData[1]);
		    	  ArrayList<followingClass> followingList =readFollowings(allData[1]);
		    	 
                          boolean add = getUserData.add(new UserDataClass(allData[0],allData[1],allData[2],allData[3],allData[4],Integer.parseInt(allData[5])
                                  ,new Boolean(allData[6]),allData[7],followingList,follwersList));
		          
		      }
		    }

		    // close the reader
		    reader.close();
		 
		
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
		
		return getUserData;
	}

	public  ArrayList<followerClass>  readFollowers(String username) {

		ArrayList<UserDataClass> userData =Main.UserDataHolder;
		int index=0;
		
		ArrayList<followerClass> follower= new ArrayList<followerClass>();
		
          try {
		    
		    BufferedReader bufReader = new BufferedReader(new FileReader("//"+username+"/followings.twc"));
		    String line = bufReader.readLine();
		    
		    if(userData!=null) {
		    for(int i=0;i<userData.size();i++) {
		    	if(userData.get(i).equals(username)) {
		    		index=i;
		    	}}
		    }
 
		    while (line != null) { 
		    	   String[] res = line.split("[,]", 0);
		    	      
		    	   follower.add(new followerClass(res[0],new Boolean(res[1])));
		    	   }
		    	line = bufReader.readLine();

		    bufReader.close();

		} catch (IOException ex) {
		    ex.printStackTrace();
		}

		return follower;

	}

	public void WriteFollowers(String username,String followerName) {
		try {
			followerName+=",";
		    // create a writer
		    FileOutputStream fos = new FileOutputStream(new File("//"+username+"/followers"),true);
	
	        DataOutputStream dout=new DataOutputStream(fos);
	     
	        dout.write(followerName.getBytes());
	        dout.write("true".getBytes());
		    dout.write("\n".getBytes());
		
		    
		    fos.close();
		
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
	}
	
	
	public void WriteFollowings(String username,String followingName) {
		try {
			followingName +=",";
		    // create a writer
		    FileOutputStream fos = new FileOutputStream(new File("//"+username+"/followers"),true);
	
	        DataOutputStream dout=new DataOutputStream(fos);
	        dout.write(followingName.getBytes());
	        dout.write("true".getBytes());
		dout.write("\n".getBytes());
  
		fos.close();
		
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
	}

	public ArrayList<followingClass> readFollowings(String username) {
		ArrayList<UserDataClass> userData =Main.UserDataHolder;
		int index=0;
		ArrayList<followingClass> following= new ArrayList<followingClass>();
          try {  
		    BufferedReader bufReader = new BufferedReader(new FileReader("//"+username+"/followings.twc"));
		    String line = bufReader.readLine();
		    if(userData!=null) {
		    for(int i=0;i<userData.size();i++) {
		    	if(userData.get(i).equals(username)) {
		    		index=i;}
		    }}
		
		    
		    while (line != null) { 
		    	   String[] res = line.split("[,]", 0);
		    	      
		    	   following.add(new followingClass(res[0],new Boolean(res[1])));
		    	   }
		    	line = bufReader.readLine();
		    bufReader.close();

		} catch (IOException ex) {
		    ex.printStackTrace();}

		return following;	
	}
	public ArrayList<TweetsDataHolder> getTweetsData(String username){
	    ArrayList<TweetsDataHolder> getAllTweets = new ArrayList<TweetsDataHolder>();
		try {
		    
		    BufferedReader bufReader = new BufferedReader(new FileReader("//"+username+"/tweets.twc"));
		    String line = bufReader.readLine();
		    while (line != null&&line!="\n") { 
		    	   String[] res = line.split("[,]", 0);
		    	   ArrayList<String> hashList = new ArrayList<String>();
		    	   ArrayList<String> mentions = new ArrayList<String>();
		    	   if(res[0].equals("Mentions")) {
		    		  
		    	   }else {
		    	   
		    	   for(int i=3;i<res.length;i++) {
		    		   if(res[i].charAt(0)=='#') {
		    			   hashList.add(res[i]); 
		    		   }else  if(res[i].charAt(0)=='@'){
		    			   mentions.add(res[i]);}
		              }
		              getAllTweets.add(new TweetsDataHolder(res[0],res[1],res[2],hashList,mentions));
		    	   }
		    	line = bufReader.readLine();
		    }
		    bufReader.close();
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
		return getAllTweets;
	}
	public ArrayList<TweetsDataHolder> getMentionsTweets(String username) {
		 
		 ArrayList<TweetsDataHolder> getMentionTweets = new ArrayList<TweetsDataHolder>();
			try {
			    
			    BufferedReader bufReader = new BufferedReader(new FileReader("//"+username+"/tweets.twc"));
			    String line = bufReader.readLine();
			    while (line != null) { 
			    	   String[] res = line.split("[,]", 0);
			    	   ArrayList<String> hashList = new ArrayList<String>();
			    	   ArrayList<String> mentions = new ArrayList<String>();
			    	   
			    	   if(res[0].equals("Mentions")) {
			    		   for(int i=4;i<res.length;i++) {
				    		   if(res[i].charAt(0)=='#') {
				    			   hashList.add(res[i]); 
				    		   }else  if(res[i].charAt(0)=='@'){
				    			   mentions.add(res[i]);
				    		   }
				            	 
				              }
				             
				              getMentionTweets.add(new TweetsDataHolder(res[1],res[2],res[3],hashList,mentions));
				    	   
			    	   }else {
			    	   }
			    	line = bufReader.readLine();
			    }
			    bufReader.close();
			} catch (IOException ex) {
			    ex.printStackTrace();
			}
			return getMentionTweets;	
	}
	public void createTweets(String username,String content,String Time, ArrayList<String> hashList,ArrayList<String> Mentions) {
		ArrayList<UserDataClass> userData = readUserDataFromFile();
		try {
		    // create a writer
		    FileOutputStream fos = new FileOutputStream(new File("//"+username+"/tweets.twc"),true);
	
	        DataOutputStream dout=new DataOutputStream(fos);
		    username= username+",";
		    content=content+",";
		    Time=Time+",";
		    dout.write("\n".getBytes());
		    
		    // write data to file
		    dout.write(username.getBytes());
		    dout.write(content.getBytes());
		    dout.write(Time.getBytes());
		    
		    for(int i=0;i<hashList.size();i++) {
		    	String val= hashList.get(i)+",";
		    	  dout.write(val.getBytes());
		    }
		    
		    
		 //   dout.write("".getBytes());
		    
		    for(int i=0;i<Mentions.size();i++) {
		    	  for(int j=0;j<userData.size();j++) {
				    	if(userData.get(j).getUsername().equals(Mentions.get(i))) {
				    		 if(userData.get(j).getUsername().equals(username)) {
				    			 
				    		 }else {
				    			 fos = new FileOutputStream(new File("//"+userData.get(j).getUsername()+"/tweets.twc"),true);	
				    		        dout=new DataOutputStream(fos);
				    		        dout.write("Mentions,".getBytes());
				    		        dout.write(username.getBytes());
				    			    dout.write(content.getBytes());
				    			    dout.write(Time.getBytes());
				    			    dout.write("\n".getBytes());
				    			    for(int k=0;k<hashList.size();k++) {
				    			    	String val= hashList.get(i)+",";
				    			    	  dout.write(val.getBytes());
				    			    }
				    		 }
				    	}
				    }
		    }
		    // close the writer
		    fos.close();
		
		} catch (IOException ex) {
		    ex.printStackTrace();
		}	
	}	
}

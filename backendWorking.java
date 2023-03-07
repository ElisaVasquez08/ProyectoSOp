/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_twitt;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class backendWorking {

	public static ArrayList<UserDataClass> getUsersData()
	{  
		//Creating array for User data
				ArrayList<UserDataClass> userDataHolders = new ArrayList<UserDataClass>();
				binaryDataStore bn= new binaryDataStore();
				bn.readUserDataFromFile();
				
		return userDataHolders;
	}

    static ArrayList<followerClass> getUserFollower(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static ArrayList<followingClass> getUserFollowing(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
	
}

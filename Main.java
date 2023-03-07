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
public class Main {
   static ArrayList<UserDataClass> UserDataHolder;
   static String username ;
   public static void main(String args[]) {
   UserDataHolder= backendWorking.getUsersData();
   new WelcomeScreen();
   }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_twitt;

/**
 *
 * @author Lenovo
 */
public class followingClass {
	private String name;
	private boolean status;
	   public followingClass(String name,boolean status) {
		   this.setName(name);
		   this.setStatus(status);
	   }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

}
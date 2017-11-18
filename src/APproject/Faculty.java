package APproject;

import java.util.ArrayList;
/**
 *Faculty class extends Person and is used to create a Faculty who knows about the all the rooms 
 *and can book a room by checking the room availability
 *@author Prateek and Vaibhav
 */
public class Faculty extends Person{
	private ArrayList<Room> rooms;
	/**
	 * @param n
	 * Denotes the name of the Faculty
	 * @param e
	 * Denotes the EmailID of the Faculty
	 * @param p
	 * Denotes the Password of the Faculty
	 * @param t
	 * Denotes the Type of the Faculty
	 * 
	 * Constructor function to generate Faculty Object with parameters n,e,p,t
	 */
	public Faculty(String n,String e,String p,String t){
		super();
		credentials.setEmailId(e);
		credentials.setName(n);
		credentials.setPassword(p);
		credentials.setUserType(t);
	}
	public ArrayList<Room> getRooms() {
		return rooms;
	}
	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}

}

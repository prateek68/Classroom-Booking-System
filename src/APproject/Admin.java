package APproject;

import java.util.ArrayList;
/**
 *Admin class extends Person and is used to create an Admin who knows about the all the rooms of the 
 *college and and excepts or rejects the requests made by students to book a room.
 *@author Prateek and Vaibhav
 */
public class Admin extends Person{
	private static ArrayList<Room> rooms=new ArrayList<Room>();
	private static ArrayList<Request> requests=new ArrayList<Request>();
	/**
	 * @param n
	 * Denotes the name of the Admin
	 * @param e
	 * Denotes the EmailID of the Admin
	 * @param p
	 * Denotes the Password of the Admin
	 * @param t
	 * Denotes the Type of the Admin
	 * 
	 * Constructor function to generate Admin Object with parameters n,e,p,t
	 */
	public Admin(String n,String e,String p,String t){
		super();
		credentials.setEmailId(e);
		credentials.setName(n);
		credentials.setPassword(p);
		credentials.setUserType(t);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static ArrayList<Room> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<Room> rooms) {
		Admin.rooms = rooms;
	}

	public static  ArrayList<Request> getRequests() {
		return requests;
	}

	public static void setRequests(ArrayList<Request> requests) {
		Admin.requests = requests;
	}
	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}
	public static void add(Request request) {
		requests.add(request);
	}
}


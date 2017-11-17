package APproject;

import java.util.ArrayList;

public class Admin extends Person{
	private static ArrayList<Room> rooms=new ArrayList<Room>();
	private static ArrayList<Request> requests=new ArrayList<Request>();
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


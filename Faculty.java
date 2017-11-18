package APproject;

import java.util.ArrayList;

public class Faculty extends Person{
	private ArrayList<Room> rooms;
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

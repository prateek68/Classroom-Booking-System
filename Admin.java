import java.util.ArrayList;

public class Admin extends Person{
	private static ArrayList<Room> rooms;
	private static ArrayList<Request> requests;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}

	public ArrayList<Request> getRequests() {
		return requests;
	}

	public void setRequests(ArrayList<Request> requests) {
		this.requests = requests;
	}
	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}
	public void accept_request(Request request) {
		
	}
	public void book_room() {
		
	}
	public void cancel_booking() {
		
	}
	public void reject_request(Request request) {
		
	}
	public static void add(Request request) {
		requests.add(request);
	}
}

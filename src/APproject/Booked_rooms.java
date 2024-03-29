package APproject;

import java.io.Serializable;
/**
 * This class is used to create an object whenever a request of a student is accepted by Admin or
 * either an Admin or a Faculty books a room
 * @author Prateek and Vaibhav 
 */
public class Booked_rooms implements Serializable {
	private String booked_room;
	private String booked_by, start_date,end_date;
		/**
	 * @param a
	 * A string that contains the information of booked room 
	 * @param b
	 * A string that contains the information of person who booked the room
	 * @param c
	 * A string that contains the information of start time of room booking
	 * @param d
	 * A string that contains the information of end time of room booking
	 * 
	 * Constructor to create a new Object that knows about a Booked Room
	 */
	public Booked_rooms(String a, String b, String c, String d) {
		this.booked_room=a;
		this.booked_by=b;
		this.start_date=c;
		this.end_date=d;
	}
	
	public String getBooked_room() {
		return booked_room;
	}

	public void setBooked_room(String booked_room) {
		this.booked_room = booked_room;
	}

	public String getBooked_by() {
		return booked_by;
	}

	public void setBooked_by(String booked_by) {
		this.booked_by = booked_by;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package APproject;

import java.io.Serializable;
import java.util.Date;

/**
 *This class object is used to store the information of any request that is being made by any student
 * @author Prateek and Vaibhav
 */
public class Request implements Serializable{
	private String name;
	private String info;
	private Room preferredRoom;
	private int expectedTurnout;
	private String status;
	private boolean message;
	private Date time;
	private Date booking_date_start;
	public Date getBooking_date_start() {
		return booking_date_start;
	}
	public void setBooking_date_start(Date booking_date_start) {
		this.booking_date_start = booking_date_start;
	}
	public Date getBooking_date_end() {
		return booking_date_end;
	}
	public void setBooking_date_end(Date booking_date_end) {
		this.booking_date_end = booking_date_end;
	}
	public String getStatus() {
		return status;
	}
	private Date booking_date_end;
	/**
	 * @param name
	 * String that stores the name of the Student who made the request
	 * @param info
	 * String that stores the purpose for which the room needs to be booked.
	 * @param preferred_room
	 * String that has the preferred room a student wants to book
	 * @param e
	 * An integer denoting the expected audience 
	 * @param status
	 * String that stores the status of the request
	 * @param b
	 * Boolean value that denotes whether the student is notified when the request gets accepted
	 * @param time
	 * String that stores the time at which the request was made. Stores the date in "yyyy/MM/dd HH:mm:ss" format
	 * @param start_date
	 * Stores the start date and time of the event. Stores the date in "yyyy/MM/dd HH:mm:ss" format
	 * @param end_date
	 * Stores the end date and time of the event. Stores the date in "yyyy/MM/dd HH:mm:ss" format
	 */
	public Request(String name,String info,Room preferred_room, int e,String status,boolean b,String time
			,String start_date,String end_date){
		this.name=name;
		this.info=info;
		this.preferredRoom=preferred_room;
		this.expectedTurnout=e;
		this.status=status;
		this.message=b;
		this.time=new Date();
		this.booking_date_end=new Date();
		this.booking_date_start=new Date();
		
		String[] s=time.split(" ");
		String[] s2=s[0].split("\\/");
		String[] s3=s[1].split("\\:");
		this.time.setYear(Integer.parseInt(s2[0])-1900);
		this.time.setMonth(Integer.parseInt(s2[1])-1);
		this.time.setDate(Integer.parseInt(s2[2]));
		this.time.setHours(Integer.parseInt(s3[0]));
		this.time.setMinutes(Integer.parseInt(s3[1]));
		
		s=start_date.split(" ");
		s2=s[0].split("\\/");
		s3=s[1].split("\\:");
		this.booking_date_start.setYear(Integer.parseInt(s2[0])-1900);
		this.booking_date_start.setMonth(Integer.parseInt(s2[1])-1);
		this.booking_date_start.setDate(Integer.parseInt(s2[2]));
		this.booking_date_start.setHours(Integer.parseInt(s3[0]));
		this.booking_date_start.setMinutes(Integer.parseInt(s3[1]));
		
		s=end_date.split(" ");
		s2=s[0].split("\\/");
		s3=s[1].split("\\:");
		this.booking_date_end.setYear(Integer.parseInt(s2[0])-1900);
		this.booking_date_end.setMonth(Integer.parseInt(s2[1])-1);
		this.booking_date_end.setDate(Integer.parseInt(s2[2]));
		this.booking_date_end.setHours(Integer.parseInt(s3[0]));
		this.booking_date_end.setMinutes(Integer.parseInt(s3[1]));
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Room getPreferredRoom() {
		return preferredRoom;
	}
	public void setPreferredRoom(Room preferredRoom) {
		this.preferredRoom = preferredRoom;
	}
	public int getExpectedTurnout() {
		return expectedTurnout;
	}
	public void setExpectedTurnout(int expectedTurnout) {
		this.expectedTurnout = expectedTurnout;
	}
	
	public String isStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isMessage() {
		return message;
	}
	public void setMessage(boolean message) {
		this.message = message;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}


public class Request {
	private String info;
	private Room preferredRoom;
	private int expectedTurnout, priority;
	private boolean status;
	private boolean accepted;
	private Time time;
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
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public boolean isAccepted() {
		return accepted;
	}
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

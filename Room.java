package APproject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Room implements Serializable{
	private String name;
	private int Capacity;
	private ArrayList<ArrayList<Date>> start_time;
	private ArrayList<ArrayList<Date>> end_time;
	Room(String number, int c){
		name=number;
		Capacity=c;
		start_time=new ArrayList<ArrayList<Date>>(7);// 0 for monday
		end_time=new ArrayList<ArrayList<Date>>(7);
		for(int j=0;j<7;++j) {
			start_time.add(new ArrayList<Date>());
			end_time.add(new ArrayList<Date>());
		}
	}
	public ArrayList<ArrayList<Date>> getStart_time() {
		return start_time;
	}
	public void setStart_time(ArrayList<ArrayList<Date>> start_time) {
		this.start_time = start_time;
	}
	public ArrayList<ArrayList<Date>> getEnd_time() {
		return end_time;
	}
	public void setEnd_time(ArrayList<ArrayList<Date>> end_time) {
		this.end_time = end_time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCapacity() {
		return Capacity;
	}
	public void setCapacity(int capacity) {
		Capacity = capacity;
	}
}

package game;

import java.io.Serializable;
import java.util.HashMap;

public class Room implements Serializable {
	
	private String roomLabel;
	private boolean isLocked;
	private Room[] travel;
	
	public HashMap<String, Item> roomObjects = new HashMap<String, Item>();
	
	public Room(String label) {
		roomLabel = label;
		isLocked = false;
		travel = new Room[6];
		Game.addRoom(this);
	}
	
	public String getLabel() {
		return roomLabel;
	}
	
	public String getDesc() {
		return Game.roomDescs.get(roomLabel);
	}
	
	public boolean isLocked() {
		return isLocked;
	}
	
	public void setLocked(boolean l) {
		isLocked = l;
	}
	
	public void addExit(Room r, int direction) {
		travel[direction] = r;
	}

	public Room go(int direction) {
		Room destination = travel[direction];
		if(destination == null)
			throw new InvalidDirectionException("You can't go that way!");
		if(destination.isLocked())
			throw new InvalidDirectionException("This room is locked.");
		return destination;
	}
	
	public void addItem(Item o) {
		roomObjects.put(o.getobjectName(), o);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

package game;

import java.io.Serializable;
import java.util.HashMap;

public abstract class Item implements Serializable{
	
	public String object;

	public Item(String o) {
		object = o;
	}

	public String getobjectName() {
		return object;
	}
	
	public void look(){
		Game.print(Game.itemDescs.get(object));
	}
	
	public void take() {
		String output = "You cannot take that ";
		output += object;
		output += "!";
		Game.print(output);
		}
	public void use() {
		String output = "You cannot use that ";
		output += object;
		output += "!";
		Game.print(output);
	}
	public void open() {
		String output = "You cannot open that ";
		output += object;
		output += "!";
		Game.print(output);
	}
	public void close() {
		String output = "You cannot close that ";
		output += object;
		output += "!";
		Game.print(output);
	}
	public void move() {
		String output = "You cannot move that ";
		output += object;
		output += "!";
		Game.print(output);
	}
	


	
	

}

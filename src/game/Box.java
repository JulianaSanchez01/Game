package game;

public class Box extends Item {
	
	private boolean isOpen;
	public Box() {
		super("box"); // initialize item’s name
		isOpen = false; // box is closed
	}
	
	@Override
	public void look() {
		if (isOpen) {
			if (Game.playerHas("key"))
				Game.print("It’s an empty box.");
			else
				Game.print("There is a key inside the box.");
		} else
			Game.print("It’s a boring box.");
		}
	
	@Override
	public void open() {
		if (isOpen)
			Game.print("The box is already open!");
		else {
			isOpen = true;
			if (Game.playerHas("key")) 
				Game.print("You lift the box’s lid and find nothing!");
			else {
				Game.print("You lift the box’s lid and find a key inside!");
			}
	}
	}
	@Override
	public void close() {
		if (!isOpen)
			Game.print("The box is already closed!");
		else {
			isOpen = false;
			Game.print("You close the box.");
			
	}
		
	}
}
	
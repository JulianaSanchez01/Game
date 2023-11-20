package game;

public class Key extends Item{
	
	public Key() {
		super("key"); // initialize item’s name
	}
	
	@Override
	public void take() {
		if (Game.playerHas("key"))
			Game.print("You already have the key!");
		else {
			Game.print("You pick up the key and put it in your pocket.");
			Game.addInventoryItem(this); // add key to inventory
			Game.getcurrentRoom().roomObjects.remove("key");
	}
	}
	@Override
	public void use() {
		Room r = Game.getcurrentRoom();
		if(r.getLabel().equals("master bedroom")) {
			Game.print("You unlock the bathroom");
			Room a = Game.getRoom("master bathroom");
			a.setLocked(false);
		}else {
			Game.print("The key does not fit");
		}
		
		
	}
}

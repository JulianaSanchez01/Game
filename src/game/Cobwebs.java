package game;

public class Cobwebs extends Item{
	
	public Cobwebs() {
		super("cobwebs"); // initialize item’s name
	}
	
	@Override
	public void look() {
		Game.print("They are just cobwebs.");
	}
	
	@Override
	public void move() {
		Game.print("You move as many cobwebs as you can into a pile. Thanks for cleaning up the attic!!");
	}

	@Override
	public void take() {
		if (Game.playerHas("cobwebs"))
			Game.print("You already have the cobwebs.");
		else {
			Game.print("You pick up the cobwebs and put them in your pocket. That's kind of gross, but okay.");
			Game.addInventoryItem(this); // add key to inventory
			Game.getcurrentRoom().roomObjects.remove("cobwebs");
	}
	}
}

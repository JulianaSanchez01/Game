package game;

public class Plant extends Item{
	
	private boolean isMoved;
	public Plant() {
		super("plant"); // initialize item’s name
		isMoved = false;
	}
	
	@Override
	public void move() {
		Game.print("You move the plant.");
		isMoved = true;
	}
	
	@Override
	public void look() {
		if(isMoved) {
			Game.print("You see a note taped to the desk that reads 'reminder: I left it under the rug'");
		}
		else {
			Game.print("You see a plant");
		}
	}
	
	@Override
	public void take() {
		if (Game.playerHas("plant"))
			Game.print("You already have the plant!");
		else {
			Game.print("You pick up the plant and carry it.");
			Game.addInventoryItem(this); // add key to inventory
			Game.getcurrentRoom().roomObjects.remove("plant");
	}
	}
}

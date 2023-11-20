package game;

public class Pillow extends Item{
	
	private boolean isMoved;
	public Pillow() {
		super("pillow"); // initialize item’s name
		isMoved = false;
	}
	
	@Override
	public void look() {
		if(isMoved) {
			Game.print("You see a note under the pillow that reads, 'Good morning! I made the bed for you today<3 Don't forget to clean the attic!:)'");
		}
		else {
			Game.print("It is a white fluffly pillow that lies flat on the bed.");
		}
	}
	
	public void move() {
		Game.print("You move the pillow.");
		isMoved = true;
	}
	
	@Override
	public void take() {
		if (Game.playerHas("pillow"))
			Game.print("You already have the pillow!");
		else {
			Game.print("You pick up the pillow and carry it.");
			Game.addInventoryItem(this); // add key to inventory
			Game.getcurrentRoom().roomObjects.remove("pillow");
	}
	}
}

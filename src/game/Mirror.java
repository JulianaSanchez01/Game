package game;

public class Mirror extends Item{
	
	public Mirror() {
		super("mirror"); // initialize item’s name
	}
	
	@Override
	public void look() {
		Game.print("You see yourself in the mirror.");
	}
}



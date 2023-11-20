package game;

public class Bed extends Item{
	
	public Bed() {
		super("bed"); // initialize item’s name
	}
	
	@Override
	public void look() {
		Game.print("The bed is perfectly made, besides for one pillow that looks like it fell over.");
	}
}

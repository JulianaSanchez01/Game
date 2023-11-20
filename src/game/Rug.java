package game;

public class Rug extends Item{
	
	private boolean isMoved;
	public Rug() {
		super("rug"); // initialize item’s name
		isMoved = false;
	}
	
	@Override
	public void move() {
		Game.print("You move the rug.");
		isMoved = true;
	}
	
	@Override
	public void look() {
		if(isMoved) {
			Game.print("You see the money under the rug");
		}
		else {
			Game.print("You see a rug");
		}
	}
	
}

package game;

public class Desk extends Item{
	
	public Desk() {
		super("desk"); // initialize item’s name
	}
	
	@Override
	public void look() {
		Game.print("The desk does not have much on it, it is very clean. The only thing you see is a plant in the corner");
	}
	
	@Override
	public void take() {
		Game.print("Why would you even want to do that? You try, but its too heavy. Maybe try hitting the gym or you could just stop trying to pick up desks!!!");

	}
}

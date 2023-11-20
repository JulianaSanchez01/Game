package game;

public class Money extends Item{
	
	public Money() {
		super("money"); // initialize item’s name
	}
	
	@Override
	public void take() {
		if (Game.playerHas("money"))
			Game.print("You already found the money!");
		else {
			Game.print("You find the money. Congrats, you won the game!!");
			Game.addInventoryItem(this); 
			Game.getcurrentRoom().roomObjects.remove("money");
	}
	}
}

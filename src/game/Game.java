package game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Room livingRoom = new Room("living room");
		Room bedroom = new Room("bedroom");
		Room office = new Room("office");
		Room attic = new Room("attic");
		Room bedroom2 = new Room("master bedroom");
		Room bathroom = new Room("master bathroom");
		
		populateMap("rooms.txt", roomDescs);
		livingRoom.addExit(bedroom, 0); //add east
		livingRoom.addExit(office, 1); //add west
		office.addItem(new Desk());
		office.addItem(new Plant());
		office.addExit(livingRoom, 0); //add east
		bedroom.addExit(livingRoom, 1); //add west
		bedroom.addExit(attic, 4); //add up
		bedroom.addItem(new Mirror());
		bedroom.addItem(new Box());
		bedroom.addItem(new Key());
		attic.addExit(bedroom, 5); //add down
		attic.addItem(new Cobwebs());
		livingRoom.addExit(bedroom2, 3);
		bedroom2.addExit(livingRoom, 2);
		bedroom2.addExit(bathroom, 0);
		bedroom2.addItem(new Bed());
		bedroom2.addItem(new Pillow());
		bedroom2.addItem(new Mirror());
		bathroom.addExit(bedroom2, 1);
		bathroom.addItem(new Money());
		bathroom.addItem(new Rug());
		bathroom.setLocked(true);
		
		currentRoom = livingRoom;
		// TODO Auto-generated method stub
		play();

	}
	private static Room currentRoom;
	public static HashMap<String, String> roomDescs = new HashMap<String, String>();
	public static HashMap<String, String> itemDescs = new HashMap<String, String>();
	public static HashMap<String, Item> playerInventory = new HashMap<String, Item>();
	
	private static HashMap<String, Room> rooms = new HashMap<String, Room>(); 
	
	public static void saveGame() {
		File saveFile = new File("save0.save");
		try {
			saveFile.createNewFile();
			ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(saveFile));
			fileWriter.writeObject(currentRoom);
			fileWriter.writeObject(playerInventory);
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			print("Error writing to file.");
		}
	}
	
	public static void loadGame() {
		File saveFile = new File("save0.save");
		try {
			ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(saveFile));
			currentRoom = (Room) fileReader.readObject();
			playerInventory = (HashMap<String, Item>) fileReader.readObject();
			fileReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			print("Error writing to file.");
		} catch(ClassNotFoundException ex) {
			print("error: corrupt, save file");
		}
	}
	public static void addRoom(Room r) {
		rooms.put(r.getLabel(), r);
	}
	
	public static Room getcurrentRoom() {
		return currentRoom;
	}
	
	public static Room getRoom(String label) {
		return rooms.get(label);
	}
	public static void print(String s) {
		System.out.println( s + "\n");
	}
	
	public static void play() {
		String choice = ""; 
		Scanner input = new Scanner(System.in); 
		System.out.println("You lost your money! You know you put it somewhere but you can't remember where. Find your money and you win the game!");
		System.out.println("To navigate aroud the house, press the letter of the direction you wish to go:\n(e)ast , (w)est, (n)orth, (s)outh, (u)p, (d)own");
		System.out.println("When interacting with objects you may use the following commands:\nlook, move, use, take, open, and, close.\nGood Luck!");
		do {
		    try {
		    	System.out.print("What do you want to do? ");
		    	choice = input.nextLine();
		    	
		    	if(choice.length() >1) {
		    		String[] splitcommand = choice.split(" ");
		    		String action = splitcommand[0];
		    		String itemName = splitcommand[1];
		    		if(action.equalsIgnoreCase("look")){
		    			Item i = currentRoom.roomObjects.get(itemName);
		    			i.look();
		    		}
		    		else if(action.equalsIgnoreCase("open")){
		    			Item i = currentRoom.roomObjects.get(itemName);
		    			i.open();
		    		}
		    		else if(action.equalsIgnoreCase("close")){
		    			Item i = currentRoom.roomObjects.get(itemName);
		    			i.close();
		    		}
		    		else if(action.equalsIgnoreCase("take")){
		    			Item i = currentRoom.roomObjects.get(itemName);
		    			i.take();
		    		}
		    		else if(action.equalsIgnoreCase("use")){
		    			Item i = playerInventory.get(itemName);
		    			i.use();
		    		}
		    		else if(action.equalsIgnoreCase("move")){
		    			Item i = currentRoom.roomObjects.get(itemName);
		    			i.move();
		    		}
		    		else if(action.equalsIgnoreCase("save")) {
		    			saveGame();
		    		}
		    		else if(action.equalsIgnoreCase("load")) {
		    			loadGame();
		    		}
		    		else {
		    			Game.print("Invalid command.");
		    		}
		    	
		    } else {
		    	
		    	switch(choice.charAt(0)) {
		    	case 'e':
		    		currentRoom = currentRoom.go(0); 
		    		print(currentRoom.getDesc()); 
		    		break;
				case 'w':
					currentRoom = currentRoom.go(1); 
					print(currentRoom.getDesc());
					break;
				case 'n':
					currentRoom = currentRoom.go(2); 
					print(currentRoom.getDesc());
					break;
				case 's':
					currentRoom = currentRoom.go(3);
					print(currentRoom.getDesc());
					break;
				case 'u':
					currentRoom = currentRoom.go(4); 
					print(currentRoom.getDesc());
					break;
				case 'd':
					currentRoom = currentRoom.go(5); 
					print(currentRoom.getDesc());
					break;
				case 'i':
					print("You are carrying nothing.");
					break;
				case 'x':
					print("Okay. Bye.");
					break;
				default:
					print("Invalid command.");
				}
		    }	
		    	
		} catch (InvalidDirectionException ex) {
			print(ex.getMessage()); 
		} catch (StringIndexOutOfBoundsException ex) {
			print("You must enter something!"); 
		} catch (NullPointerException ex) {
			print("You can't do that!");
		}catch(ArrayIndexOutOfBoundsException ex) {
			print("invalid command");
		}
		
		}while(!choice.equalsIgnoreCase("x")); 
		input.close(); 
		}
	private static void populateMap(String fileName, HashMap<String, String> map) {
		File inputFile = new File(fileName);
		try {
			Scanner fileReader = new Scanner(inputFile);
			while(fileReader.hasNextLine()) {
				String label = fileReader.nextLine();
				String desc = "";
				String line = fileReader.nextLine();
				while(!line.equals("#")) {
					desc += line;
					line = fileReader.nextLine();
				}
				map.put(label, desc);
			}
			fileReader.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0); // file name is incorrect or file doesn't exist... end program
					
		}
	}
		
		public static void addInventoryItem(Item o) {
			playerInventory.put(o.getobjectName(), o);
		}
		
		public static boolean playerHas(String name){
			if(playerInventory.containsKey(name))
				return true;
			else
				return false;
			
		}
		
		
					
					
}
			
		
	


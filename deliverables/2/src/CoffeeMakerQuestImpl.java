import java.util.*;

public class CoffeeMakerQuestImpl implements CoffeeMakerQuest {

	// TODO: Add more member variables and methods as needed.
	boolean over;
	ArrayList<Room> roomstore;
	int curroom;
	CoffeeMakerQuestImpl() {
		// TODO'
		roomstore=new ArrayList<Room>();
		over=false;
		curroom=0;
	}

	/**
	 * Whether the game is over. The game ends when the player drinks the coffee.
	 * 
	 * @return true if successful, false otherwise
	 */
	public boolean isGameOver() {
		// TODO
		//return over;
		return over;
	}

	/**
	 * Set the player to p.
	 * 
	 * @param p the player
	 */
	public void setPlayer(Player p) {
		this.setPlayer(p);
	}
	
	/**
	 * Add the first room in the game. If room is null or if this not the first room
	 * (there are pre-exiting rooms), the room is not added and false is returned.
	 * 
	 * @param room the room to add
	 * @return true if successful, false otherwise
	 */
	public boolean addFirstRoom(Room room) {
		if (!this.addFirstRoom(room) || room == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Attach room to the northern-most room. If either room, northDoor, or
	 * southDoor are null, the room is not added. If there are no pre-exiting rooms,
	 * the room is not added. If room is not a unique room (a pre-exiting room has
	 * the same adjective or furnishing), the room is not added. If all these tests
	 * pass, the room is added. Also, the north door of the northern-most room is
	 * labeled northDoor and the south door of the added room is labeled southDoor.
	 * Of course, the north door of the new room is still null because there is
	 * no room to the north of the new room.
	 * 
	 * @param room      the room to add
	 * @param northDoor string to label the north door of the current northern-most room
	 * @param southDoor string to label the south door of the newly added room
	 * @return true if successful, false otherwise
	 */
	public boolean addRoomAtNorth(Room room, String northDoor, String southDoor) {
		// TODO
		if (northDoor==null||southDoor==null||room==null) {
			return false;
		}
		/*if (addFirstRoom(room)) {
			return false;
		}*/
		for (Room r:roomstore) {
			if (r.getAdjective().equals(room.getAdjective())||r.getFurnishing().equals(room.getFurnishing())) {
				return false;
			}
		}
		roomstore.get(roomstore.size()-1).setNorthDoor(northDoor);
		room.setSouthDoor(southDoor);
		roomstore.add(room);
		return true;
	}

	/**
	 * Returns the room the player is currently in. If location of player has not
	 * yet been initialized with setCurrentRoom, returns null.
	 * 
	 * @return room player is in, or null if not yet initialized
	 */ 
	public Room getCurrentRoom() {
		Room room = this.getCurrentRoom();
		return room;
	}
	
	/**
	 * Set the current location of the player. If room does not exist in the game,
	 * then the location of the player does not change and false is returned.
	 * 
	 * @param room the room to set as the player location
	 * @return true if successful, false otherwise
	 */
	public boolean setCurrentRoom(Room room) {
		if (getCurrentRoom() == null) {
			return false;
		} else {
			this.setCurrentRoom(room);
			return true;
		}
	}
	
	/**
	 * Get the instructions string command prompt. It returns the following prompt:
	 * " INSTRUCTIONS (N,S,L,I,D,H) > ".
	 * 
	 * @return comamnd prompt string
	 */
	public String getInstructionsString() {
		return " INSTRUCTIONS (N,S,L,I,D,H) > ";
	}
	
	/**
	 * Processes the user command given in String cmd and returns the response
	 * string. For the list of commands, please see the Coffee Maker Quest
	 * requirements documentation (note that commands can be both upper-case and
	 * lower-case). For the response strings, observe the response strings printed
	 * by coffeemaker.jar. The "N" and "S" commands potentially change the location
	 * of the player. The "L" command potentially adds an item to the player
	 * inventory. The "D" command drinks the coffee and ends the game. Make
     * sure you use Player.getInventoryString() whenever you need to display
     * the inventory.
	 * 
	 * @param cmd the user command
	 * @return response string for the command
	 */
	public String processCommand(String cmd) {
		Player player = new Player();
		Room room = getCurrentRoom();
		switch (cmd){ 
			case "n": 
				if (curroom==6) {
					return "A door in that direction does not exist.";
				}
				
			case "N":
				if (curroom==6) {
					return 	"A door in that direction does not exist.";
				}
				curroom++;
				return "";
			case "s":
				if (curroom==6) {
					return 	"A door in that direction does not exist.";
				}
				curroom--;
				return "";
			case "S":
				if (curroom==6) {
					return 	"A door in that direction does not exist.";
				}
				curroom--;
				return "";
			case "l":
				return (room.getItem() + room.getDescription());

			case "L":
				return (room.getItem() + room.getDescription());

			case "i":
				return player.getInventoryString();

			case "I":
				return player.getInventoryString();

			case "d":
				player.getInventoryString();
				if (player.checkCoffee()&&player.checkCream()&&player.checkSugar()) {
					return "You drink the beverage and are ready to study!\r\n" + 
							"You win!";
				}
				else if (player.checkCoffee() && player.checkCream()) {
					return"Without sugar, the coffee is too bitter. You cannot study.\r\n" + 
							"You lose!";
				}
				else if(player.checkCoffee()&&player.checkSugar()){
					 return"Without cream, you get an ulcer and cannot study.\r\n" + 
					 		"You lose!";
				}
				else if (player.checkCream()&&player.checkSugar()) {
					return "You drink the sweetened cream, but without caffeine you cannot study.\r\n" + 
							"You lose!";
				}
				else if (player.checkCoffee()) {
					return "Without cream, you get an ulcer and cannot study.\r\n" + 
							"You lose!";
				}
				else if (player.checkCream()) {
					return "You drink the cream, but without caffeine, you cannot study.\r\n" + 
							"You lose!";
				}
				else if (player.checkSugar()) {
					return "You eat the sugar, but without caffeine, you cannot study.\r\n" + 
							"You lose!";
				}
				else {
					return"You drink the air, as you have no coffee, sugar, or cream.\r\n" + 
							"The air is invigorating, but not invigorating enough. You cannot study.\r\n" + 
							"You lose!";
				}
			case "D":
				player.getInventoryString();
				if (player.checkCoffee()&&player.checkCream()&&player.checkSugar()) {
					return "You drink the beverage and are ready to study!\r\n" + 
							"You win!";
				}
				else if (player.checkCoffee() && player.checkCream()) {
					return"Without sugar, the coffee is too bitter. You cannot study.\r\n" + 
							"You lose!";
				}
				else if(player.checkCoffee()&&player.checkSugar()){
					 return"Without cream, you get an ulcer and cannot study.\r\n" + 
					 		"You lose!";
				}
				else if (player.checkCream()&&player.checkSugar()) {
					return "You drink the sweetened cream, but without caffeine you cannot study.\r\n" + 
							"You lose!";
				}
				else if (player.checkCoffee()) {
					return "Without cream, you get an ulcer and cannot study.\r\n" + 
							"You lose!";
				}
				else if (player.checkCream()) {
					return "You drink the cream, but without caffeine, you cannot study.\r\n" + 
							"You lose!";
				}
				else if (player.checkSugar()) {
					return "You eat the sugar, but without caffeine, you cannot study.\r\n" + 
							"You lose!";
				}
				else {
					return"You drink the air, as you have no coffee, sugar, or cream.\r\n" + 
							"The air is invigorating, but not invigorating enough. You cannot study.\r\n" + 
							"You lose!";
				}
			
			case "h":
				return "N - Go north"+
				"\nS - Go south"+
				"\nL - Look and collect any items in the room"+
				"\nI - Show inventory of items collected"+
				"\nD - Drink coffee made from items in inventory\n";

			case "H":
				return "N - Go north"+
				"\nS - Go south"+
				"\nL - Look and collect any items in the room"+
				"\nI - Show inventory of items collected"+
				"\nD - Drink coffee made from items in inventory\n";

		}
		return "";
	}
	
}

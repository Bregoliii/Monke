package battleship;

import java.util.concurrent.TimeUnit;

import javax.swing.JButton;

public class Play {
	// Adds Ship Locations
	static placeShip Ships1 = new placeShip();
	static placeShip Ships2 = new placeShip();
	
	// Adds Shots Fired
	static Turn Player1 = new Turn(Ships2);
	static Turn Player2 = new Turn(Ships1);
	
	// Used for while Loop
	static boolean win = false;
	
	//Main
	public static void main(String[] args) {
		
		//Users Place the ships
		setShips(Ships1, Ships2);
		
		//timer(seconds)
		timer(5);
		
		//Infinite Loop (while false)
		while (!win) {
			// Whose turn
			if(!Player1.turnOver) {
				//Fires a Shot
				turn(Ships1, Player1, Player2);
				//Checks for win
				checkwin(Player1);
			} else {
				turn(Ships2, Player2, Player1);
				checkwin(Player2);
			}
		}
		//If someone Won
		System.out.println(" winner winner chicken dinner");	
	}
	
	public static void setShips(Field Ships1, Field Ships2){
		
		//While not 8 ships are placed
		while(true){
			//Player 1 places ships
			if(Ships1.ships.size() < 8) {
				//Ship placing window visible 
				Ships1.f.setVisible(true);
			//Player 2 places ships
			} else if(Ships2.ships.size() < 8 && Ships1.ships.size() >= 8) {
				//Player 1 Ship placing window invisible
				Ships1.f.setVisible(false);
				Ships2.f.setVisible(true);
			//Each player placed 8 ships, Windows hide
			} else {
				Ships1.f.setVisible(false);
				Ships2.f.setVisible(false);
				break;
			}
		}
		
		//Sets buttons to false so no more ships can be placed
		//(Goes through the button array)
		for (JButton[] ba : Ships1.buttons) { 
			for (JButton b : ba) { 
			    b.setEnabled(false);
			}
		}
		for (JButton[] ba : Ships2.buttons) { 
			for (JButton b : ba) { 
				b.setEnabled(false);
			}
		}
	}
	
	//Turns OFF or ON all the buttons of the Player so they can't shoot more than 1 shot per turn.
	public static void flipButtons(boolean bool, Turn player) {
		for (JButton[] ba : player.buttons) { 
			for (JButton b : ba) { 
			    b.setEnabled(bool);
			}
		}
	}
	
	//Timer (in seconds) | Pauses the program
	public static void timer(int t) {
		try {
			TimeUnit.SECONDS.sleep(t);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
	
	
	//Goes through enemy players ship array and checks for ships
	public static void checkwin(Turn player) {
		win = true;
		for(int[] i: player.enemy.field) {
			for(int j: i) {
				if(j == 1) {
					win = false;
				}
			}
		}
	}

	
	//Turn (shots fired)
	public static void turn(placeShip sPlayer, Turn player, Turn enemy) {
		//Players windows set to visible
		player.f.setVisible(true);
		sPlayer.f.setVisible(true);
		//When shot is fired:
		if(player.turnOver) {
			//turn OFF buttons, wait 5 seconds 
			flipButtons(false, player);
			timer(5);
			//turn ON buttons so they can shoot after the enemy has finished their turn
			flipButtons(true, player);
			//Sets windows to invisible
			player.f.setVisible(false);
			sPlayer.f.setVisible(false);
			//Other Players turn
			timer(1);
			enemy.turnOver = false;
		}
	}
	
}

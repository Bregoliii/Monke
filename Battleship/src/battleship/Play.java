package battleship;

import java.util.concurrent.TimeUnit;

import javax.swing.JButton;

public class Play {
	static placeShip Ships1 = new placeShip();
	static placeShip Ships2 = new placeShip();
	static Turn Player1 = new Turn(Ships2);
	static Turn Player2 = new Turn(Ships1);
	static boolean win = false;
	
	public static void main(String[] args) {
		setShips(Ships1, Ships2);
		
		timer(5);
		
		while (!win) {
			if(!Player1.turnOver) {
				turn(Ships1, Player1, Player2);
				checkwin(Player1);
			} else {
				turn(Ships2, Player2, Player1);
				checkwin(Player2);
			}
		}
		System.out.println(" winner winner chicken dinner");	
	}
	
	public static void setShips(Field Ships1, Field Ships2){
		while(true){
			if(Ships1.ships.size() < 8) {
				Ships1.f.setVisible(true);
			} else if(Ships2.ships.size() < 8 && Ships1.ships.size() >= 8) {
				Ships1.f.setVisible(false);
				Ships2.f.setVisible(true);
			} else {
				Ships1.f.setVisible(false);
				Ships2.f.setVisible(false);
				break;
			}
		}
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
	
	public static void flipButtons(boolean bool, Turn player) {
		for (JButton[] ba : player.buttons) { 
			for (JButton b : ba) { 
			    b.setEnabled(bool);
			}
		}
	}
	
	public static void timer(int t) {
		try {
			TimeUnit.SECONDS.sleep(t);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
	
	
	
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

	
	
	public static void turn(placeShip sPlayer, Turn player, Turn enemy) {
		player.f.setVisible(true);
		sPlayer.f.setVisible(true);
		if(player.turnOver) {
			flipButtons(false, player);
			timer(5);
			flipButtons(true, player);
			player.f.setVisible(false);
			sPlayer.f.setVisible(false);
			timer(1);
			enemy.turnOver = false;
		}
	}
	
}

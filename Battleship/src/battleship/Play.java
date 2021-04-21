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
		
		while (!checkwin()) {
			if(!Player1.turnOver) {
				turn(Ships1, Player1, Player2);
			} else {
				turn(Ships2, Player2, Player1);
			}
		}
		System.out.println(" winnner");	
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
	
	
	
	public static boolean checkwin() {
		boolean winner = true;
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++){
				if(Player1.enemy.field[i][j]== 1) {
					winner = false;
					System.out.println("Check");	
				}
			}
			
		} 
		
		
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++){
				if(Player2.enemy.field[i][j]== 1) {
					winner = false;
					System.out.println("Check");	
				}
			}
		}
		
		return winner;
		

	}

	
	
	public static void turn(placeShip sPlayer, Turn player, Turn enemy) {
		player.f.setVisible(true);
		sPlayer.f.setVisible(true);
		if(player.turnOver) {
			flipButtons(false, player);
			timer(1);
			flipButtons(true, player);
			player.f.setVisible(false);
			sPlayer.f.setVisible(false);
			timer(5);
			enemy.turnOver = false;
		}
	}
	
}

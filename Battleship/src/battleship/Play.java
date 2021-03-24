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
		
		while(!win) {
			if(!Player1.turnOver) {
				Player1.f.setVisible(true);
				Ships1.f.setVisible(true);
				if(Player1.turnOver) {
					
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					
					for (JButton[] ba : Player2.buttons) { 
						for (JButton b : ba) { 
						    b.setEnabled(true);
						}
					}
					
					Player1.f.setVisible(false);
					Ships1.f.setVisible(false);
					try {
						TimeUnit.SECONDS.sleep(5);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					Player2.turnOver = false;
				}
			} else {
				Player2.f.setVisible(true);
				Ships2.f.setVisible(true);
				if(Player2.turnOver) {
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					for (JButton[] ba : Player2.buttons) { 
						for (JButton b : ba) { 
						    b.setEnabled(true);
						}
					}
					Player2.f.setVisible(false);
					Ships2.f.setVisible(false);
					try {
						TimeUnit.SECONDS.sleep(5);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					Player1.turnOver = false;
				}
			}
		}
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
	
	public static void turn(Field Player1){
		Player1.f.setVisible(true);
		
	}
	
	public static boolean win() {
		
		return true;
	}
}

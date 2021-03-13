package battleship;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Play {
	static Field Player1 = new Field();
	static Field Player2 = new Field();
	
	public static void main(String[] args) {
		setShips(Player1, Player2);
	}
	
	public static void setShips(Field Player1, Field Player2){
		while(true){
			if(Player1.ships.size() < 8) {
				Player2.f.setVisible(false);
			} else if(Player2.ships.size() < 8 && Player1.ships.size() >= 8) {
				Player1.f.setVisible(false);
				Player2.f.setVisible(true);
			} else {
				Player1.f.setVisible(false);
				Player2.f.setVisible(false);
			}
		}
	}
	
}

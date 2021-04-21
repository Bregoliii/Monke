package battleship;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class Turn extends Field{
	placeShip enemy;
	public Turn(placeShip enemy) {
		this.enemy = enemy;
	}
	boolean turnOver = false;
	public void action(ActionEvent e){
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				if(e.getSource() == buttons[i][j]) {
					switch (enemy.field[i][j]) {
						case 0:
							buttons[i][j].setBackground(Color.RED);
							field[i][j] = 1;
							enemy.field[i][j] = 2;
							enemy.buttons[i][j].setBackground(Color.RED);
							turnOver = true;
							break;
						case 1:
							field[i][j] = 2;
							buttons[i][j].setBackground(Color.CYAN);
							//test
							enemy.field[i][j] = 2;
							enemy.buttons[i][j].setBackground(Color.CYAN);
							turnOver = true;
							break;
					}
				}
			}
		}
	}
}

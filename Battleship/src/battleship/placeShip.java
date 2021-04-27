package battleship;

import java.awt.Color;
import java.awt.event.ActionEvent;

public class placeShip extends Field{
	//On Button press
	public void action(ActionEvent e){
		//Loops through button array to find which button was pressed
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				if(e.getSource() == buttons[i][j]) {
					//Checks if the Field has a Ship
					if(field[i][j] == 0) {
						//Sets button to black and adds the ship
						buttons[i][j].setBackground(Color.BLACK);
						int arr[] = {i,j};
						ships.add(arr);
						field[i][j] = 1;
					//Ship already placed there
					} else {
						System.out.println("Ship Already placed there");
					}
				}
			}
		}
	}
}

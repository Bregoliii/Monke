package battleship;

import java.awt.Color;
import java.awt.event.ActionEvent;

public class placeShip extends Field{
	//On Button press
	public void action(ActionEvent e){
		// Geht durch den button array um herauszufinden, welcher Knopf gedrückt wurde.
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				if(e.getSource() == buttons[i][j]) {
					//Schaut, ob das Feld noch Schiffe hat. 
					if(field[i][j] == 0) {
						//Der Konpf wird schwarz und addiert das Schiff zum Feld.
						buttons[i][j].setBackground(Color.BLACK);
						int arr[] = {i,j};
						ships.add(arr);
						field[i][j] = 1;
					//Schiff ist auf diesem Feld schon platziert
					} else {
						System.out.println("Ship Already placed there");
					}
				}
			}
		}
	}
}

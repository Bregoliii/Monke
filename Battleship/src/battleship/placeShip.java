package battleship;

import java.awt.Color;
import java.awt.event.ActionEvent;

public class placeShip extends Field{
	public void action(ActionEvent e){
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				if(e.getSource() == buttons[i][j]) {
					if(field[i][j] == 0) {
						buttons[i][j].setBackground(Color.BLACK);
						int arr[] = {i,j};
						ships.add(arr);
						field[i][j] = 1;
					} else {
						System.out.println("Ship Already placed there");
					}
					/*
					for (int[] k : field) {
						for (int l : k) {
							System.out.print(l);
						}
						System.out.println("");
					}*/
				}
			}
		}
	}
}

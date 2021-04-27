package battleship;

import java.awt.Color;
import java.awt.event.ActionEvent;

public class Turn extends Field{
	//Gegner Feld
    placeShip enemy;
    public Turn(placeShip enemy) {
        this.enemy = enemy;
    }
    
    //Field Number to Value
    //Enemy Field
    // 0 = No Ship, Not shot at
    // 1 = Ship, Still Alive
    // 2 = Ship, Sunk
    // 3 = Miss
    
    //Shooting field
    // 0 = Not Shot at
    // 1 = Hit
    // 2 = Miss
    
    //Turn over
    boolean turnOver = false;
    //On Button press
    public void action(ActionEvent e){
    	//Welcher Knopf gedrueckt wurde
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(e.getSource() == buttons[i][j]) {
                	//Checks Field Value
                    switch(enemy.field[i][j]) {
                        case 0: // Kein Trefer, Value wird zu 2 und Farbe zu CYAN für visuelles Feedback, Zug ist zu Ende
                        	field[i][j] = 2;
                            buttons[i][j].setBackground(Color.CYAN);
                            enemy.field[i][j] = 3;
                            enemy.buttons[i][j].setBackground(Color.CYAN);
                            turnOver = true;
                            break;
                        case 1:// Treffer, Farbe verändert sich und Farbe wird zu Rot
                            buttons[i][j].setBackground(Color.RED);
                            field[i][j] = 1;
                            enemy.field[i][j] = 2;
                            enemy.buttons[i][j].setBackground(Color.RED);
                            turnOver = true;
                            break;
                        case 2://Auf das Feld wurde schon geschossen und man muss einen neuen Schuss abgeben
                            System.out.println("Already shot there! Choose another field");
                            break;
                        case 3: //Auf das Feld wurde schon geschossen und man muss einen neuen Schuss abgeben
                            System.out.println("Already shot there! Choose another field");
                            break;
                            
                    }
                                              
                }
            }
        }
    }
}
package battleship;

import java.awt.Color;
import java.awt.event.ActionEvent;

public class Turn extends Field{
	//Enemy field
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
    	//Find which button was pressed
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(e.getSource() == buttons[i][j]) {
                	//Checks Field Value
                    switch(enemy.field[i][j]) {
                        case 0: //No hit, Changes value to 2 and color to CYAN for visual feedback, Turn is over
                        	field[i][j] = 2;
                            buttons[i][j].setBackground(Color.CYAN);
                            enemy.field[i][j] = 3;
                            enemy.buttons[i][j].setBackground(Color.CYAN);
                            turnOver = true;
                            break;
                        case 1: //Hit, Changes value to 1 and color to Red
                            buttons[i][j].setBackground(Color.RED);
                            field[i][j] = 1;
                            enemy.field[i][j] = 2;
                            enemy.buttons[i][j].setBackground(Color.RED);
                            turnOver = true;
                            break;
                        case 2: //Field already Shot at, turnOver still false, another shot
                            System.out.println("Already shot there! Choose another field");
                            break;
                        case 3: //Field already Shot at, turnOver still false, another shot
                            System.out.println("Already shot there! Choose another field");
                            break;
                            
                    }
                                              
                }
            }
        }
    }
}
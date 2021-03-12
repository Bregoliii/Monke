package battleship;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Play {
	
	public static void main(String[] args) {
		/*int[][] p1s = {
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0}
				};*/
		final Field j = new Field();
		System.out.println(j.buttons[0][0]);
		if(j.buttons[0][0].getModel().isPressed())
			System.out.println("the button is pressed");
		
	}

}

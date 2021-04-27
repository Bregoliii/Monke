package battleship;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Field implements ActionListener{
	//Anzahl Schiffe die platziert worden sind 
	ArrayList<int[]> ships = new ArrayList<int[]>();
	JFrame f = new JFrame();
	//Button array hat die gleiche Grösse wie Field
	JButton[][] buttons = new JButton[8][8];
	//Array, die die Informationen auf das Field überträgt 
	int[][] field = {
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0}
	};
	
	public Field(){
		//Loops through buttons array
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				//Adds Buttons, makes them white
				buttons[i][j] = new JButton();
				buttons[i][j].setBackground(Color.WHITE);
				f.add(buttons[i][j]);
				//Adds Button Pressed action
				buttons[i][j].addActionListener(this);
			}
		}
		//Buttons in grid layout on field
		f.setSize(500,500);
		f.setLayout(new GridLayout(8,8)); 
		f.setVisible(false);
	}
	
	//Action events
	public void action(ActionEvent e) {}
	@Override
	public void actionPerformed(ActionEvent e){
		action(e);
	}
}
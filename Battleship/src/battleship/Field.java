package battleship;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Field implements ActionListener{
	//Amount of ships placed
	ArrayList<int[]> ships = new ArrayList<int[]>();
	JFrame f = new JFrame();
	//Button array same size as Field
	JButton[][] buttons = new JButton[8][8];
	//Array for storing information of Fields
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
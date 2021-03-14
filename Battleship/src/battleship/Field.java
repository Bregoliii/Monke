package battleship;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Field implements ActionListener{
	static int x;
	static int y;
	ArrayList<int[]> ships = new ArrayList<int[]>();
	JFrame f = new JFrame();
	JButton[][] buttons = new JButton[8][8];
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
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				buttons[i][j] = new JButton(i + " " + j);
				buttons[i][j].setBackground(Color.WHITE);
				f.add(buttons[i][j]);
				buttons[i][j].addActionListener(this);
			}
		}
		f.setSize(500,500);
		f.setLayout(new GridLayout(8,8)); 
		f.setVisible(false);
	}
	public void action(ActionEvent e) {}
	@Override
	public void actionPerformed(ActionEvent e){
		action(e);
	}
}
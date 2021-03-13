package battleship;

import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Field implements ActionListener{
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
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e){
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				if(e.getSource() == buttons[i][j]) {
					System.out.println(i + " and " + j);
				}
			}
		}
	}
}
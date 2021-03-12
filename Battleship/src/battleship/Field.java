package battleship;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Field {
	JFrame f = new JFrame();
	JButton[][] buttons = new JButton[8][8];
	int i = 0;
	int j = 0; 
	Field(){
		while(i < 8) {
			while(j < 8) {
				buttons[i][j] = new JButton(i + " " + j);
				buttons[i][j].setBackground(Color.WHITE);
				f.add(buttons[i][j]);
				//Broken
				buttons[i][j].addActionListener(new ActionListener(){  
					public void actionPerformed(ActionEvent e){  
						System.out.println("Button: " + i + "," + j); 
					}  
				}); 
				j++;
			}
			j = 0;
			i++;
		}
		f.setSize(500,500);
		f.setLayout(new GridLayout(8,8)); 
		f.setVisible(true);
		}
	
	void close(){
		f.setVisible(false);
	}
	
}

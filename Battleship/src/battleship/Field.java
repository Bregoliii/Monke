package battleship;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Field {
	JFrame f = new JFrame();
	JButton[][] buttons = new JButton[8][8];
	int a = 0;
	int b = 0; 
	Field(){
		for (JButton[] i : buttons) {
			for (JButton j : i) {
				j = new JButton(a + " " + b);
				j.setBackground(Color.WHITE);
				f.add(j);
				a++;
			}
			a = 0;
			b++;
		}
		f.setSize(500,500);
		f.setLayout(new GridLayout(8,8)); 
		f.setVisible(true);
		}
	
	void close(){
		f.setVisible(false);
	}
	
}

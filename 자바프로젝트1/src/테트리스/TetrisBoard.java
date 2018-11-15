package 테트리스;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class TetrisBoard extends JPanel{
	TetrisWindow tw;
	
	
	public TetrisBoard() {
		this.setPreferredSize(new Dimension(500, 650));
		this.setBackground(Color.DARK_GRAY);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int i=0; i<20; i++) {
			for(int j=0; j<10; j++) {
				g.setColor(Color.BLACK);
				g.drawRect(100+j*30, 10+i*30, 30, 30);
			}
		}
		
	}
}

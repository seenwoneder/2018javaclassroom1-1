package 테트리스;

import javax.swing.JPanel;

public class Main {
	public static void main(String[] args) {
		TetrisWindow tw = new TetrisWindow();
		TetrisBoard tb = new TetrisBoard();
		tw.add(tb);
		
		tw.tb = tb;
		tb.tw = tw;
		
		tw.initialize();
		tw.drawTetrisBoard(1, 0, 0);
		
		
		tw.repaint();
		tw.revalidate();
	}

}

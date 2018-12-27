package 테트리스;

import javax.swing.JPanel;

public class Main {
	public static void main(String[] args) {
		TetrisWindow tw=new TetrisWindow();
		TetrisBoard tb=new TetrisBoard();
		tw.add(tb);
		tb.setBounds(0, 0, 500, 650);
		
		tw.tb=tb;
		tb.tw=tw;
		
		tw.initialize();
		tw.makeNewTetrisBlock();
		
		tw.repaint();
		tw.revalidate();
	}
}

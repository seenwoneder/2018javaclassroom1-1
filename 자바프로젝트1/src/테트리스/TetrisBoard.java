package 테트리스;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TetrisBoard extends JPanel {
	TetrisWindow tw;
	JLabel 기록레이블;

	public TetrisBoard() {
		this.setLayout(null);
		this.setSize(new Dimension(500, 650));
		this.setBackground(new Color(0xE7E7A5));
		
		기록레이블=new JLabel("", JLabel.CENTER);
		기록레이블.setBounds(328, 170, 126, 50);
		기록레이블.setBackground(new Color(0xE7BBA5));
		기록레이블.setOpaque(true);
		this.add(기록레이블);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// 테트리스맵 배경을 나타내기
		g.setColor(Color.WHITE);
		g.fillRect(10, 10, 30*10, 30*20);

		// 테트리스맵을 게임판에 나타내기
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				if (tw.테트리스맵[i][j] > 0) {
					g.setColor(new Color(tw.테트리스맵[i][j]));
					g.fillRect(10 + j * 30, 10 + i * 30, 30, 30);
				}
			}
		}

		// 게임판위에 현재블록 얹히기
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (tw.현재블록[i][j] > 0) {
					g.setColor(new Color(tw.현재블록[i][j]));
					g.fillRect(10 + (tw.현재블록등장위치x + j) * 30, 10 + (tw.현재블록등장위치y + i) * 30, 30, 30);
				}
			}
		}

		// 게임판 테두리 다시 그리기
		g.setColor(Color.BLACK);
		g.drawRect(10, 10, 30 * 10, 30 * 20);
		
		// 다음 블록 미리 보기
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if(tw.모든블록[tw.다음블록번호][i][j]>0)
					g.setColor(new Color(tw.모든블록[tw.다음블록번호][i][j]));
				else
					g.setColor(Color.WHITE);
				g.fillRect(330 + j * 30, 10 + i*30, 30, 30);
				g.setColor(Color.BLACK);
				g.drawRect(330 + j * 30, 10 + i*30, 30, 30);
			}
		}
	}

}

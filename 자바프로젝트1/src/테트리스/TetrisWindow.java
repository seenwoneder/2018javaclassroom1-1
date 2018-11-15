package 테트리스;

import javax.swing.*;
import java.awt.*;

public class TetrisWindow extends JFrame {
	TetrisBoard tb;
	
	
	String[] 버튼제목= {"게임시작", "블록교체", "블록회전", "게임종료"};
	JButton[] 명령버튼 = new JButton[4];
	JLabel 기록레이블;
	
	
	//3단계
	int[] 색상;
	int[][] 테트리스맵 = new int[20][10];
	int[][][] 모든블록;
	int[][] 현재블록;
	int 블록번호, 현재블록등장위치x, 현재블록등장위치y;
	
	
	
	public TetrisWindow() {
		this.setTitle("Dont's mess up my tempo");
		this.setSize(500, 730);
		this.getContentPane().setBackground(new Color(0xD6F39C));
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0,0));
		
		
		JPanel firstPanel = new JPanel();
		firstPanel.setPreferredSize(new Dimension(500, 40));
		firstPanel.setBackground(Color.WHITE);
		firstPanel.setOpaque(true);
		this.add(firstPanel);
		
		
		for(int i=0; i<명령버튼.length; i++) {
			명령버튼[i] = new JButton(버튼제목[i]);
			firstPanel.add(명령버튼[i]);
			
		}
		
		
		기록레이블 = new JLabel("점수", JLabel.CENTER);
		기록레이블.setPreferredSize(new Dimension(60, 25));
		기록레이블.setBackground(Color.PINK);
		기록레이블.setOpaque(true);
		firstPanel.add(기록레이블);
		
		
		
		
		//화면 그래픽 갱신
		this.repaint();
		this.revalidate();
					
			
	}
	
	
	void initialize()	{
		//7개 블록조각에 넣을 색상을 정한다.
		this.색상 = new int[] {0x010101, 0x0000ff, 0xff0000, 0xffff00, 0x00ff00, 0xff00ff, 0x00ffff};
		
		//7개 블록조각을 만든다.
		this.모든블록 = new int[][][]   {
			{
				{색상[0],0,0,0},
				{색상[0],0,0,0},
				{색상[0],0,0,0},
				{색상[0],0,0,0}
			},
			{
				{0,0,0,0},
				{0,0,0,0},
				{색상[1],0,0,0},
				{색상[1],색상[1],색상[1],0}
			},
			{
				{0,0,0,0},
				{색상[2],0,0,0},
				{색상[2],0,0,0},
				{색상[2],색상[2],0,0}
			},
			{
				{0,0,0,0},
				{0,0,0,0},
				{색상[3],색상[3],0,0},
				{색상[3],색상[3],0,0}
			},
			{
				{0,0,0,0},
				{색상[4],0,0,0},
				{색상[4],색상[4],0,0},
				{색상[4],0,0,0}
			},
			{
				{0,0,0,0},
				{색상[5],0,0,0},
				{색상[5],색상[5],0,0},
				{0,색상[5],0,0}
			},
			{
				{0,0,0,0},
				{0,0,0,0},
				{색상[6],색상[6],0,0},
				{0,색상[6],색상[6],0}
			}
		};
		
		//테트리스 게임판을 초기화한다.
		for(int i=0; i<20; i++)
			for(int j=0; j<10; j++)
				this.테트리스맵[i][j] = 0;

		//게임을 위한 변수를 초기화 한다.
		this.블록번호 = 0;
		this.현재블록 = 모든블록[블록번호].clone();
		this.현재블록등장위치x = 0;
		this.현재블록등장위치y = 0;
		
	}
		
}

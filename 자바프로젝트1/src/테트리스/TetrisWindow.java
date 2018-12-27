package 테트리스;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TetrisWindow extends JFrame implements KeyListener, Runnable {
	TetrisBoard tb;
	
	String[] 버튼제목= {"게임시작", "블록교체", "블록회전", "게임종료"};
	JButton[] 명령버튼=new JButton[4];
	
	
	//3단계
	int[] 색상;
	int[][] 테트리스맵=new int[20][10];
	int[][][] 모든블록;
	int[][] 현재블록;
	int 현재블록번호, 다음블록번호, 현재블록등장위치x, 현재블록등장위치y;
	int 현재블록최초위치x, 현재블록최초위치y;
	
	//4단계
	int minX, minY, maxX, maxY;
	boolean 바닥인가;
	int score;
	Thread playThread;
	boolean 게임중=false;
	
	//5단계
	Random rnd = new Random();
	JMenuBar menuBar;
	JMenu[]	menu;
	JMenuItem[] menuitem;
	
	public TetrisWindow() {
		this.setTitle("Don't mess up my tempo");
		this.setSize(510, 700);
		this.getContentPane().setBackground(new Color(0x00fbfed9));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		
//		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		this.setLayout(null);

//		JPanel firstPanel=new JPanel();
//		firstPanel.setPreferredSize(new Dimension(500, 40));
//		firstPanel.setBackground(new Color(0xBCE7A5));
//		firstPanel.setOpaque(true);
//		this.add(firstPanel);
		
		//메뉴 바, 메뉴, 메뉴 아이템을 모두 추가
		addMenu();
		

//		firstPanel.add(기록레이블);
		
		//화면 그래픽 갱신
		this.repaint();
		this.revalidate();
	}
	

    private void addMenu() {
		menuBar = new JMenuBar();
		menu = new JMenu[] {new JMenu("기본명령"),new JMenu("도구명령")};
		menuitem =  new JMenuItem[] {new JMenuItem("게임시작"),new JMenuItem("게임종료"),new JMenuItem("블록변환"),new JMenuItem("블록회전")};
		
		menu[0].add(menuitem[0]);
		menu[0].add(menuitem[1]);
		menu[1].add(menuitem[2]);
		menu[1].add(menuitem[3]);
		
		menuBar.add(menu[0]);
		menuBar.add(menu[1]);
		
		this.setJMenuBar(menuBar);
		
		//메뉴 아이템마다 ActionListener를 추가한다.
    	for(int i=0; i<4; i++) {
    		menuitem[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					String 명령이름=arg0.getActionCommand();
					switch(명령이름) {
					case "게임시작":
						executeGameStartCommand();
						break;
					case "게임종료":
						executeBlcokEndCommand();
						break;
					case "블록변환":
						executeBlockTransformCommand();
						break;
					case "블록회전":
						executeBlockRotateCommand();
						break;
					}
				}

			});
    	}
	}


	void initialize() {
    	//7개 블록조각에 넣을 색상을 정한다.
    	this.색상=new int[] {0x60AED4, 0xD2E7A5, 0xA5E7D0, 0xA5BCE7, 0xE7A5BB, 0xBFE9CD, 0x0E7E7E7};
    	
    	//7개 블록조각을 만든다.
    	this.모든블록=new int[][][] {
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
    			this.테트리스맵[i][j]=0;
    	
    	//게임을 위한 변수 초기화한다.
    	this.다음블록번호=rnd.nextInt(7);
    	
    	this.현재블록=모든블록[현재블록번호].clone();
    	this.현재블록등장위치x=현재블록최초위치x=4;
    	this.현재블록등장위치y=현재블록최초위치y=0;
    }

    void makeNewTetrisBlock() {
    	this.현재블록번호=this.다음블록번호;
    	this.다음블록번호=rnd.nextInt(7);
    	
    	this.현재블록=this.모든블록[this.현재블록번호].clone();
    	this.현재블록등장위치x=this.현재블록최초위치x;
    	this.현재블록등장위치y=this.현재블록최초위치y;
    	
    	tb.repaint();
    	tb.revalidate();
    }
    
    void moveTetrisBlock(int x, int y) {
    	this.현재블록등장위치x += x;
    	this.현재블록등장위치y += y;
    	
    	//현재블록의 내부 조각의 범위를 알아낸다.
    	getMinXMinYMaxXMaxY(현재블록);
    	
    	//현재블록이 테트리스맵의 범위를 벗어나지 않도록 한다.
    	if(haveBlockTroubles(현재블록)==true) {
    		this.현재블록등장위치x -= x;
        	this.현재블록등장위치y -= y;
    	}
    	
    	//바닥인지 검사한다.
    	this.바닥인가=isBottom();
    	
    	tb.repaint();
    	tb.revalidate();
    }
    
    boolean isBottom() {
    	if(this.현재블록등장위치y+this.maxY>=19) return true;
    	for(int i=minY; i<=maxY; i++) {
    		for(int j=minX; j<=maxX; j++) {
    			if(현재블록[i][j]>0) {
    				if(테트리스맵[현재블록등장위치y+i+1][현재블록등장위치x+j]>0)
    					return true;
    			}
    		}
    	}
    	return false;
    }
    
    boolean haveBlockTroubles(int[][] 지금블록) {
    	getMinXMinYMaxXMaxY(지금블록);
    	
    	if(this.현재블록등장위치x+this.maxX>9) return true;
    	if(this.현재블록등장위치x<0) return true;
    	if(this.현재블록등장위치y+this.maxY>19) return true;

    	for(int i=minY; i<=maxY; i++) {
    		for(int j=minX; j<=maxX; j++) {
    			if(지금블록[i][j]>0) {
    				if(테트리스맵[현재블록등장위치y+i][현재블록등장위치x+j]>0)
    					return true;
    			}
    		}
    	}
    	
    	return false;
    }
    
    
    void rotateTetrisBlock() {
    	//현재블록을 회전한다.
    	int[][] 회전블록 = new int[4][4];
    	
    	//회전
    	for(int i=0; i<4; i++)
    		for(int j=0; j<4; j++)
    			회전블록[j][3-i]=this.현재블록[i][j];
    	
    	//블록 내부 조각의 존재 범위를 알아낸다.
    	getMinXMinYMaxXMaxY(회전블록);
    	
    	//좌측 하단으로 붙인다.
    	int 좌측이동칸수=minX;
    	int 하단이동칸수=3-maxY;
    	for(int i=maxY; i>=minY; i--) {
    		for(int j=minX; j<=maxX; j++) {
    			int 값=회전블록[i][j];
    			회전블록[i][j]=0;
    			회전블록[i+하단이동칸수][j-좌측이동칸수]=값;
    		}
    	}
    	
    	if(haveBlockTroubles(회전블록)==false)
    	    현재블록=회전블록;
        
    	//블록 내부 조각의 존재 범위를 알아낸다.
    	getMinXMinYMaxXMaxY(현재블록);
        
        tb.repaint();
        tb.revalidate();
    }
    
    void getMinXMinYMaxXMaxY(int[][] 지금블록) {
    	minX=minY=99;
    	maxX=maxY=0;
    	for(int i=0; i<4; i++) {
    		for(int j=0; j<4; j++) {
    			if(지금블록[i][j]>0) {
    				minX=Math.min(minX, j);
    				maxX=Math.max(maxX, j);
    				minY=Math.min(minY, i);
       				maxY=Math.max(maxY, i);
    			}
    		}
    	}
    }
    
    void recordInTetrisMap() 
    {
    	for(int i=0; i<4; i++) {
    		for(int j=0; j<4; j++) {
    			 if(현재블록[i][j]>0) {
    				 테트리스맵[현재블록등장위치y+i][현재블록등장위치x+j]=현재블록[i][j];
    			 }
    		}
    	}
    }
    
    void removeFullLines() {
    	for(int i=19; i>=0; i--) {
    		//현재(i) 행에 블록의 갯수를 모두 센다.
    		int cnt=0;
    		for(int j=0; j<10; j++)
    			if(테트리스맵[i][j]>0) cnt++;
    		
    		if(cnt<10) continue;
    		
    		//블록을 제거한다.
    		for(int m=i; m>=1; m--) {
	    		for(int n=0; n<10; n++) {
	    			테트리스맵[m][n]=테트리스맵[m-1][n];
	    			테트리스맵[m-1][n]=0;
	    		}
    		}
    		
    		//점수를 10점 추가한다.
    		score+=10;
    		tb.기록레이블.setText(score + "점");
    		
    		//
    		i++;
    	}
    }
        
	private void executeBlcokEndCommand() {
		게임중=false;
		while(playThread.isAlive()) {
			playThread.interrupt();
		}
	}

	private void executeBlockRotateCommand() {
		rotateTetrisBlock();
		this.requestFocus();
	}

	private void executeBlockTransformCommand() {
		makeNewTetrisBlock();
		this.requestFocus();
	}

	private void executeGameStartCommand() {
		initialize();
		
		//자도낙하스레드 생성하고 작동
		게임중=true;
		playThread=new Thread((Runnable)this);
		playThread.start();
		
		try {
			this.removeKeyListener(this);
		} catch (Exception e1) {
		}
		this.addKeyListener(this);
		this.requestFocus();
	}

	public void keyPressed(KeyEvent key) {
		switch(key.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			moveTetrisBlock(-1,0);
			break;
		case KeyEvent.VK_RIGHT:
			moveTetrisBlock(1,0);
			break;
		case KeyEvent.VK_UP:
			rotateTetrisBlock();
			break;
		case KeyEvent.VK_DOWN:
			moveTetrisBlock(0,1);
			break;
		case KeyEvent.VK_SPACE:
			//바닥에 도달할 때까지 내려간다.
			바닥인가=false;
			while(바닥인가==false) {
				moveTetrisBlock(0, 1);
			}
			
			//현재블록을 테트리스 맵에 기록한다.
			recordInTetrisMap();

			//테트리스맵에 블록이 모두 채워진 줄들을 제거한다.
			removeFullLines();

			게임중=isNotEnd((현재블록번호+1)%7);
			if(게임중==false) {
				JOptionPane.showMessageDialog(null, "게임 종료", "게임 종료", JOptionPane.INFORMATION_MESSAGE);
				tb.repaint();
				tb.revalidate();
				return;
			}
			
			//새로운 블록을 등장시킨다.
			makeNewTetrisBlock();
			
			break;
		}
	}

	public void keyReleased(KeyEvent arg0) {
	}

	public void keyTyped(KeyEvent arg0) {
	}

	@Override
	public void run() {
		while(게임중) {
			try {
				if(isBottom()) {
					//바닥처리
					recordInTetrisMap();
					removeFullLines();
					
					//새로운 블록 등장하는 부분
					게임중=isNotEnd((현재블록번호+1)%7);
					if(게임중==false) {
						JOptionPane.showMessageDialog(null, "게임 종료", "게임 종료", JOptionPane.INFORMATION_MESSAGE);
						tb.repaint();
						tb.revalidate();
						return;
					}
					
					makeNewTetrisBlock();
					this.바닥인가=false;
				}
				else {
					//계속 낙하
					moveTetrisBlock(0, 1);
				}
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

	private boolean isNotEnd(int nextBlockNumber) {
		int[][] 다음블록=this.모든블록[nextBlockNumber].clone();
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				if(다음블록[i][j]>0 && 
				   this.테트리스맵[this.현재블록최초위치y+i][this.현재블록최초위치x+j]>0) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	
}

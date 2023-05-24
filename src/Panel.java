import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel{
	Game game;
	double tick;
	private static final double[] tickAtLevel  = {798.7, 715.5, 632.3, 549.1, 465.9, 382.7, 299.5, 216.3, 133.1, 99.8, 83.2, 83.2, 83.2, 66.6, 66.6, 66.6, 49.9, 49.9, 49.9, 33.3, 33.3, 33.3, 33.3, 33.3, 33.3, 33.3, 33.3, 33.3, 33.3, 16.4};
	
	public Panel(Game game) {
		this.game = game;
		updateTick();
		Timer timer = new Timer((int)tick, new Timey());
		timer.start();
		addKeyListener(new key());
		setFocusable(true);
	}
	
	public Board getBoard() {
		return game.getBoard();
	}
	public void setBoard(Board board) {
		game.setboard(board); 
	}
	public static double[] getTickatlevel() {
		return tickAtLevel;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);//forgot to add this
		//System.out.println(Arrays.deepToString(game.getBoard().getBoard()));
		
		game.getBoard().drawBoard(g);
	}
	public void updateTick() {
		if(game.getLevel() < 30)
			tick = tickAtLevel[game.getLevel()];
		else
			tick = tickAtLevel[29];
	}
	
	private class Timey implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(!game.checkGameOver()) {
				game.getCurrentPiece().move(0, 1);
				game.resetPiece();
				if(game.getTotalLinesCleared() % 10 > game.getLevel())
					game.setLevel(game.getLevel() + 1);
				game.updateScore();
				repaint();
			}
		}
	}
	private class key implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			int type = e.getKeyCode();
			if(type == KeyEvent.VK_H)
				game.holdPiece();
			else if(type == KeyEvent.VK_UP)
				game.getCurrentPiece().rotate();
			else if(type == KeyEvent.VK_LEFT) 
				game.getCurrentPiece().move(-1, 0);
			else if(type == KeyEvent.VK_RIGHT)
				game.getCurrentPiece().move(1,  0);
			repaint();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	private class click implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}

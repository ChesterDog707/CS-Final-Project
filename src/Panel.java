import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel{
	Game game;
	int tick;
	private static final double[] tickAtLevel  = {798.7, 715.5, 632.3, 549.1, 465.9, 382.7, 299.5, 216.3, 133.1, 99.8, 83.2, 83.2, 83.2, 66.6, 66.6, 66.6, 49.9, 49.9, 49.9, 33.3, 33.3, 33.3, 33.3, 33.3, 33.3, 33.3, 33.3, 33.3, 33.3, 16.4};
	
	public Panel(Game game) {
		this.game = game;
		Timer timer = new Timer(tick, new Timey());
		timer.start();
		KeyListener keyboard = new key();
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
		game.getBoard().drawBoard(g);
	}
	public void updateTick() {
		//int n = 
	}
	
	private class Timey implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(!game.checkGameOver() && !game.getCurrentPiece().move(0, 1)) {
				repaint();
				game.setTotalLinesCleared(game.getTotalLinesCleared() + game.getBoard().clearLines());
				if(game.getTotalLinesCleared() % 10 > game.getLevel())
					game.setLevel(game.getLevel() + 1);
				game.updateScore();
				//game.generateNewCurrentPiece();
			}
		}
	}
	private class key implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
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
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
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

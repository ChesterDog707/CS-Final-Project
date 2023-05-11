import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Timer;

public class Game {

	private Tetrimino currentPiece;
	private Tetrimino heldPiece;
	private Board screen;
	int tick;
	private int score;
	private int level;
	private int totalLinesCleared;
	private static final double[] tickAtLevel  = {798.7, 715.5, 632.3, 549.1, 465.9, 382.7, 299.5, 216.3, 133.1, 99.8, 83.2, 83.2, 83.2, 66.6, 66.6, 66.6, 49.9, 49.9, 49.9, 33.3, 33.3, 33.3, 33.3, 33.3, 33.3, 33.3, 33.3, 33.3, 33.3, 16.4};
	
	public Game() {
		currentPiece = null;
		heldPiece = null;
		screen = new Board();
		score = 0;
		level = 0;
		Timer timer = new Timer(tick, new Timey());
	}
	 
	public Tetrimino getCurrentPiece() {
		return currentPiece;
	}
	public void setCurrentPiece(Tetrimino currentPiece) {
		this.currentPiece = currentPiece;
	}
	public Tetrimino getHeldPiece() {
		return heldPiece;
	}
	public void setHeldPiece(Tetrimino heldPiece) {
		this.heldPiece = heldPiece;
	}
	public Board getScreen() {
		return screen;
	}
	public void setScreen(Board screen) {
		this.screen = screen;
	}

	
	public void holdPiece() {
		if(heldPiece == null) {
			heldPiece = currentPiece;
			currentPiece = null;
			heldPiece.resetPosition();
			generateNewCurrentPiece();
			return;	
		}else {
			swapHeldPiece();
		}
	}
	
	private void swapHeldPiece() {
		Tetrimino temp = currentPiece;
		currentPiece = heldPiece;
		heldPiece = temp;
	}
	
	public void generateNewCurrentPiece() {
		int x = (int)(Math.random() * 7);
		switch(x) {
		case 0:
			currentPiece = new ITetrimino(screen.getBoard());
			return;
		case 1:
			currentPiece = new JTetrimino(screen.getBoard());
			return;
		case 2:
			currentPiece = new LTetrimino(screen.getBoard());
			return;
		case 3:
			currentPiece = new OTetrimino(screen.getBoard());
			return;
		case 4:
			currentPiece = new STetrimino(screen.getBoard());
			return;
		case 5:
			currentPiece = new TTetrimino(screen.getBoard());
			return;
		case 6:
			currentPiece = new ZTetrimino(screen.getBoard());
			return;
		}
	}
	public boolean checkPlaced() {
		return !currentPiece.checkPlacement(currentPiece.xPosition, currentPiece.yPosition + 1, currentPiece.orientation);
	}
	public boolean checkGameOver() {
		for (int i = 0; i < 10; i++) 
			if(screen.getBoard()[0][i] != 0 && !currentPiece.checkTop())
				return true;
		return false;
	}
	public void updateScore() {
		// TODO Auto-generated method stub
		
	}
		
	private class Timey implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(!checkGameOver() && !currentPiece.move(currentPiece.getXPosition(), currentPiece.getYPosition() + 1)) {
				totalLinesCleared += screen.clearLines();
				if(totalLinesCleared % 10 > level)
					level ++;
				updateScore();
				generateNewCurrentPiece();
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

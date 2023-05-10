import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Game {

	private Tetrimino currentPiece;
	private Tetrimino heldPiece;
	private Board screen;
	int tick;
	private int score;
	private int totalLinesCleared;
	private static final double MILLPERFRAME = 16.639267339780494785253615712793;
	
	public Game() {
		currentPiece = null;
		heldPiece = null;
		screen = new Board();
		score = 0;
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
	public void gameUpdate() {
		
	}
	
	private class Timey implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}

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
	private Board board;
	private int score;
	private int level;
	private int totalLinesCleared;
	
	public Game() {
		currentPiece = null;
		heldPiece = null;
		board = new Board();
		score = 0;
		level = 0;
		generateNewCurrentPiece();
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
	public Board getBoard() {
		return board;
	}
	public void setboard(Board board) {
		this.board = board;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getTotalLinesCleared() {
		return totalLinesCleared;
	}

	public void setTotalLinesCleared(int totalLinesCleared) {
		this.totalLinesCleared = totalLinesCleared;
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
		int x = (int)(Math.random() * 7) + 1;
		switch(x) {
		case 1:
			currentPiece = new ITetrimino(board.getBoard());
			break;
		case 2:
			currentPiece = new JTetrimino(board.getBoard());
			break;
		case 3:
			currentPiece = new LTetrimino(board.getBoard());
			break;
		case 4:
			currentPiece = new OTetrimino(board.getBoard());
			break;
		case 5:
			currentPiece = new STetrimino(board.getBoard());
			break;
		case 6:
			currentPiece = new TTetrimino(board.getBoard());
			break;
		case 7:
			currentPiece = new ZTetrimino(board.getBoard());
			break;
		}
		System.out.println("placed");
		currentPiece.placeOrDelete(true);
	}
	public boolean checkPlaced() {
		System.out.println("here3");
		return !currentPiece.checkPlacement(currentPiece.xPosition, currentPiece.yPosition + 1, currentPiece.orientation);
	}
	public void resetPiece() {
		if(!checkPlaced()) {
			generateNewCurrentPiece();
			totalLinesCleared += board.clearLines();
		}
	}
	public boolean checkGameOver() {
		for (int i = 0; i < 10; i++) 
			if(board.getBoard()[0][i] != 0 && !currentPiece.checkTop())
				return true;
		return false;
	}
	public void updateScore() {
		// TODO Auto-generated method stub
		
	}
	
}

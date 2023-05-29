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
	private Tetrimino nextPiece;
	private Tetrimino heldPiece;
	private Board board;
	private int score;
	private int level;
	private int totalLinesCleared;
	private boolean gameOver = false;
	
	public Game() {
		currentPiece = null;
		heldPiece = null;
		board = new Board();
		int y = (int)(Math.random() * 7) + 1;
		switch(y) {
		case 1:
			nextPiece = new ITetrimino(board.getBoard());
			break;
		case 2:
			nextPiece = new JTetrimino(board.getBoard());
			break;
		case 3:
			nextPiece = new LTetrimino(board.getBoard());
			break;
		case 4:
			nextPiece = new OTetrimino(board.getBoard());
			break;
		case 5:
			nextPiece = new STetrimino(board.getBoard());
			break;
		case 6:
			nextPiece = new TTetrimino(board.getBoard());
			break;
		case 7:
			nextPiece = new ZTetrimino(board.getBoard());
			break;
		}
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
	
	public Tetrimino getNextPiece() {
		return nextPiece;
	}

	public void setNextPiece(Tetrimino nextPiece) {
		this.nextPiece = nextPiece;
	}

	public void holdPiece() {
		currentPiece.placeOrDelete(false);
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
		currentPiece.resetPosition();
		heldPiece.resetPosition();
	}
	
	public void generateNewCurrentPiece() {
		currentPiece = nextPiece;
		int y = (int)(Math.random() * 7) + 1;
		//int y = 1;
		switch(y) {
		case 1:
			nextPiece = new ITetrimino(board.getBoard());
			break;
		case 2:
			nextPiece = new JTetrimino(board.getBoard());
			break;
		case 3:
			nextPiece = new LTetrimino(board.getBoard());
			break;
		case 4:
			nextPiece = new OTetrimino(board.getBoard());
			break;
		case 5:
			nextPiece = new STetrimino(board.getBoard());
			break;
		case 6:
			nextPiece = new TTetrimino(board.getBoard());
			break;
		case 7:
			nextPiece = new ZTetrimino(board.getBoard());
			break;
		}
		if(!currentPiece.checkPlacement(currentPiece.getXPosition(), currentPiece.getYPosition(), currentPiece.getOrientation())) {
			nextPiece = null;
			gameOver = true;
			return;
		} else
			currentPiece.placeOrDelete(true);
	}
	public boolean checkPlaced() {
		boolean t;
		currentPiece.placeOrDelete(false);
		t = !currentPiece.checkPlacement(currentPiece.getXPosition(), currentPiece.getYPosition() + 1, currentPiece.getOrientation());
		currentPiece.placeOrDelete(true);
		return t;
	}
	public void resetPiece() {
		if(checkPlaced()) {
			int x = board.clearLines();
			switch(x) {
			case 0:
				break;
			case 1:
				score += 40 * (level + 1);
				break;
			case 2:
				score += 40 * (level + 1);
				break;
			case 3:
				score += 300 * (level + 1);
				break;
			case 4:
				score += 1200 * (level + 1);
				break;
			}
			totalLinesCleared += x;
			updateLevel();
			generateNewCurrentPiece();
		}
	}
	public void updateLevel() {
		level = totalLinesCleared / 10;
	}
	public boolean checkGameOver() {
		return gameOver;
	}
	
}

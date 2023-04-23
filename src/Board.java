import java.awt.Graphics;

public class Board {
	int[][] board = new int[10][20];
	
	
	public int[][] getBoard() {
		return board;
	}
	public void setBoard(int[][] board) {
		this.board = board;
	}

	public Board() {
		for(int i = 0; i < 10; i++) 
			for(int j = 0; j < 20; j ++)
				board[i][j] = 0;
	}
	
	public void drawBoard(Graphics g) {
		
	}
	public void clearLines() {
		
	}
	public int checkForLines() {
		int output = 0;
		return output;
	}
}

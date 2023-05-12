import java.awt.Color;
import java.awt.Graphics;

public class Board {
	int[][] board = new int[20][10];
	final static Color[] colors = {Color.white, new Color(61, 255, 236), new Color(15, 4, 222), new Color(240, 141, 12), new Color(255, 247, 0), new Color(11, 227, 0), new Color(219, 0, 235), new Color(235, 0, 0)};
	
	public int[][] getBoard() {
		return board;
	}
	public void setBoard(int[][] board) {
		this.board = board;
	}

	public Board() {
		for(int i = 0; i < 20; i++) 
			for(int j = 0; j < 10; j ++)
				board[i][j] = 0;
	}
	
	public void drawBoard(Graphics g) {
		for(int r = 0; r < board.length; r ++) {
			for(int c = 0; c < board[0].length; c ++) {
				g.setColor(Color.black);
				g.drawRect(c * 20, r * 20, 20, 20);
				g.setColor(colors[board[r][c]]);
				g.fillRect(c * 20 + 1, r * 20 + 1, 19, 19);
			}
		}
	}
	public int clearLines() {
		int lineCount = 0;
		int r = -1;
		for(int[] row : board) {
			r++;
			for(int i : row) {
				if(i == 0)
					break;
			}
			lineCount ++;
			deleteRow(r);
		}
		return lineCount;
	}
	private void deleteRow(int r) {
		for(int c = 0; c < board[r].length; c++)
			board[r][c] = 0;
		for(int row = r; row > 0; row --)
			for(int col = 0; col < board[row].length; col ++) 
				board[row][col] = board[row - 1][col];
		for(int col = 0; col < board[0].length; col ++)
			board[0][col] = 0;
		return;
	}
}

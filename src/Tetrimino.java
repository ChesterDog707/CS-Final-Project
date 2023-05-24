import java.util.Arrays;

public abstract class Tetrimino {
	protected int orientation;
	protected int xPosition;
	protected int yPosition;
	protected int numberValue;
	protected boolean placed = false;
	protected int[][] board;
	
	public Tetrimino(int[][] board) {
		this.board = board;
		orientation = 1;
	}
	public int getXPosition() {
		return xPosition;
	}
	public int getYPosition() {
		return yPosition;
	}
	public int getOrientation() {
		return orientation;
	}
	public int getNumberValue() {
		return numberValue;
	}
	public abstract void rotate();
	public abstract boolean placeOrDelete(boolean place);
	public abstract void resetPosition();
	protected abstract boolean checkPlacement(int changeX, int changeY, int changeOrientation);
	public abstract boolean checkTop();
	public boolean move(int changeX, int changeY) {
		// TODO Auto-generated method stub
		System.out.println("here2");
		placeOrDelete(false);
		for(int[] r : board) {
			for(int c : r) {
				System.out.print(c + "  ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println(checkPlacement(xPosition + changeX, yPosition + changeY, orientation));
		if(checkPlacement(xPosition + changeX, yPosition + changeY, orientation)) {
			System.out.println("here3");
			placeOrDelete(false);
			xPosition += changeX;
			yPosition += changeY;
			placeOrDelete(true);
			System.out.println("MOVING THE PIECE DOWN");  //im tryna see when this is triggered
			return true;
		
		}
		placeOrDelete(true);
		return false;
	}
	public void place() {
		placed = true;
		return;
	}
}

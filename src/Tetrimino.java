

public abstract class Tetrimino {
	protected int orientation;
	protected int xPosition;
	protected int yPosition;
	protected int numberValue;
	protected boolean placed = false;
	protected int[][] board;
	protected boolean firstPlace;
	
	public Tetrimino(int[][] board) {
		this.board = board;
		orientation = 1;
		firstPlace = true;
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
	public boolean isFirstPlace() {
		return firstPlace;
	}
	public void setFirstPlace(boolean firstPlace) {
		this.firstPlace = firstPlace;
	}
	public abstract void rotate();
	public abstract boolean placeOrDelete(boolean place);
	public abstract void resetPosition();
	protected abstract boolean checkPlacement(int changeX, int changeY, int changeOrientation);
	public abstract boolean checkTop();
	public boolean move(int changeX, int changeY) {
		// TODO Auto-generated method stub
		placeOrDelete(false);
		if(checkPlacement(xPosition + changeX, yPosition + changeY, orientation)) {
			xPosition += changeX;
			yPosition += changeY;
			placeOrDelete(true);
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


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
	public int getOrientation() {
		return orientation;
	}
	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}
	public int getXPosition() {
		return xPosition;
	}
	public void setXPosition(int xPosition) {
		this.xPosition = xPosition;
	}
	public int getYPosition() {
		return yPosition;
	}
	public void setYPosition(int yPosition) {
		this.yPosition = yPosition;
	}
	public abstract void rotate();
	public abstract boolean placeOrDelete(boolean place);
	public abstract void resetPosition();
	protected abstract boolean checkPlacement(int changeX, int changeY, int changeOrientation);
	public abstract boolean checkTop();
	public void move(int changeX, int changeY) {
		// TODO Auto-generated method stub
		placeOrDelete(false);
		if(checkPlacement(xPosition + changeX, yPosition + changeY, orientation)) {
			xPosition += changeX;
			yPosition += changeY;
		}
		placeOrDelete(true);	
	}
}

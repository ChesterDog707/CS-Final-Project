
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
	public abstract void place();
	protected abstract void delete();
	public abstract void move(int changeX, int changeY);
	public abstract void resetPosition();
	protected abstract boolean checkPlacement(int changeX, int changeY, int changeOrientation);
	public abstract boolean checkTop();
}

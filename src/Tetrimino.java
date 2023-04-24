
public abstract class Tetrimino {
	protected int orientation;
	protected int xPosition;
	protected int yPosition;
	protected int numberValue;
	protected boolean placed = false;
	
	public Tetrimino() {
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
	public abstract void place(Board board);
	protected abstract void delete(Board board);
	public abstract void move(int x, int y);
	public abstract void resetPosition();
	public abstract boolean checkRight(int spaces);
	public abstract boolean checkLeft(int spaces);
	public abstract boolean checkUp(int spaces);
	public abstract boolean checkBelow(int spaces);
	public abstract boolean checkTop();
}

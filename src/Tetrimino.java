
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
	public abstract void rotate(int direction);
	public abstract void place(Board board);
	public abstract void delete(Board board);
	public abstract void resetPosition();
	public abstract boolean checkRight();
	public abstract boolean checkLeft();
	public abstract boolean checkBelow();
}

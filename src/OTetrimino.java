
public class OTetrimino extends Tetrimino{

	public OTetrimino() {
		super();
		xPosition = 4;
		yPosition = 0;
		numberValue = 4;
	}

	@Override
	public void rotate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void place(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void delete(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetPosition() {
		// TODO Auto-generated method stub
		xPosition = 4;
		yPosition = 0;
	}

	@Override
	public boolean checkRight(int spaces) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkLeft(int spaces) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkUp(int spaces) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkBelow(int spaces) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkTop() {
		// TODO Auto-generated method stub
		return false;
	}
	

}

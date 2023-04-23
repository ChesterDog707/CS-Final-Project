
public class LTetrimino extends Tetrimino {

	public LTetrimino() {
		super();
		xPosition = 3;
		yPosition = 0;
		numberValue = 3;
	}
	
	@Override
	public void rotate(int direction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkRight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkLeft() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void resetPosition() {
		// TODO Auto-generated method stub
		xPosition = 3;
		yPosition = 0;
	}

	@Override
	public boolean checkBelow() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void place(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkDefaultPosition() {
		// TODO Auto-generated method stub
		return yPosition == 0;
	}

}


public class OTetrimino extends Tetrimino{

	public OTetrimino(int[][] board) {
		super(board);
		xPosition = 4;
		yPosition = 0;
		numberValue = 4;
	}

	@Override
	public void rotate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean placeOrDelete(boolean place) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void resetPosition() {
		// TODO Auto-generated method stub
		xPosition = 4;
		yPosition = 0;
		orientation = 1;
	}

	@Override
	protected boolean checkPlacement(int changeX, int changeY, int changeOrientation) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkTop() {
		// TODO Auto-generated method stub
		return yPosition == 0;
	}
	

}

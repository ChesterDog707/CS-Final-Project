
public class JTetrimino extends Tetrimino {

	public JTetrimino(int[][] board) {
		super(board);
		xPosition = 3;
		yPosition = 1;
		numberValue = 2;
	}

	@Override
	public void rotate() {
		// TODO Auto-generated method stub
		switch(orientation) {
		case 1:
		}
	}

	@Override
	public boolean placeOrDelete(boolean place) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void resetPosition() {
		// TODO Auto-generated method stub
		xPosition = 3;
		yPosition = 1;
		orientation = 1;
	}

	@Override
	protected boolean checkPlacement(int changeX, int changeY, int changeOrientation) {
		// TODO Auto-generated method stub
		switch(orientation) {
		case 1:
			if(changeX == 0 || changeY == 0)
				return false;
			if(changeX < 0 || changeX >= board.length || changeY < 
		case 2:
			
		case 3:
			
		case 4:
			
		}
	}

	@Override
	public boolean checkTop() {
		// TODO Auto-generated method stub
		return yPosition == 1;
	}
	
}

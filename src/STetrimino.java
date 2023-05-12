
public class STetrimino extends Tetrimino {

	public STetrimino(int[][] board) {
		super(board);
		xPosition = 3;
		yPosition = 1;
		numberValue = 5;
	}

	@Override
	public void rotate() {
		// TODO Auto-generated method stub
		placeOrDelete(false);
		switch(orientation) {
		case 1:
			if(checkPlacement(xPosition + 1, yPosition - 1, 2)) {
				orientation = 2;
				xPosition ++;
				yPosition --;
			}
			break;
		case 2:
			if(checkPlacement(xPosition - 1, yPosition + 2, 3)) {
				orientation = 3;
				xPosition --;
				yPosition +=2;
			}
			break;
		case 3:
			if(checkPlacement(xPosition, yPosition - 2, 4)) {
				orientation = 4;
				yPosition -=2;
			}
			break;
		case 4:
			if(checkPlacement(xPosition, yPosition + 1, 1)) {
				orientation = 1;
				yPosition += 1;
			}
			break;
		}
		placeOrDelete(true);
		return;
	}

	@Override
	public boolean placeOrDelete(boolean place) {
		// TODO Auto-generated method stub
		int num;
		if(place)
			num = numberValue;
		else 
			num=0;
		if(checkPlacement(xPosition, yPosition, orientation)) {
			switch(orientation) {
			
			case 3:
			case 1:  //filling in the blocks on the 2d array with the "num"; making them into a different color
				board[xPosition][yPosition] = num;  
				board[xPosition+1][yPosition] = num;
				board[xPosition+1][yPosition-1] = num;
				board[xPosition+2][yPosition-1] = num;
				return true;
	
			case 4:
			case 2:
				board[xPosition][yPosition] = num;
				board[xPosition][yPosition+1] = num;
				board[xPosition+1][yPosition+1] = num;
				board[xPosition+1][yPosition+2] = num;
			}
		}
		
		
		
		
		
		
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
	
		return false;
		}
	}

	@Override
	public boolean checkTop() {
		// TODO Auto-generated method stub
		return yPosition == 1;
	}
	
}

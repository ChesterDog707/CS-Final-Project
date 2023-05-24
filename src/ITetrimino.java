
public class ITetrimino extends Tetrimino {

	ITetrimino(int[][] board) {
		super(board);
		xPosition = 3;
		yPosition = 0;
		numberValue = 1;
	}

	@Override
	public void rotate() {
		// TODO Auto-generated method stub
		placeOrDelete(false);
		switch(orientation) {
		case 1:
			if(checkPlacement(xPosition + 2, yPosition + 2, 2)) {
				orientation = 2;
				xPosition += 2;
				yPosition += 2;
			}
			break;
		case 2:
			if(checkPlacement(xPosition - 2, yPosition - 1, 3)) {
				orientation = 3;
				xPosition -= 2;
				yPosition -= 1;
			}
			break;
		case 3:
			if(checkPlacement(xPosition + 1, yPosition + 1, 4)) {
				orientation = 4;
				xPosition += 1;
				yPosition += 1;
			}
			break;
		case 4:
			if(checkPlacement(xPosition - 1, yPosition - 2, 1)) {
				orientation = 1;
				xPosition -= 1;
				yPosition -= 2;
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
			num = 0;
			switch(orientation) {
			case 1:
			case 3:
				for(int i = xPosition; i < xPosition + 4; i ++)
					board[yPosition][i] = num;
				return true;
			case 2:
			case 4:
				for(int i = yPosition; i > yPosition - 4; i--)
					board[i][xPosition] = num;
				return true;
		}
		return false;
	}

	@Override
	public void resetPosition() {
		// TODO Auto-generated method stub
		xPosition = 3;
		yPosition = 0;
		orientation = 1;
	}
	
	@Override
	public boolean checkTop() {
		// TODO Auto-generated method stub
		return yPosition == 0;
	}

	@Override
	protected boolean checkPlacement(int changeX, int changeY, int changeOrientation) {
		// TODO Auto-generated method stub
		switch(changeOrientation) {
		case 1:
		case 3:
			for(int i = changeX; i < changeX + 4; i++) {
				if(i >= board[0].length)
					return false;
				if(changeY >= board.length)
					return false;
				if(board[changeY][i] != 0)
					return false;
			}
			break;
		case 2:
		case 4:
			for(int i = changeY; i > changeY - 4; i--) {
				if(i < 0 || i >= board.length)
					return false;
				if(board[i][changeX] != 0)
					return false;
			}
			break;
		}
		return true;
	}
}

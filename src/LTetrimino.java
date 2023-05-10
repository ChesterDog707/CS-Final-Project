
public class LTetrimino extends Tetrimino {

	public LTetrimino(int[][] board) {
		super(board);
		xPosition = 3;
		yPosition = 0;
		numberValue = 3;
	}

	@Override
	public void rotate() {
		// TODO Auto-generated method stub
		placeOrDelete(false);
		switch(orientation) {
		case 1:
			if(checkPlacement(xPosition, yPosition + 2, 2)) {
				yPosition += 2;
				orientation ++;
			}
			break;
		case 2:
			if(checkPlacement(xPosition - 2, yPosition, 3)) {
				xPosition -= 2;
				orientation ++;
			}
			break;
		case 3:
			if(checkPlacement(xPosition, yPosition - 2, 4)) {
				yPosition -= 2;
				orientation ++;
			}
			break;
		case 4:
			if(checkPlacement(xPosition + 2, yPosition, 1)) {
				xPosition += 2;
				orientation = 1;
			}
			break;
		}
		placeOrDelete(true);
	}

	@Override
	public boolean placeOrDelete(boolean place) {
		// TODO Auto-generated method stub
		int num;
		if(place)
			num = numberValue;
		else
			num = 0;
		if(checkPlacement(xPosition, yPosition, orientation)) {
			switch(orientation) {
			case 1:
				board[xPosition][yPosition] = num;
				for(int i = xPosition; i > xPosition - 3; i--) {
					board[i][yPosition + 1] = num;
				}
				break;
			case 2:
				board[xPosition][yPosition] = num;
				for(int i = yPosition; i > yPosition - 3; i--) {
					board[xPosition - 1][i] = num;
				}
				break;
			case 3:
				board[xPosition][yPosition] = num;
				for(int i = xPosition; i < xPosition + 3; i++) {
					board[i][yPosition - 1] = num;
				}
				break;
			case 4:
				board[xPosition][yPosition] = num;
				for(int i = yPosition; i < yPosition + 3; i++) {
					board[xPosition + 1][i] = num;
				}
				break;
			}
		}
			
	}

	@Override
	public void resetPosition() {
		// TODO Auto-generated method stub
		xPosition = 3;
		yPosition = 0;
		orientation = 1;
	}

	@Override
	protected boolean checkPlacement(int changeX, int changeY, int changeOrientation) {
		// TODO Auto-generated method stub
		switch(orientation) {
		case 1:
			if(changeX >= board[0].length || changeY <= 0 || changeY + 1 > board.length)
				return false;
			if(board[changeX][changeY] != 0)
				return false;
			for(int i = changeX; i > changeX - 3; i--) {
				if(i < 0)
					return false;
				if(board[i][changeY + 1] != 0) 
					return false;
			}
			break;
		case 2:
			if(changeY > board.length || changeX < board[0].length || changeX - 1 < 0)
				return false;
			if(board[changeX][changeY] != 0)
				return false;
			for(int i = changeY; i > changeY - 3; i--) {
				if(i < board.length)
					return false;
				if(board[changeX - 1][i] != 0)
					return false;
			}
			break;
		case 3:
			if(changeY > board.length || changeX < 0 || changeY - 1 < 0)
				return false;
			if(board[changeX][changeY] !=0)
				return false;
			for(int i = changeX; i < changeX + 3; i++) {
				if(changeX > board[0].length)
					return false;
				if(board[i][changeY - 1] != 0) 
					return false;
			}
			break;
		case 4:
			if(changeX < 0 || changeY < 0 || changeX + 1 > board[0].length)
				return false;
			if(board[changeX][changeY] != 0)
				return false;
			for(int i = changeY; i < changeY + 3; i++) {
				if(changeY > board.length)
					return false;
				if(board[changeX + 1][i] != 0)
					return false;
			}
			break;
		}
		return true;
	}

	@Override
	public boolean checkTop() {
		// TODO Auto-generated method stub
		return yPosition == 0;
	}
	
}

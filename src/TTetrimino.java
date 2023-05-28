
public class TTetrimino extends Tetrimino {

	public TTetrimino(int[][] board) {
		super(board);
		xPosition = 3;
		yPosition = 1;
		numberValue = 6;
	}

	@Override
	public void rotate() {
		// TODO Auto-generated method stub
		placeOrDelete(false);
		switch(orientation) {
		case 1:
			if(checkPlacement(xPosition + 1, yPosition - 1, 2)) {
				xPosition ++;
				yPosition --;
				orientation ++;
			}
			break;
		case 2:
			if(checkPlacement(xPosition + 1, yPosition + 1, 3)) {
				xPosition ++;
				yPosition ++;
				orientation ++;
			}
			break;
		case 3:
			if(checkPlacement(xPosition - 1, yPosition + 1, 4)) {
				xPosition --;
				yPosition ++;
				orientation ++;
			}
			break;
		case 4:
			if(checkPlacement(xPosition - 1, yPosition - 1, 1)) {
				xPosition --;
				yPosition --;
				orientation -= 3;
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
				for(int i = xPosition; i < xPosition + 3; i++)
					board[yPosition][i] = num;
				board[yPosition - 1][xPosition + 1] = num;
				return true;
			case 2:
				for(int i = yPosition; i < yPosition + 3; i++) 
					board[i][xPosition] = num;
				board[yPosition + 1][xPosition + 1] = num;
				return true;
			case 3:
				for(int i = xPosition; i > xPosition - 3; i--) 
					board[yPosition][i] = num;
				board[yPosition + 1][xPosition - 1] = num;
				return true;
			case 4:
				for(int i = yPosition; i > yPosition - 3; i--)
					board[i][xPosition] = num;
				board[yPosition - 1][xPosition - 1] = num;
				return true;
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
		switch(changeOrientation) {
		case 1:
			if(changeX < 0 || changeY >= board.length)
				return false;
			for(int i = changeX; i < changeX + 3; i++) {
				if(i >= board[0].length || changeY >= board.length) 
					return false;
				if(board[changeY][i] != 0)
					return false;
			}
			if(board[changeY - 1][changeX + 1] != 0) 
				return false;
			break;
		case 2:
			if(changeX + 1 >= board[0].length) {
				return false;
			}
			for(int i = changeY; i < changeY + 3; i++) {
				if(i >= board.length) {
					return false;
				}
				if(board[i][changeX] != 0) {
					return false;
				}
			}
			if(board[changeY + 1][changeX + 1] != 0) {
				return false;
			}
			break;
		case 3:
			if(changeY + 1 >= board.length || changeX >= board[0].length)
				return false;
			for(int i = changeX; i > changeX - 3; i--) {
				if(i < 0)
					return false;
				if(board[changeY][i] != 0)
					return false;
			}
			if(board[changeY + 1][changeX - 1] != 0)
				return false;
			break;
		case 4:
			if(changeX - 1 < 0 || changeY > board.length)
				return false;
			for(int i = changeY; i > changeY - 3; i--) {
				if(i < 0)
					return false;
				if(board[i][changeX] != 0)
					return false;
			}
			if(board[changeY - 1][changeX - 1] != 0)
				return false;
			break;
		}
		return true;
	}

	@Override
	public boolean checkTop() {
		// TODO Auto-generated method stub
		return yPosition == 1;
	}

}


public class JTetrimino extends Tetrimino {

	public JTetrimino(int[][] board) {
		super(board);
		xPosition = 3;
		yPosition = 0;
		numberValue = 2;
	}

	@Override
	public void rotate() {
		// TODO Auto-generated method stub
		placeOrDelete(false);
		switch(orientation) {
		case 1:
			if(checkPlacement(xPosition + 2, yPosition, 2)) {
				xPosition += 2;
				orientation ++;
			}
			break;
		case 2:
			if(checkPlacement(xPosition, yPosition + 2, 3)) {
				yPosition += 2;
				orientation ++;
			}
			break;
		case 3:
			if(checkPlacement(xPosition - 2, yPosition, 4)) {
				xPosition -= 2;
				orientation ++;
			}
			break;
		case 4:
			if(checkPlacement(xPosition, yPosition - 2, 1)) {
				yPosition -= 2;
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
			switch(orientation) {
			case 1:
				board[yPosition][xPosition] = num;
				for(int i = xPosition; i < xPosition + 3; i++)
					board[yPosition + 1][i] = num;
				return true;
			case 2:
				board[yPosition][xPosition] = num;
				for(int i = yPosition; i < yPosition + 3; i++) 
					board[i][xPosition - 1] = num;
				return true;
			case 3:
				board[yPosition][xPosition] = num;
				for(int i = xPosition; i > xPosition - 3; i--) 
					board[yPosition - 1][i] = num;
				return true;
			case 4:
				board[yPosition][xPosition] = num;
				for(int i = yPosition; i > yPosition - 3; i--)
					board[i][xPosition + 1] = num;
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
	protected boolean checkPlacement(int changeX, int changeY, int changeOrientation) {
		// TODO Auto-generated method stub
		switch(changeOrientation) {
		case 1:
			if(changeX < 0 || changeY < 0 || changeY + 1 >= board.length) 
				return false;
			if(board[changeY][changeX] != 0) {
				return false;
			}
			for(int i = changeX; i < changeX + 3; i++) {
				if(i >= board[0].length) {
					return false;
				}
				if(board[changeY + 1][i] != 0) { 
					return false;
				}
			}
			break;
		case 2:
			if(changeX >= board[0].length || changeY < 0 || changeX - 1 < 0)
				return false;
			if(board[changeY][changeX] != 0)
				return false;
			for(int i = changeY; i < changeY + 3; i++) {
				if(i >= board.length)
					return false;
				if(board[i][changeX - 1] != 0)
					return false;
			}
			break;
		case 3:
			if(changeY >= board.length || changeX >= board[0].length || changeY - 1 < 0)
				return false;
			if(board[changeY][changeX] !=0)
				return false;
			for(int i = changeX; i > changeX - 3; i--) {
				if(i < 0)
					return false;
				if(board[changeY - 1][i] != 0) 
					return false;
			}
			break;
		case 4:
			if(changeX < 0 || changeY >= board.length || changeX + 1 >= board[0].length)
				return false;
			if(board[changeY][changeX] != 0)
				return false;
			for(int i = changeY; i > changeY - 3; i--) {
				if(i < 0)
					return false;
				if(board[i][changeX + 1] != 0)
					return false;
			}
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

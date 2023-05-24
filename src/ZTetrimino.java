
public class ZTetrimino extends Tetrimino{

	ZTetrimino(int[][] board) {
		super(board);
		xPosition = 3;
		yPosition = 0;
		numberValue = 7;
	}

	@Override
	public void rotate() {
		// TODO Auto-generated method stub
		placeOrDelete(false);  //deletes the old squares before replacing them 
		switch(orientation) {
		case 1:
			if(checkPlacement(xPosition + 2, yPosition, 2)) {
				orientation = 2;
				xPosition +=2;
			}
			break;
		case 2:
			if(checkPlacement(xPosition - 2, yPosition + 1, 3)) {
				orientation = 3;
				xPosition -=2;
				yPosition ++;
			}
			break;
		case 3:
			if(checkPlacement(xPosition + 1, yPosition - 1, 4)) {
				orientation = 4;
				xPosition ++;
				yPosition --;
			}
			break;
		case 4:
			if(checkPlacement(xPosition - 1, yPosition, 1)) {
				orientation = 1;
				xPosition -=1;
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
			switch(orientation) {
			
			
			case 1:
			case 3:
				board[yPosition][xPosition] = num;  
				board[yPosition][xPosition+1] = num;
				board[yPosition+1][xPosition+1] = num;
				board[yPosition+1][xPosition+2] = num;
				return true;
				
				
			case 2:
			case 4:
				board[yPosition][xPosition] = num;
				board[yPosition+1][xPosition] = num;
				board[yPosition+1][xPosition-1] = num;
				board[yPosition+2][xPosition-1] = num;
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
		switch(orientation) {
		
			
				
			case 3:
			case 1:
				if(board[changeY][changeX]>0)
					return false;
				if(board[changeY][changeX+1]>0)
					return false;
				if(board[changeY+1][changeX+1]>0)
					return false;
				if(board[changeY+1][changeX+2]>0)
					return false;     //checking if there is a block in that place
				
				if(changeX+2>=board[0].length)   //checking too far right
					return false;
				if(changeX<0)   //checking left
					return false;
				if(changeY<0)  //up
					return false;
				if(changeY>=board.length)
					return false;        //down
				break;
		
			case 4:
			case 2:
				if(board[changeY][changeX]>0)
					return false;
				if(board[changeY+1][changeX]>0)
					return false;
				if(board[changeY+1][changeX-1]>0)
					return false;
				if(board[changeY+2][changeX-1]>0)
					return false;      //checking if there are already blocks in this spot
				
				if(changeX>=board[0].length)   //checking too far right
					return false;
				if(changeX-1<0)   //checking left
					return false;
				if(changeY<0)  //up
					return false;
				if(changeY+2>=board.length)
					return false;        //down
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

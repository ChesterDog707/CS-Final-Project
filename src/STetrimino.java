
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
		int num;  // maybe int num needs to be declared here tell nathan
		if(place)
			num = numberValue;
		else 
			num=0;
		if(num > 0 && checkPlacement(xPosition, yPosition, orientation)) 
			return place(num);
		else
			return place(0);
				
	}
	private boolean place(int num) {
		switch(orientation) {
		
		case 3:
		case 1:  //filling in the blocks on the 2d array with the "num"; making them into a different color
			System.out.println("here " + num);
			board[yPosition][xPosition] = num;  
			board[yPosition][xPosition+1] = num;
			board[yPosition-1][xPosition+1] = num;
			board[yPosition-1][xPosition+2] = num;
			return true;
		
		case 4:
		case 2:
			System.out.println("here " + num);
			board[yPosition][xPosition] = num;
			board[yPosition+1][xPosition] = num;
			board[yPosition+1][xPosition+1] = num;
			board[yPosition+2][xPosition+1] = num;
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
		switch(orientation) {
		
		
		
		case 3:
		case 1:
			if(changeX+2>=board[0].length)   //checking too far right
				return false;
			if(changeX<0)   //checking left
				return false;
			if(changeY-1<0)  //up
				return false;
			if(changeY>=board.length)
				return false;        //down
			
			if(board[changeY][changeX]>0)
				return false;
			if(board[changeY][changeX+1]>0)
				return false;
			if(board[changeY-1][changeX+1]>0)
				return false;
			if(board[changeY-1][changeX+2]>0)
				return false;      //checking if there are already blocks in this spot

			break;
			
		case 4:
		case 2:
			if(changeX+1>=board[0].length)   //checking too far right
				return false;
			if(changeX<0)   //checking left
				return false;
			if(changeY<0)  //up
				return false;
			if(changeY+2>=board.length)
				return false;        //down
			
			if(board[changeY][changeX]>0)
				return false;
			if(board[changeY+1][changeX]>0)
				return false;
			if(board[changeY+1][changeX+1]>0)
				return false;
			if(board[changeY+2][changeX+1]>0)
				return false;      //checking if there are already blocks in this spot
			
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

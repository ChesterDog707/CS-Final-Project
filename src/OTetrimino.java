
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
		return;  //i just wrote return cuz i dont think anything is needed
	}

	@Override
	public boolean placeOrDelete(boolean place) {
		// TODO Auto-generated method stub
		int num;
		if(place)
			num = numberValue;
		else
			num=0;
			
		board[yPosition][xPosition] = num;  
		board[yPosition][xPosition+1] = num;
		board[yPosition+1][xPosition] = num;
		board[yPosition+1][xPosition+1] = num;
		
		
		
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
		if(changeY + 1 >= board.length || changeX + 1 >= board[0].length || changeX < 0)
			return false;
		if(board[changeY][changeX]>0)
			return false;
		if(board[changeY][changeX+1]>0)
			return false;
		if(board[changeY+1][changeX]>0)
			return false;
		if(board[changeY+1][changeX+1]>0)
			return false;      //checking if there are already blocks in this spot
		
		if(changeX+1>=board[0].length)   //checking too far right
			return false;
		if(changeX<0)   //checking left
			return false;
		if(changeY<0)  //up
			return false;
		if(changeY+1>=board.length)
			return false;        //down
		
		
		return true;
	}

	@Override
	public boolean checkTop() {
		// TODO Auto-generated method stub
		return yPosition == 0;
	}
	

}

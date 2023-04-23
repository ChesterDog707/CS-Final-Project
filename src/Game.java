
public class Game {

	private Tetrimino currentPiece;
	private Tetrimino heldPiece;
	private Board screen;
	private final long STARTTIME = System.currentTimeMillis();
	private int score;
	
	public Game() {
		currentPiece = null;
		heldPiece = null;
		screen = new Board();
		score = 0;
	}
	 
	public Tetrimino getCurrentPiece() {
		return currentPiece;
	}
	public void setCurrentPiece(Tetrimino currentPiece) {
		this.currentPiece = currentPiece;
	}
	public Tetrimino getHeldPiece() {
		return heldPiece;
	}
	public void setHeldPiece(Tetrimino heldPiece) {
		this.heldPiece = heldPiece;
	}
	public Board getScreen() {
		return screen;
	}
	public void setScreen(Board screen) {
		this.screen = screen;
	}
	
	public int timer() {
		return (int) (System.currentTimeMillis() - STARTTIME);
	}
	
	public void holdPiece() {
		if(heldPiece == null) {
			heldPiece = currentPiece;
			currentPiece = null;
			heldPiece.resetPosition();
			generateNewCurrentPiece();
			return;	
		}else {
			swapHeldPiece();
		}
	}
	
	private void swapHeldPiece() {
		Tetrimino temp = currentPiece;
		currentPiece = heldPiece;
		heldPiece = temp;
	}
	
	public void generateNewCurrentPiece() {
		int x = (int)(Math.random() * 7);
		switch(x) {
		case 0:
			currentPiece = new ITetrimino();
			return;
		case 1:
			currentPiece = new JTetrimino();
			return;
		case 2:
			currentPiece = new LTetrimino();
			return;
		case 3:
			currentPiece = new OTetrimino();
			return;
		case 4:
			currentPiece = new STetrimino();
			return;
		case 5:
			currentPiece = new TTetrimino();
			return;
		case 6:
			currentPiece = new ZTetrimino();
			return;
		}
	}
	public boolean checkGameOver() {
		for (int i = 0; i < 10; i++) 
			if(screen.getBoard()[0][i] != 0 && !currentPiece.checkDefaultPosition())
				return true;
		return false;
	}
	public void gameUpdate() {
		if(timer() % 100 == 0) {
			
		}
	}
}

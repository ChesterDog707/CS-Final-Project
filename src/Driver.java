
public class Driver {
	
	public static void main(String[] args) {
		Game game = new Game();
		Panel window = new Panel(game.getScreen());
		Board board = window.getBoard();
	}
}

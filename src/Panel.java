import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel{
	Game game;
	double tick;
	Timer timer = new Timer((int)tick, new Timey());;
	private static final double[] tickAtLevel  = {798.7, 715.5, 632.3, 549.1, 465.9, 382.7, 299.5, 216.3, 133.1, 99.8, 83.2, 83.2, 83.2, 66.6, 66.6, 66.6, 49.9, 49.9, 49.9, 33.3, 33.3, 33.3, 33.3, 33.3, 33.3, 33.3, 33.3, 33.3, 33.3, 16.4}; 
	BufferedImage I = null;
	BufferedImage J = null;
	BufferedImage L = null;
	BufferedImage O = null;
	BufferedImage S = null;
	BufferedImage T = null;
	BufferedImage Z = null;
	BufferedImage Logo = null;
	BufferedImage Up = null;
	BufferedImage Down = null;
	BufferedImage Left = null;
	BufferedImage Right = null;
	BufferedImage Space = null;
	BufferedImage Shift = null;
	{try{I = ImageIO.read(new File("Assets/ITetrimino.png"));} catch(IOException e) {}}
	{try{J = ImageIO.read(new File("Assets/JTetrimino.png"));} catch(IOException e) {}}
	{try{L = ImageIO.read(new File("Assets/LTetrimino.png"));} catch(IOException e) {}}
	{try{O = ImageIO.read(new File("Assets/OTetrimino.png"));} catch(IOException e) {}}
	{try{S = ImageIO.read(new File("Assets/STetrimino.png"));} catch(IOException e) {}}
	{try{T = ImageIO.read(new File("Assets/TTetrimino.png"));} catch(IOException e) {}}
	{try{Z = ImageIO.read(new File("Assets/ZTetrimino.png"));} catch(IOException e) {}}
	{try{Logo = ImageIO.read(new File("Assets/Tetris Logo.png"));} catch(IOException e) {}}
	{try{Up = ImageIO.read(new File("Assets/Up Arrow.png"));} catch(IOException e) {}}
	{try{Down = ImageIO.read(new File("Assets/Down Arrow.png"));} catch(IOException e) {}}
	{try{Left = ImageIO.read(new File("Assets/Left Arrow.png"));} catch(IOException e) {}}
	{try{Right = ImageIO.read(new File("Assets/Right Arrow.png"));} catch(IOException e) {}}
	{try{Space = ImageIO.read(new File("Assets/Space Bar.png"));} catch(IOException e) {}}
	{try{Shift = ImageIO.read(new File("Assets/Shift Key.png"));} catch(IOException e) {}}
	int gameState;
	public Panel(Game game) {
		this.game = game;
		updateTick();
		gameState = 1;
		timer.start();
		addKeyListener(new key());
		setFocusable(true);
	}
	
	public Board getBoard() {
		return game.getBoard();
	}
	public void setBoard(Board board) {
		game.setboard(board); 
	}
	public static double[] getTickatlevel() {
		return tickAtLevel;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		if(gameState == 1) {
			g.drawRect(0, 0, 620, 880);
			g2.drawImage(Logo, 150, 20, 300, 210, null);
			g2.setFont(new Font(g2.getFont().getFontName(), Font.BOLD, 30));
			g2.setColor(Color.BLUE);
			g2.drawString("CONTROLS:", 215, 300);
			g2.drawImage(Left, 30, 340, 50, 50, null);
			g2.drawImage(Right, 90, 340, 50, 50, null);
			g2.drawImage(Up, 60, 420, 50, 50, null);
			g2.drawImage(Down, 60, 500, 50, 50, null);
			g2.drawImage(Shift, 30, 580, 133, 50, null);
			g2.drawImage(Space, 30, 660, 313, 50, null);
			g2.setFont(new Font(g2.getFont().getFontName(), Font.PLAIN, 20));
			g2.drawString("Move Tetrimino left or right", 180, 370);
			g2.drawString("Rotate Tetrimino clockwise", 150, 450);
			g2.drawString("Move Tetrimino downwards quickly", 150, 530);
			g2.drawString("Instantly move Tetrimino to the bottom", 203, 610);
			g2.drawString("Hold Tetrimino", 383, 690);
			g2.setFont(new Font(g2.getFont().getFontName(), Font.BOLD, 30));
			g2.drawString("PRESS ANY KEY TO START", 85, 780);
		}else if(gameState == 2) {
			game.getBoard().drawBoard(g);
			g.setColor(Color.black);
			g2.setColor(Color.black);
			g2.setFont(new Font(g2.getFont().getFontName(), Font.PLAIN, 30));
			g2.drawString("SCORE: " + game.getScore(), 0, 30);
			g2.drawString("LEVEL: " + game.getLevel(), 275, 30);
			g2.drawString("NEXT:", 425, 100);
			g2.drawString("HELD:", 425, 350);
			g.drawRect(425, 115, 161, 163);
			g.drawRect(425, 365, 161, 163);
			g.setColor(Color.white);
			g.fillRect(426, 116, 160, 162);
			g.fillRect(426, 366, 160, 162);
			drawHeldPiece(g2);
			drawNextPiece(g2);
		}else if(gameState == 3) {
			game.getBoard().drawBoard(g);
			g.setColor(Color.black);
			g2.setColor(Color.black);
			g2.setFont(new Font(g2.getFont().getFontName(), Font.PLAIN, 30));
			g2.drawString("SCORE: " + game.getScore(), 0, 30);
			g2.drawString("LEVEL: " + game.getLevel(), 275, 30);
			g2.drawString("NEXT:", 425, 100);
			g2.drawString("HELD:", 425, 350);
			g.drawRect(425, 115, 161, 163);
			g.drawRect(425, 365, 161, 163);
			g.setColor(Color.white);
			g.fillRect(426, 116, 160, 162);
			g.fillRect(426, 366, 160, 162);
			drawHeldPiece(g2);
			drawNextPiece(g2);
			g2.setFont(new Font(g2.getFont().getFontName(), Font.PLAIN, 60));
			g2.setColor(new Color(122, 0, 0));
			g2.drawString("GAME OVER", 20, 400);
			g2.setFont(new Font(g2.getFont().getFontName(), Font.PLAIN, 20));
			g2.drawString("Press R to restart", 120, 420);
		}
	}
	private int pieceToNum(Tetrimino t) {
		if(t instanceof ITetrimino)
			return 1;
		else if(t instanceof JTetrimino) 
			return 2;
		else if(t instanceof LTetrimino)
			return 3;
		else if(t instanceof OTetrimino)
			return 4;
		else if(t instanceof STetrimino)
			return 5;
		else if(t instanceof TTetrimino)
			return 6;
		else if(t instanceof ZTetrimino)
			return 7;
		else
			return 0;
	}
	private void drawHeldPiece(Graphics2D g2) {
		int x = pieceToNum(game.getHeldPiece());
		switch(x) {
		case 1:
			g2.drawImage(I, null, 426, 425);
			break;
		case 2:
			g2.drawImage(J, null, 446, 405);
			break;
		case 3:
			g2.drawImage(L, null, 446, 405);
			break;
		case 4:
			g2.drawImage(O, null, 466, 405);
			break;
		case 5:
			g2.drawImage(S, null, 445, 405);
			break;
		case 6:
			g2.drawImage(T, null, 445, 405);
			break;
		case 7:
			g2.drawImage(Z, null, 445, 405);
			break;
		}
	}
	private void drawNextPiece(Graphics2D g2) {
		int x = pieceToNum(game.getNextPiece());
		switch(x) {
		case 1:
			g2.drawImage(I, null, 426, 175);
			break;
		case 2:
			g2.drawImage(J, null, 446, 155);
			break;
		case 3:
			g2.drawImage(L, null, 446, 155);
			break;
		case 4:
			g2.drawImage(O, null, 466, 155);
			break;
		case 5:
			g2.drawImage(S, null, 445, 155);
			break;
		case 6:
			g2.drawImage(T, null, 445, 155);
			break;
		case 7:
			g2.drawImage(Z, null, 445, 155);
			break;
		}
	}
	public void updateTick() {
		if(game.getLevel() < 30)
			tick = tickAtLevel[game.getLevel()];
		else
			tick = tickAtLevel[29];
		timer.setDelay((int) tick);
	}
	
	private class Timey implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(!game.checkGameOver() && gameState == 2) {
				game.resetPiece();
				if(game.checkGameOver())
					return;
				if(game.getCurrentPiece().isFirstPlace())
					game.getCurrentPiece().setFirstPlace(false);
				else
					game.getCurrentPiece().move(0, 1);
				//updateTick();
				repaint();
			}else if(!game.checkGameOver())
				repaint();
			else {
				gameState = 3;
				repaint();
			}
		}
	}
	private class key implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			int type = e.getKeyCode();
			if(gameState == 1) {
				gameState = 2;
				repaint();
			}else if(gameState == 2) {
				if(type == KeyEvent.VK_SPACE) {
					if(gameState == 2)
						game.holdPiece();
				}else if(type == KeyEvent.VK_UP) {
					if(gameState == 2)
						game.getCurrentPiece().rotate(); 
				}else if(type == KeyEvent.VK_LEFT) {
					if(gameState == 2)
						game.getCurrentPiece().move(-1, 0);
				}else if(type == KeyEvent.VK_RIGHT) {
					if(gameState == 2)
						game.getCurrentPiece().move(1,  0);
				}else if(type == KeyEvent.VK_SHIFT) {
					if(gameState == 2) {
						int i = game.getCurrentPiece().getYPosition() + 1;
						game.getCurrentPiece().placeOrDelete(false);
						while(game.getCurrentPiece().checkPlacement(game.getCurrentPiece().getXPosition(), i, game.getCurrentPiece().getOrientation())) {
							game.getCurrentPiece().move(0, 1);
							game.getCurrentPiece().placeOrDelete(true);
							repaint();
							game.getCurrentPiece().placeOrDelete(false);
							i++;
						}
						game.getCurrentPiece().placeOrDelete(true);
					}
				}else if(type == KeyEvent.VK_DOWN) {
					timer.setDelay(30);
				}
			}else if(gameState == 3) {
				if(type == KeyEvent.VK_R) {
					game = new Game();
					gameState = 2;
					timer.setDelay((int) tickAtLevel[0]);
					repaint();
				}
			}
			repaint();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			int type = e.getKeyCode();
			if(type == KeyEvent.VK_DOWN && gameState == 2) {
				timer.setDelay((int) (tickAtLevel[game.getLevel()]));
			}
		}
		
	}
}

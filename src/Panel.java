import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel{
	Game game;
	double tick;
	private static final double[] tickAtLevel  = {798.7, 715.5, 632.3, 549.1, 465.9, 382.7, 299.5, 216.3, 133.1, 99.8, 83.2, 83.2, 83.2, 66.6, 66.6, 66.6, 49.9, 49.9, 49.9, 33.3, 33.3, 33.3, 33.3, 33.3, 33.3, 33.3, 33.3, 33.3, 33.3, 16.4}; 
	BufferedImage I = null;
	BufferedImage J = null;
	BufferedImage L = null;
	BufferedImage O = null;
	BufferedImage S = null;
	BufferedImage T = null;
	BufferedImage Z = null;
	{try{I = ImageIO.read(new File("Tetriminos/ITetrimino.png"));} catch(IOException e) {}}
	{try{J = ImageIO.read(new File("Tetriminos/JTetrimino.png"));} catch(IOException e) {}}
	{try{L = ImageIO.read(new File("Tetriminos/LTetrimino.png"));} catch(IOException e) {}}
	{try{O = ImageIO.read(new File("Tetriminos/OTetrimino.png"));} catch(IOException e) {}}
	{try{S = ImageIO.read(new File("Tetriminos/STetrimino.png"));} catch(IOException e) {}}
	{try{T = ImageIO.read(new File("Tetriminos/TTetrimino.png"));} catch(IOException e) {}}
	{try{Z = ImageIO.read(new File("Tetriminos/ZTetrimino.png"));} catch(IOException e) {}}
	int gameState;
	public Panel(Game game) {
		this.game = game;
		updateTick();
		gameState = 2;
		Timer timer = new Timer((int)tick, new Timey());
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
		}
		if(gameState == 2) {
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
	}
	
	private class Timey implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(!game.checkGameOver()) {
				game.resetPiece();
				if(game.checkGameOver())
					return;
				game.getCurrentPiece().move(0, 1);
				updateTick();
				repaint();
			}else {
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
			}
			if(type == KeyEvent.VK_SPACE) {
				if(gameState == 2)
					game.holdPiece();
			}else if(type == KeyEvent.VK_UP) {
				if(gameState == 2)
					game.getCurrentPiece().rotate(); 
			}
			else if(type == KeyEvent.VK_LEFT) {
				if(gameState == 2)
					game.getCurrentPiece().move(-1, 0);
			}else if(type == KeyEvent.VK_RIGHT) {
				if(gameState == 2)
					game.getCurrentPiece().move(1,  0);
			}else if(type == KeyEvent.VK_DOWN) {
				if(gameState == 2) {
					int i = game.getCurrentPiece().getYPosition() + 1;
					game.getCurrentPiece().placeOrDelete(false);
					while(game.getCurrentPiece().checkPlacement(game.getCurrentPiece().getXPosition(), i, game.getCurrentPiece().getOrientation())) {
						game.getCurrentPiece().move(0, 1);
						i++;
					}
					game.getCurrentPiece().placeOrDelete(true);
				}
			}else if(type == KeyEvent.VK_R) {
				if(gameState == 3) {
					game = new Game();
					gameState = 2;
					repaint();
				}
			}
			repaint();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	private class click implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}

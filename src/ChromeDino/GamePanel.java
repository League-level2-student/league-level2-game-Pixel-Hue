package ChromeDino;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.concurrent.ConcurrentSkipListSet;

import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	public static BufferedImage image;
	public static BufferedImage image2;
	public static boolean needImage = true;
	public static boolean needImage2 = true;
	public static boolean gotImage = false;
	public static boolean gotImage2 = false;
	boolean gameStarted = false;
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	final int INSTRUCT = 3;
	int currentState = MENU;
	int score = 0;
	int imnum= 1;
	Timer frameDraw;
	Timer spawnRate;
	Font MenuFont;
	Font SubtitleFont;
	Font TestFont;
	Font SmallFont;
	Dino ds = new Dino(64, 128, 64, 64);
	ObjectManager om;

	public GamePanel() {
		om = new ObjectManager(ds);
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();

		MenuFont = new Font("Arial Rounded MT Bold", Font.BOLD, 48);
		TestFont = new Font("Arial Rounded MT Bold", Font.BOLD, 36);
		SmallFont = new Font("Arial Rounded MT Bold", Font.BOLD, 24);
		if (needImage) {
			loadImage("bg.png");
			imnum++;
			loadImage("howToPlay.png");
		}

	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		} else if (currentState == INSTRUCT) {
			drawInstructState(g);
		}
	}

	void updateMenuState() {

	}

	void updateGameState() {

		om.update();
		if (ds.isActive == false) {
			System.out.println("run");
			currentState = END;
		}
	}

	void updateEndState() {

	}

	void updateInstructState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, ChromeDino.WIDTH, ChromeDino.HEIGHT);
		g.setFont(MenuFont);
		g.setColor(Color.WHITE);
		g.drawString("Chrome Dino Game", 80, 140);
		g.setFont(SubtitleFont);
		g.setColor(Color.GREEN);
		g.drawString("Press ENTER to Start", 55, 200);
		g.setColor(Color.WHITE);
		g.setFont(TestFont);
		g.drawString("Press Space for Instructions", 55, 250);
	}

	void drawGameState(Graphics g) {
		if (gotImage) {
			g.drawImage(image, -10, 0, 640, 330, null);
		} else {
			g.setColor(Color.ORANGE);
			g.fillRect(0, 0, ChromeDino.WIDTH, ChromeDino.HEIGHT);
		}
		om.draw(g);

		g.setFont(TestFont);
		g.setColor(Color.WHITE);
		g.drawString("Score: " + score, 10, 40);
		score++;
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 640, 360);
		g.setFont(TestFont);
		g.setColor(Color.WHITE);
		g.drawString("You got a score of " + score, 100, 160);
		g.setColor(Color.GREEN);
		g.drawString("Press ENTER to play again!", 60, 240);
		g.setColor(Color.WHITE);
		g.setFont(SmallFont);
		g.drawString("Press Space to Return to The Main Menu", 60, 270);
		endGame();
	}

	void drawInstructState(Graphics g) {
	
		g.drawImage(image2, 0, 0, 640, 330, null);
	
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 640, 360);
			g.setFont(TestFont);
			g.setColor(Color.WHITE);
			g.drawString("How to play", 50, 40);
			g.setFont(SmallFont);
			g.drawString("W to move up", 80, 90);
			g.drawString("S to move down", 65, 140);
//add how to picture
			g.drawString("Your goal is to survive", 35, 180);
			g.drawString("and doge cati for as long", 20, 200);
			g.drawString("as possible", 95, 220);
		
		}
	

	private void startGame() {
		ds.isActive = true;
		spawnRate = new Timer(500, om);
		spawnRate.start();
		score = 0;
		ds.y = 128;
	}

	private void endGame() {
		spawnRate.stop();
		om.purgeObjects();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			updateMenuState();

			repaint();
		} else if (currentState == GAME) {
			updateGameState();

			repaint();
		} else if (currentState == END) {
			updateEndState();

			repaint();
		} else if (currentState == INSTRUCT) {
			updateEndState();

			repaint();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(gameStarted);

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {

				currentState = GAME;
				gameStarted = false;
			} else if (currentState == MENU) {
				currentState = GAME;
				gameStarted = false;
			}
		}
		if (gameStarted == false && currentState == GAME) {

			startGame();
			gameStarted = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (currentState == MENU) {
				currentState = INSTRUCT;
			} else if (currentState == INSTRUCT) {
				currentState = MENU;
			} else if (currentState == END) {
				currentState = MENU;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			System.out.println("up");
			ds.up();
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			System.out.println("down");
			ds.down();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	void loadImage(String imageFile) {

		if (needImage) {

			try {
if (imnum ==1) {
	image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
} else if (imnum==2) {
	image2 = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
}
			
				
				
				
				
				gotImage = true;

			} catch (Exception e) {

			}
			needImage = false;

		}
	}
}

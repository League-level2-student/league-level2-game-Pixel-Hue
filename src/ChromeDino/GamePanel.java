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
	boolean learnInstruct = false;
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	final int INSTRUCT = 3;
	int currentState = MENU;
	int score = 0;
	int imnum = 1;
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
			imnum++;
		
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
		g.drawString("Chrome Dino 2", 110, 140);
		g.setFont(SubtitleFont);
	
		
		g.setColor(Color.GREEN);
	if (learnInstruct) {
		g.drawString("Press ENTER to Start", 45, 230);
	} else {
		g.setColor(Color.darkGray);
		g.drawString("Press ENTER to Start", 45, 230);
	}
	
		g.setColor(Color.GREEN);
		g.setFont(TestFont);
		if (learnInstruct) {
			g.setColor(Color.WHITE);
			g.drawString("Press Space for Instructions", 45, 180);
		} else {
			g.drawString("Press Space for Instructions", 45, 180);
		}
	

	
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
		if (learnInstruct) {
			g.drawString("PRESS SPACE TO RETURN TO THE MAIN MENU", 30, 270);
		} else {
			g.drawString("PRESS SPACE TO READ INSTRUCTIONS", 65, 270);
		}
		
		
		endGame();
	}

	void drawInstructState(Graphics g) {
		learnInstruct = true;
		if (gotImage2) {
			g.drawImage(image2, 0, 0, 625, 330, null);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 640, 360);
			g.setFont(TestFont);
			g.setColor(Color.WHITE);
			g.drawString("How to play", 50, 40);
			g.setFont(SmallFont);
			g.drawString("W to move up", 80, 90);
			g.drawString("S to move down", 65, 140);

			g.drawString("   Your goal is to survive for as", 35, 180);
			g.drawString(" long as possible for a better score", 20, 200);

			g.drawString("Press space to return", 295, 90);
			g.drawString("to the main menu", 320, 110);

			g.drawString("To survive you have to dodge cacti", 25, 280);
		}
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
			ds.up();
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			ds.down();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	void loadImage(String imageFile) {

		try {
			if (imnum == 1) {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
			} else if (imnum == 2) {
				image2 = ImageIO.read(this.getClass().getResourceAsStream(imageFile));

			}

			gotImage = true;
gotImage2=true;
		} catch (Exception e) {

		}
		needImage = false;

	}
}

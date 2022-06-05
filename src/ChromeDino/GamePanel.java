package ChromeDino;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Timer frameDraw;
	Font MenuFont;
	Font SubtitleFont;
	Dino ds = new Dino(64, 128, 64, 64);
	ObjectManager om;

	public GamePanel() {
		om = new ObjectManager(ds);
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
		MenuFont = new Font("Arial", Font.PLAIN, 48);
	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	void updateMenuState() {

	}

	void updateGameState() {
om.update();
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, ChromeDino.WIDTH, ChromeDino.HEIGHT);
		g.setFont(MenuFont);
		g.setColor(Color.WHITE);
		g.drawString("Chrome Dino Game", 80, 160);
		g.setFont(SubtitleFont);
		g.drawString("Press Space to Start", 75, 220);
	}

	void drawGameState(Graphics g) {
		if (gotImage) {
			g.drawImage(image, 0, 0, 500, 800, null);
		} else {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, ChromeDino.WIDTH, ChromeDino.HEIGHT);
		}
		om.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 640, 360);
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
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				currentState = MENU;
				System.out.println("st");
			} else {
				currentState++;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			currentState = GAME;
			System.out.println("3");
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
}

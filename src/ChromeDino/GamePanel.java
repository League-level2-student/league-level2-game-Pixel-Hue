package ChromeDino;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener {

	final int Menu = 0;
	final int Game = 1;
	final int End = 2;
	int currentState = Menu;
	Timer frameDraw;
	Font MenuFont = new Font("Arial", Font.PLAIN, 48);
	Font SubtitleFont = new Font("Arial", Font.PLAIN, 32);
	public GamePanel() {
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
	}
public void paintComponent (Graphics g) {
	if (currentState == Menu) {
		drawMenuState(g);
	}
	else if (currentState==Game) {
		drawGameState(g);
	}
	else if (currentState==End) {
		drawEndState(g);
	}
}
void updateMenuState () {
	
}
void updateGameState () {
	
}
void updateEndState () {
	
}
void drawMenuState (Graphics g) {
	g.setColor(Color.GRAY);
	g.fillRect(0, 0, 640, 360);
	g.setFont(MenuFont);
	g.setColor(Color.WHITE);
	g.drawString("Chrome Dino Game", 80, 160);
	g.setFont(SubtitleFont);
	g.drawString("Press Space to Start", 145, 220);
}
void drawGameState (Graphics g) {
	
}
void drawEndState (Graphics g) {
	
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
}

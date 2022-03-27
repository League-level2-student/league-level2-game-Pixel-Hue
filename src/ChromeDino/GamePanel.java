package ChromeDino;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

	final int Menu = 0;
	final int Game = 1;
	final int End = 2;
	int currentState = Menu;
	Font MenuFont = new Font("Arial", Font.PLAIN, 48);
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
	g.setColor(Color.WHITE);
	g.fillRect(0, 0, 640, 360);
}
void drawGameState (Graphics g) {
	
}
void drawEndState (Graphics g) {
	
}
}

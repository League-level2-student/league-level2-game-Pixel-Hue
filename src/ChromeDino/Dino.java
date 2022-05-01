package ChromeDino;

import java.awt.Color;
import java.awt.Graphics;

public class Dino extends GameObject{

	Dino(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 64;
	}
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
		System.out.println(x);
		System.out.println(width);
	}
	public void up() {
		y-=speed;
	}
	public void down() {
		y+=speed;
	}
	public void duck() {
		y+=speed;
	}
}

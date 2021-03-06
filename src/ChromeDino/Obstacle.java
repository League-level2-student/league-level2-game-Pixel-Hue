package ChromeDino;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Obstacle extends GameObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	Obstacle(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed =10;
if (needImage) {
	loadImage("cactus.png");
}
	}

	public void update() {
	
		x -= speed;
	speed++;
			super.update();
	}

	public void draw(Graphics g) {
		if (gotImage = true) {
g.drawImage(image, x, y, 64, 64, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, 64, 64);
		}
	}

	void loadImage(String imageFile) {

		if (needImage) {

			try {

				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));

				gotImage = true;

			} catch (Exception e) {

			}
			needImage = false;
		}
	}
}

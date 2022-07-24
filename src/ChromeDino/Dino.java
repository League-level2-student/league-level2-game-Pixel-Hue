package ChromeDino;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Dino extends GameObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	public Dino(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 64;
	
		if (needImage) {

			loadImage("dino.png");
			
		}
	}

	public void draw(Graphics g) {

		if (gotImage) {

			g.drawImage(image, x, y, 60, 64, null);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(x, y, width, height);
		}
	}

	public void up() {
		if (y>0) {
			y -= speed;
		}
		
	}

	public void down() {
		if (y<240) {
			y += speed;
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

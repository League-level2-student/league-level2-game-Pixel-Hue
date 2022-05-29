package ChromeDino;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Dino extends GameObject {
	public static BufferedImage Image;
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
			System.out.println("draw");
			g.drawImage(Image, x, y, 64, 64, null);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(x, y, width, height);
		}
	}

	public void up() {
		y -= speed;
	}

	public void down() {
		y += speed;
	}

	void loadImage(String imageFile) {

		if (needImage) {

			try {
				System.out.println("loadiamge");
				Image = ImageIO.read(this.getClass().getResourceAsStream("dino.png"));

				System.out.println("loadiamge2");
				gotImage = true;

			} catch (Exception e) {

			}
			needImage = false;
		}
	}
}

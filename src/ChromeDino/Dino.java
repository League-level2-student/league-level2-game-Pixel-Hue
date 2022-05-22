package ChromeDino;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Dino extends GameObject{
public static BufferedImage Image;
public static boolean needImage = true;
public static boolean gotImage = false;
	Dino(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 64;
		if (needImage) {
			loadImage("");
		}
	}
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
		System.out.println(x);
		System.out.println(width);
	}
	void loadImage (String imageFile) {
		if (needImage) {
		try {
			Image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
			gotImage = true;
		} catch (Exception e){
			
		}
		needImage = false;
		}
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

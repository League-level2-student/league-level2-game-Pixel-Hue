package ChromeDino;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;

public class GameObject {
	Rectangle coll;
	int x;
	int y;
	int width;
	int height;
	int speed;
	boolean isActive = true;

	public GameObject(int x, int y, int width, int height) {

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		coll = new Rectangle(x, y, width, height);
	}

	public void update() {
		coll.setBounds(x, y, width, height);
	}

	public void draw(Graphics g) {

	}

}

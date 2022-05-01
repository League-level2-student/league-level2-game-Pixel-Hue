package ChromeDino;

import java.awt.Color;
import java.awt.Graphics;

public class Obstacle extends GameObject {
	
Obstacle(int x, int y, int width, int height){
	super(x,y,width,height);
	speed = 4;
	
	}
public void update() {

	
	x-=speed;
	super.update();
}
public void draw(Graphics g) {
	g.setColor(Color.BLACK);
}
 }

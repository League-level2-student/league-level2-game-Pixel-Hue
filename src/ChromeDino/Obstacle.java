package ChromeDino;

import java.awt.Color;
import java.awt.Graphics;

public class Obstacle extends GameObject {
	
Obstacle(int x, int y, int width, int height){
	super(x,y,width,height);
	speed = 10;
	
	}
public void update() {
System.out.println("update");
	
	x-=speed;
	super.update();
}
public void draw(Graphics g) {
	
	g.setColor(Color.BLUE);
	g.fillRect(x, y, 64, 64);
}
 }

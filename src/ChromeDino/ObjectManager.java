package ChromeDino;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
	Dino ds;
	ArrayList<Obstacle> obstacles = new ArrayList();
	Random ranY;

	public ObjectManager(Dino ds) {
		this.ds = ds;
	}

	void addObstacle() {
		 //make y value be a random number that is an increment of 64
		obstacles.add(new Obstacle(ChromeDino.WIDTH + 64, new Random().nextInt(ChromeDino.HEIGHT), 64, 64));
	}

	void update() {
		ds.update();
		for (int i = 0; i < obstacles.size() - 1; i++) {
			obstacles.get(i).update();
			if (obstacles.get(i).x < -64) {
				obstacles.get(i).isActive = false;
			}
		}
	}

	void draw(Graphics g) {
		ds.draw(g);
		for (int i = 0; i < obstacles.size() - 1; i++) {
			obstacles.get(i).draw(g);
		}
	}

	void purgeObjects() {
		for (int i = 0; i < obstacles.size() - 1; i++) {
			obstacles.remove(i);
		}
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		addObstacle();
		
	}
	}



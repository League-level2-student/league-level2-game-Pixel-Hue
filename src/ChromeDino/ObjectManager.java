package ChromeDino;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Dino ds;
	ArrayList<Obstacle> obstacles = new ArrayList();

	public ObjectManager(Dino ds) {
		this.ds = ds;
	}

	void addObstacle() {
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
		for (int i = 0; i < obstacles.size() - 1; i++) {
			obstacles.get(i).draw(g);
		}
	}

	void purgeObjects() {
		for (int i = 0; i < obstacles.size() - 1; i++) {
			obstacles.remove(i);
		}
		}
	}



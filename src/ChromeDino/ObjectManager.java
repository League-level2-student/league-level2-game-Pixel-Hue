package ChromeDino;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Dino ds;
	Obstacle obstacle;
	ArrayList<Obstacle> obstacles = new ArrayList();
	Random ranY;
	GamePanel gp;

	public ObjectManager(Dino ds) {
		this.ds = ds;

	}

	void addObstacle() {
		obstacles.add(new Obstacle(ChromeDino.WIDTH + 64, new Random().nextInt(5) * 64 + 3, 64, 64));
	}

	void update() {
		ds.update();
		for (int i = 0; i < obstacles.size() - 1; i++) {
			obstacles.get(i).update();
			if (obstacles.get(i).x < -64) {
				obstacles.get(i).isActive = false;
			}
		}
		//checkColl();
		//purgeObjects();
	}

	void draw(Graphics g) {
		ds.draw(g);
		for (int i = 0; i < obstacles.size() - 1; i++) {
			obstacles.get(i).draw(g);
		}
	}

	//void purgeObjects() {
	//	for (int i = 0; i < obstacles.size() - 1; i++) {
	//		obstacles.remove(i);
	//	}
	//}

	//void checkColl() {
	//	if (ds.coll.intersects(obstacle.coll)) {
	//		// make gamestate end
	//	}
	//}

	@Override
	public void actionPerformed(ActionEvent e) {
		addObstacle();

	}
}

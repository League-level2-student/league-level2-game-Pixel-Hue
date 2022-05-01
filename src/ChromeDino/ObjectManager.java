package ChromeDino;

import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
Dino ds;
ArrayList<Obstacle> obstacles;

public ObjectManager(Dino ds) {
	this.ds = ds;
}
void addObstacle() {
	obstacles.add(new Obstacle(new Random().nextInt(ChromeDino.HEIGHT), 0, 64, 64));
}
}

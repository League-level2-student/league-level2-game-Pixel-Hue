package ChromeDino;

import javax.swing.JFrame;

public class ChromeDino {
	static JFrame frame = new JFrame();
	static GamePanel gp = new GamePanel();
	public static final int WIDTH = 640;
	public static final int HEIGHT = 360;

	public static void main(String[] args) {
		ChromeDino cd = new ChromeDino(frame, gp);
		cd.setup();
	}

	public ChromeDino(JFrame frame, GamePanel gp) {
		this.frame = frame;
		this.gp = gp;
	}

	void setup() {
		frame.add(gp);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.addKeyListener(gp);

	}
}

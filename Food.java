import java.awt.Graphics;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Food {
	private Point position;

	public Food(ArrayList<Point> forbiddenPos) {
		generatePos(forbiddenPos);
	}

	// generates randomly food's position (while avoiding snake location)
	// NOTE: Theoretically infinite loop is possible. better implementation is
	// needed!
	public void generatePos(ArrayList<Point> forbiddenPos) {
		position = new Point((int) (Math.random() * Constants.NUM_OF_UNITS) * Constants.UNIT_SIZE,
				(int) (Math.random() * Constants.NUM_OF_UNITS) * Constants.UNIT_SIZE);

		for (Point pos : forbiddenPos)
			if (position.equals(pos)) {
				generatePos(forbiddenPos);
				break;
			}
	}

	public Point getPosition() {
		return position;
	}

	public void draw(Graphics g) {

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("food_mouse_1.png"));
			g.drawImage(img, (int) position.getX(), (int) position.getY(), Constants.UNIT_SIZE, Constants.UNIT_SIZE,
					null);
		} catch (IOException e) {
			g.fillOval((int) position.getX() + Constants.UNIT_SIZE / 4, (int) position.getY() + Constants.UNIT_SIZE / 4,
					Constants.UNIT_SIZE / 2, Constants.UNIT_SIZE / 2);
		}
	}

}

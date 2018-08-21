import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Snake {
	private int length;
	private ArrayList<Point> position; // snake's location(last position represents the head)

	private Direction direction; // current direction of the snake

	public Snake() {
		length = Constants.INITIAL_SNAKE_LENGTH;
		direction = Direction.RIGHT;

		position = new ArrayList<Point>();

		for (int i = length; i > 0; i--)
			position.add(new Point(Constants.INITIAL_SNAKE_POSITION - i * Constants.UNIT_SIZE,
					Constants.INITIAL_SNAKE_POSITION));
	}

	public void eat() {
		length++;
	}

	public boolean isDead(Point newHeadPos) {
		for (int i = 1; i < length - 1; i++)
			if (newHeadPos.equals(position.get(i)))
				return true;
		return false;
	}

	// promotes the snake in one step
	public void crawl(Point newHeadPos) {
		position.add(newHeadPos); // adding the new head position

		// removing the last position if the snake didn't eat
		if (length < position.size())
			position.remove(0);
	}

	public Point nextHeadPosition() {

		Point headPos = getHeadPosition();

		if (direction == Direction.UP)
			headPos = new Point((int) headPos.getX(),
					(int) (headPos.getY() - Constants.UNIT_SIZE + Constants.WORLD_SIZE) % Constants.WORLD_SIZE);
		else if (direction == Direction.DOWN)
			headPos = new Point((int) headPos.getX(),
					(int) (headPos.getY() + Constants.UNIT_SIZE) % Constants.WORLD_SIZE);
		else if (direction == Direction.RIGHT)
			headPos = new Point((int) (headPos.getX() + Constants.UNIT_SIZE) % Constants.WORLD_SIZE,
					(int) headPos.getY());
		else // direction == Direction.LEFT
			headPos = new Point(
					(int) (headPos.getX() - Constants.UNIT_SIZE + Constants.WORLD_SIZE) % Constants.WORLD_SIZE,
					(int) headPos.getY());

		return headPos;
	}

	public Point getHeadPosition() {
		return position.get(position.size() - 1);
	}

	public ArrayList<Point> getPosition() {
		return position;
	}

	public int getLength() {
		return length;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public void draw(Graphics g) {
		int i;
		for (i = 0; i < length; i++)
			g.fillOval((int) position.get(i).getX(), (int) position.get(i).getY(), Constants.UNIT_SIZE,
					Constants.UNIT_SIZE);

		// mark the head of the snake with white dot
		i--;
		g.setColor(Color.WHITE);
		g.fillOval((int) position.get(i).getX() + Constants.UNIT_SIZE / 4,
				(int) position.get(i).getY() + Constants.UNIT_SIZE / 4, Constants.UNIT_SIZE / 2,
				Constants.UNIT_SIZE / 2);
	}
}

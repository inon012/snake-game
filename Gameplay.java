import java.awt.Point;

public class Gameplay {
	private Snake snake;
	private Food food;

	public Gameplay() {
		initial();
	}

	// initials the game
	public void initial() {
		snake = new Snake();
		food = new Food(snake.getPosition());
	}

	// updates the game in every iteration of the game loop
	// returns true if the snake alive, false otherwise
	public boolean update(Direction newDir) {

		snake.setDirection(newDir); // updating the direction (user input)

		Point newPos = snake.nextHeadPosition(); // new head position

		if (snake.isDead(newPos))
			return false;

		if (newPos.equals(food.getPosition())) // in case the snake reach the food
		{
			snake.eat();
			snake.crawl(newPos);
			food.generatePos(snake.getPosition());
		} else // snake didn't reach the food
			snake.crawl(newPos);

		return true;
	}

	public Snake getSnake() {
		return snake;
	}

	public Food getFood() {
		return food;
	}
}

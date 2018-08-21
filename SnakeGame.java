import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class SnakeGame {

	public static void main(String[] args) {

		JFrame frame = new JFrame("SnakeGame");

		Controller snakeGame = new Controller(); // game controller
		frame.add(snakeGame.getView());

		// locates frame in the middle of the screen
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((int) (screen.getWidth() - Constants.WORLD_SIZE) / 2,
				(int) (screen.getHeight() - Constants.WORLD_SIZE) / 2);

		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}

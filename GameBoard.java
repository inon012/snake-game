import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameBoard extends JPanel {

	private static final long serialVersionUID = -4704133854111214634L;

	private Gameplay model;

	public GameBoard(Controller controller, Gameplay model) {
		this.model = model;

		setFocusable(true);
		setPreferredSize(new Dimension(Constants.WORLD_SIZE, Constants.WORLD_SIZE));
		setBackground(Color.CYAN);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// background image
		BufferedImage background = null;
		try {
			background = ImageIO.read(new File("game_background.png"));
			g.drawImage(background, 0, 0, Constants.WORLD_SIZE, Constants.WORLD_SIZE, null);
		} catch (IOException e) {
			// optional: manually draw background
		}

		g.setColor(Color.GREEN);
		model.getSnake().draw(g);

		g.setColor(Color.RED);
		model.getFood().draw(g);

		g.setColor(Color.WHITE);
		g.drawString("Length: " + model.getSnake().getLength(), 1, g.getClipBounds().height - 2);
	}
}

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class GameView extends JPanel {

	private static final long serialVersionUID = 2180702990845924831L;

	private ButtonsBar btnsBar;
	private GameBoard gameBoard;

	public GameView(Controller controller, Gameplay model) {

		btnsBar = new ButtonsBar(controller);
		gameBoard = new GameBoard(controller, model);

		this.setLayout(new BorderLayout());
		add(btnsBar, BorderLayout.NORTH);
		add(gameBoard, BorderLayout.CENTER);

		addKeyListener(controller);

		setFocusable(true);
		setBackground(Color.BLACK);
	}

	public ButtonsBar getBtnsBar() {
		return btnsBar;
	}

}

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonsBar extends JPanel {

	private static final long serialVersionUID = -1619530392653736184L;

	private JButton play;
	private JButton pause;
	private JButton restart;

	public ButtonsBar(Controller controller) {
		GridLayout layout = new GridLayout(1, 0);
		setLayout(layout);

		play = new JButton("Play");
		pause = new JButton("Pause");
		restart = new JButton("Restart");

		pause.setEnabled(false);

		play.addActionListener(controller);
		pause.addActionListener(controller);
		restart.addActionListener(controller);

		add(play);
		add(pause);
		add(restart);

		setPreferredSize(new Dimension(Constants.WORLD_SIZE, Constants.UNIT_SIZE));
	}

	public JButton getPlay() {
		return play;
	}

	public JButton getPause() {
		return pause;
	}

	public JButton getRestart() {
		return restart;
	}

}

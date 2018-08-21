import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Controller extends KeyAdapter implements ActionListener {

	private Gameplay model; // logic of the game
	private GameView view; // view of the game

	private Timer timer; // game loop timer

	private Direction newDir; // saves the new direction (from the user) for the next game update

	public Controller() {
		model = new Gameplay();
		view = new GameView(this, model);

		timer = new Timer(Constants.SNAKE_SPEED, this);

		newDir = Direction.RIGHT; // initial direction

		view.repaint();
	}

	public GameView getView() {
		return view;
	}

	public void restart() {
		newDir = Direction.RIGHT;
		model.initial();
		pause();
	}

	public void play() {
		timer.start();
		view.requestFocusInWindow();
		view.getBtnsBar().getPlay().setEnabled(false);
		view.getBtnsBar().getPause().setEnabled(true);
	}

	public void pause() {
		timer.stop();
		view.getBtnsBar().getPlay().setEnabled(true);
		view.getBtnsBar().getPause().setEnabled(false);
	}

	public void actionPerformed(ActionEvent e) {
		view.repaint(); // repaint first for better performance 
		
		if (e.getSource() == view.getBtnsBar().getPlay())
			play();
		else if (e.getSource() == view.getBtnsBar().getPause())
			pause();
		else if (e.getSource() == view.getBtnsBar().getRestart())
			restart();
		else if (!model.update(newDir)) // the game is on and the snake is alive
		{
			timer.stop();
			view.getBtnsBar().getPause().setEnabled(false);
			JOptionPane.showMessageDialog(null, "Game Over!\nLength: " + model.getSnake().getLength());
		}
		
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP)
			if (model.getSnake().getDirection() != Direction.DOWN)
				newDir = Direction.UP;

		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			if (model.getSnake().getDirection() != Direction.UP)
				newDir = Direction.DOWN;

		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			if (model.getSnake().getDirection() != Direction.LEFT)
				newDir = Direction.RIGHT;

		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			if (model.getSnake().getDirection() != Direction.RIGHT)
				newDir = Direction.LEFT;
	}
}

public class Constants {
	public static final int UNIT_SIZE = 28; // game board's unit
	public static final int NUM_OF_UNITS = 15; // in a row/column
	public static final int WORLD_SIZE = UNIT_SIZE * NUM_OF_UNITS;

	public static final int INITIAL_SNAKE_LENGTH = 5; // maximum value = NUM_OF_UNITS / 2
	public static final int INITIAL_SNAKE_POSITION = UNIT_SIZE * (NUM_OF_UNITS / 2);

	public static final int SNAKE_SPEED = 75; // in milliseconds per unit
}

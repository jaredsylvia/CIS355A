package snakeGame;

import java.util.Random;
import java.util.TimerTask;

public class Food extends TimerTask {
	//attributes
	private int posX;
	private int posY;
	private Snake snake;

	//constructor
	public Food() {
		posX = 25 * new Random().nextInt(20);
		posY = 25 * new Random().nextInt(20);
	}
	
	public Food(Snake s) {
		snake = s;
	}
	
	//behaviors
	@Override
	public void run() {
		if(snake.getFood() == null) {
			snake.setFood(new Food());
		}
	}
	
	//getters and setters
	public int getPosX() { return posX; }
	public int getPosY() { return posY; }
}


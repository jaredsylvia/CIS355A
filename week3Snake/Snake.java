package snakeGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


import javax.swing.*;

public class Snake extends JPanel {
	
	private Color c;
	private int startX;
	private int startY;
	private int speed;
	private ArrayList<Rectangle> snakeBody;
	private String direction;
	private Food food;
	private Main window;
	
	//constructor
	public Snake(Main mainWindow) {
		c = new Color(0,0,0);
		startX = 250;
		startY = 250;
		speed = 25;
		window = mainWindow;
		
		snakeBody = new ArrayList<>();
		snakeBody.add(new Rectangle(startX, startY));
		Rectangle lastSegment = snakeBody.get(0);
		snakeBody.add(new Rectangle(lastSegment.getPosX() - lastSegment.getWidth(), lastSegment.getPosY()));
		Rectangle lastSegment2 = snakeBody.get(1);
		snakeBody.add(new Rectangle(lastSegment2.getPosX() - lastSegment.getWidth(), lastSegment2.getPosY()));
		direction = "right";
		
	}
	
	//behaviors
	public void addPart() {
		Rectangle lastSegment = snakeBody.get(snakeBody.size() - 1);
		switch(this.direction) {
			case "right" -> snakeBody.add(new Rectangle(lastSegment.getPosX() - lastSegment.getWidth(), lastSegment.getPosY()));
			case "left" -> snakeBody.add(new Rectangle(lastSegment.getPosX() + lastSegment.getWidth(), lastSegment.getPosY()));
			case "up" -> snakeBody.add(new Rectangle(lastSegment.getPosX(), lastSegment.getPosY() + lastSegment.getHeight()));
			case "down" -> snakeBody.add(new Rectangle(lastSegment.getPosX(), lastSegment.getPosY() - lastSegment.getHeight()));
		}
	}
	
	public void checkCollision() {
		Rectangle r3 = snakeBody.get(0);
		for (int i = 1; i < snakeBody.size(); i++) {
			Rectangle r2 = snakeBody.get(i);
			if(r3.doesIntersect(r2)) {
				window.setVisible(false);
				JFrame parent = new JFrame("Game over!");
				JOptionPane.showMessageDialog(parent, String.format("Your Score: %s", snakeBody.size()),"Game Over", JOptionPane.INFORMATION_MESSAGE);
				window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
				System.exit(0);
			}
			if (food != null) {
				if (r3.doesIntersect(new Rectangle(food.getPosX(),food.getPosY()))) {
					food = null;
					addPart();
				}
			}
		}
	}
	
	public void moveSnake() {
		ArrayList<Rectangle> newList = new ArrayList<>();
		Rectangle first = snakeBody.get(0);
		Rectangle head = new Rectangle(first.getPosX(), first.getPosY());
		
		switch (direction) {
			case "right" -> head.setPosX(speed);
			case "left" -> head.setPosX(-speed);
			case "up" -> head.setPosY(-speed);
			case "down" -> head.setPosY(speed);
		}
		newList.add(head);
		
		for (int i = 1; i < snakeBody.size(); i++) {
			Rectangle previous = snakeBody.get(i-1);
			Rectangle newRect = new Rectangle(previous.getPosX(), previous.getPosY());
			newList.add(newRect);
		}
		
		snakeBody = newList;
		checkCollision();
	}
	
	public void drawSnake(Graphics g) {
		moveSnake();
		
		Graphics2D g2d = (Graphics2D) g;
		if (food != null) {
			g2d.setPaint(Color.red);
			g2d.drawRect(food.getPosX(), food.getPosY(), snakeBody.get(0).getWidth(), snakeBody.get(0).getHeight());
			g2d.fillRect(food.getPosX(), food.getPosY(), snakeBody.get(0).getWidth(), snakeBody.get(0).getHeight());
			
		}
		
		g2d.setPaint(Color.green);
		for (Rectangle rec: snakeBody) {
			g2d.drawRect(rec.getPosX(), rec.getPosY(), rec.getWidth(), rec.getHeight());
			g2d.fillRect(rec.getPosX(), rec.getPosY(), rec.getWidth(), rec.getHeight());
			}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(c);
		drawSnake(g);
	}
	
	
	//getters and setters
	public String getDirection() {return direction;}
	public Food getFood() {return food;}
	public void setDirection(String newDirection) {direction = newDirection;}
	public void setFood(Food f) {food = f;}
	
}

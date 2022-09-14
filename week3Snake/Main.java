package snakeGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;


public class Main extends JFrame implements KeyListener, ActionListener{
	Snake snake;
	
	public Main() {
		snake = new Snake(this); // the snake
		
		Timer timer = new Timer(150, this); // update timer
		timer.start();
		
		java.util.Timer drawFood = new java.util.Timer(); //a timer from a different library(?) used to draw food
		Food st = new Food(snake);
		drawFood.schedule(st,  0, 3000);
		
		// create window and draw some contents
		add(snake);
		setTitle("Snake Game");
		setSize(600, 600);
		addKeyListener(this);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		if((c == 39 || c == 68) && !snake.getDirection().equals("left")) {
			snake.setDirection("right");
		}
		else if ((c == 37 || c == 65) && !snake.getDirection().equals("right")) {
			snake.setDirection("left");
		}
		else if ((c == 38 || c == 87) && !snake.getDirection().equals("down")) {
			snake.setDirection("up");
		}
		else if ((c == 40 || c == 83) && !snake.getDirection().equals("up")) {
			snake.setDirection("down");
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(Main::new);
	}
	

}

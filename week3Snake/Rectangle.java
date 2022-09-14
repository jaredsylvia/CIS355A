package snakeGame;

public class Rectangle {
		//attributes
		private int posX;
		private int posY;
		private int width;
		private int height;
		
		public static final int rec_width = 25;
		public static final int rec_height = 25;
		
		//constructors
		public Rectangle() {
			posX = 0;
			posY = 0;
			width = 25;
			height = 25;
		}
		
		public Rectangle(int x, int y) {
			posX = x;
			posY = y;
			width = 25;
			height = 25;
		}
		public Rectangle(int x, int y, int sX, int sY) {
			posX = x;
			posY = y;
			width = sX;
			height = sY;
		}
		
		//behaviors
		public boolean doesIntersect(Rectangle r2) {
			return this.posX == r2.getPosX() && this.posY == r2.getPosY();
		}
				
		//getters and setters
		public int getPosX() { return posX;}
		public int getPosY() { return posY;}
		public int getWidth() { return width;}
		public int getHeight() { return height;}
		
		public void setPosX(int incrementBy) { posX += incrementBy; }
		public void setPosY(int incrementBy) { posY += incrementBy; }
		public void setSize(int w, int h) {
			width = w;
			height = h;}
		
}

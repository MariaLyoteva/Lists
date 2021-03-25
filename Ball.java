package lists;

import java.awt.Color;

class Ball {
	int x = (int) (Math.random() * BallControl.ballPanel.getWidth());
	int y = (int) (Math.random() * BallControl.ballPanel.getHeight()); // Current ball position
	int dx = (int) (Math.random() * 10); // Increment on ball's x-coordinate
	int dy = (int) (Math.random() * 10); // Increment on ball's y-coordinate
	int radius = 5; // Ball radius
	Color color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
}

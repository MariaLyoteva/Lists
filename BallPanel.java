package lists;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.Timer;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.JPanel;

class BallPanel extends JPanel {
	private int delay = 10;
	static ArrayList<Ball> list = new ArrayList<Ball>();
// Create a timer with the initial delay
	protected Timer timer = new Timer(delay, new TimerListener());

	private class TimerListener implements ActionListener {
		@Override /** Handle the action event */
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}

	public BallPanel() {
		timer.start();
	}

	public void add() {
		list.add(new Ball());
	}

	public void subtract() {
		if (list.size() > 0)
			list.remove(list.size() - 1); // Remove the last ball
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < list.size(); i++) {
			Ball ball = (Ball) list.get(i); // Get a ball
			g.setColor(ball.color); // Set ball color
			// Check boundaries
			if (ball.x < 0 || ball.x > getWidth())
				ball.dx = -ball.dx;
			if (ball.y < 0 || ball.y > getHeight())
				ball.dy = -ball.dy;
			// Adjust ball position
			ball.x += ball.dx;
			ball.y += ball.dy;
			g.fillOval(ball.x - ball.radius, ball.y - ball.radius, ball.radius * 2, ball.radius * 2);
		}
		for (int i = 0; i < list.size() - 1; i++) {
			Ball ball = (Ball) list.get(i);
			for (int j = i + 1; j < list.size(); j++) {
				Ball ball1 = (Ball) list.get(j);
				if (collision(ball, ball1)) {
					ball.radius += ball1.radius;
					list.remove(ball1);
				}
			}
		}
	}

	public boolean collision(Ball b1, Ball b2) {
		return collision(b1.x, b1.y, b1.radius, b2.x, b2.y, b2.radius);
	}

	public boolean collision(int x1, int y1, int r1, int x2, int y2, int r2) {
		if (Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)) <= r1 + r2) {
			return true;
		}
		return false;
	}

	public void suspend() {
		timer.stop();
	}

	public void resume() {
		timer.start();
	}

	public void setDelay(int delay) {
		this.delay = delay;
		timer.setDelay(delay);
	}
}

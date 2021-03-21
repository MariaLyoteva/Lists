package lists;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;

public class BallControl extends JPanel {
	static BallPanel ballPanel = new BallPanel();
	private JButton jbtSuspend = new JButton("Suspend");
	private JButton jbtResume = new JButton("Resume");
	private JButton jbtAdd = new JButton("+1");
	private JButton jbtSubtract = new JButton("-1");
	private JScrollBar jsbDelay = new JScrollBar();

	public BallControl() {
		// Group buttons in a panel
		JPanel panel = new JPanel();
		panel.add(jbtSuspend);
		panel.add(jbtResume);
		panel.add(jbtAdd);
		panel.add(jbtSubtract);
		// Add ball and buttons to the panel
		ballPanel.setBackground(Color.BLACK);
		ballPanel.setBorder(new javax.swing.border.LineBorder(Color.red));
		jsbDelay.setOrientation(JScrollBar.HORIZONTAL);
		ballPanel.setDelay(jsbDelay.getMaximum());
		setLayout(new BorderLayout());
		add(jsbDelay, BorderLayout.NORTH);
		add(ballPanel, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		// Register listeners
		jbtSuspend.addActionListener(new Listener());
		jbtResume.addActionListener(new Listener());
		jbtAdd.addActionListener(new Listener());
		jbtSubtract.addActionListener(new Listener());
		jsbDelay.addAdjustmentListener(new AdjustmentListener() {
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				ballPanel.setDelay(jsbDelay.getMaximum() - e.getValue());
			}
		});
		ballPanel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				for (int i = 0; i < BallPanel.list.size(); i++) {
					Ball ball = (Ball) BallPanel.list.get(i);
					if (ballPanel.collision(ball.x, ball.y, ball.radius, e.getX(), e.getY(), 0)) {
						BallPanel.list.remove(ball);
					}
				}
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}

		});
	}

	class Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == jbtSuspend)
				ballPanel.suspend();
			else if (e.getSource() == jbtResume)
				ballPanel.resume();
			else if (e.getSource() == jbtAdd)
				ballPanel.add();
			else if (e.getSource() == jbtSubtract)
				ballPanel.subtract();
		}
	}
}

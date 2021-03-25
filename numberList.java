package lists;

import java.awt.EventQueue;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class numberList extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	List<Integer> list = new LinkedList<Integer>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					numberList frame = new numberList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public numberList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 346, 278);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Enter a number:");
		lblNewLabel.setBounds(30, 22, 124, 14);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(182, 19, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(30, 57, 248, 108);
		contentPane.add(textArea);

		JButton btnNewButton = new JButton("Sort");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Collections.sort(list);
				textArea.setText(list.toString());
			}
		});
		btnNewButton.setBounds(10, 191, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Shuffle");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Collections.shuffle(list);
				textArea.setText(list.toString());
			}
		});
		btnNewButton_1.setBounds(118, 191, 89, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Reverse");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Collections.reverse(list);
				textArea.setText(list.toString());
			}
		});
		btnNewButton_2.setBounds(231, 191, 89, 23);
		contentPane.add(btnNewButton_2);

		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int n = Integer.parseInt(textField.getText());
				if (!list.contains(n)) {
					list.add(n);
				}
				textField.setText("");
				textArea.setText(list.toString());
			}
		});
	}
}

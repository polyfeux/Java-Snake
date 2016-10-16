package de.polyfeux.snake;

import javax.swing.JFrame;

import java.awt.EventQueue;

/**
 * @author Felix Vogl
 *
 */
@SuppressWarnings("serial")
public class Snake extends JFrame {
	public Snake() {
		add(new Board());
		setResizable(false);

		pack();
		setTitle("Mein Snake!");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame ex = new Snake();
				ex.setVisible(true);
			}

		});
	}
}

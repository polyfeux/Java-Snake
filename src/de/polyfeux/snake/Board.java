package de.polyfeux.snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author Felix Vogl
 *
 */
public class Board extends JPanel implements ActionListener {
	private final int B_WIDTH = 300;
	private final int B_HEIGHT = 300;
	private final int DOT_SIZE = 10;
	private final int ALL_DOTS = 900;
	private final int RAND_POS = 29;
	private final int DELAY = 140;

	private final int[] x = new int[ALL_DOTS];
	private final int[] y = new int[ALL_DOTS];

	private int dots;
	private int apple_x;
	private int apple_y;

	private boolean leftDirection = false;
	private boolean rightDirection = true;
	private boolean upDirection = false;
	private boolean downDirection = false;
	private boolean inGame = true;

	private Timer timer;
	private Image ball;
	private Image apple;
	private Image head;

	public Board() {
		addKeyListener(new TAdapter());
		setBackground(Color.black);
		setFocusable(true);
		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
		loadImages();
		initGame();
	}
	
	private void loadImages() {
		ImageIcon iid = new ImageIcon(getClass().getResource("/res/dot.png"));
		ball = iid.getImage();
		
		ImageIcon iia = new ImageIcon(getClass().getResource("/res/apple.png"));
		apple = iia.getImage();

		ImageIcon iih = new ImageIcon(getClass().getResource("/res/head.png"));
		head = iih.getImage();
	}
	
	private void initGame() {
		dots = 3;
		
		for (int i = 0; i < dots; i++) {
			x[i] = 50 - i * 10;
			y[i] = 50;
		}
		
		locateApple();
		
		//we use a timer on a call action performed method at fixed delay
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}
	
	private void doDrawing(Graphics g) {
		if(inGame) {
			g.drawImage(apple, apple_x, apple_y, this);
			
			for (int i = 0; i < dots; i++) {
				if (i == 0) {
					g.drawImage(head, x[i], y[i], this);
				} else {
					g.drawImage(ball, x[i], y[i], this);
				}
			}
			
			Toolkit.getDefaultToolkit().sync();
			
		} else {
			gameOver(g);
		}
	}
	
	private void gameOver(Graphics g) {
		String msg = "Game Over";
		Font small = new Font("Helvetica", Font.BOLD, 14);
		FontMetrics metr = getFontMetrics(small);
		
		g.setColor(Color.white);
		g.setFont(small);
		g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, (B_HEIGHT / 2));
	}
	
	private void checkApp() {
		if (x[0] == apple_x() && y[0] == apple_y()) {
			dots++;
			locateApple();
		}
	}
	
	private void move() {
		for (int i = 0; i < dots; i++) {
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		
		if(leftDirection) {
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}

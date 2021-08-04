package game2048;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ScoreBoard extends JPanel {
	Matrix score;
	public boolean showGameOver = false;
	public boolean showGameWon = false;

	ScoreBoard(Matrix score) {
		this.score = score;
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRoundRect(280, 100, 120, 120, 15, 15);
		g.setFont(new Font("Arial", Font.PLAIN, 48));
		g.setColor(Color.black);
		g.drawString("2048", 284, 180);
		g.setColor(Color.DARK_GRAY);

		g.fillRoundRect(280, 25, 120, 40, 15, 15);
		g.setFont(new Font("Arial", Font.BOLD, 14));
		g.setColor(Color.white);
		g.drawString("Score:", 284, 54);

		if (showGameWon) {
			g.setColor(Color.black);
			g.setFont(new Font("Arial", Font.BOLD, 64));
			g.drawString("YOU WON!", 30, 240);
		}

		if (showGameOver) {
			g.setColor(Color.black);
			g.setFont(new Font("Arial", Font.BOLD, 64));
			g.drawString("GAMEOVER", 30, 240);
		}
	}

	public void Update() {
		repaint();
	}
}

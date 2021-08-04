package game2048;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.management.timer.Timer;
import javax.swing.JPanel;

public class Tile extends JPanel implements ActionListener {

	private int x = 0;
	private int y = 0;
	private int tileValue = 0;
	private boolean tile = false;
	private int fontOffsetX = 14;
	private boolean tileGlow = false;
	private int counter = 0;
	private final Timer timer = new Timer();

	Tile(int x, int y) throws InterruptedException {

		this.x = x;
		this.y = y;

	}

	public void initTile() throws InterruptedException {

		int rand = (int) (Math.random() * 2);
		if (rand == 0) {
			drawTile2();
		} else {
			drawTile4();
		}
		// timer.setRepeats(true);
		timer.start();
	}

	private void drawTile2() throws InterruptedException {

		tile = true;
		tileValue = 2;
		repaint();
	}

	private void drawTile4() throws InterruptedException {

		tile = true;
		tileValue = 4;
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {

		if (tile && !tileGlow && tileValue != 0) {

			g.setColor(Color.BLACK);
			g.drawRect(x, y, 40, 40);

			if (tileValue != 0) {
				g.setColor(getTileColor(tileValue));
			} else {
				g.setColor(new Color(238, 238, 238));
			}
			g.fillRect(x + 2, y + 2, 37, 37);
			g.setColor(Color.WHITE);
			g.setFont(setFontOnValue(tileValue));
			if (tileValue != 0) {
				g.drawString(String.valueOf(tileValue), x + fontOffsetX, y + 27);
			}

		}

		if (tileGlow) {
			/*
			 * g.setColor(Color.BLACK); g.drawRect(_x, _y, 40, 40);
			 */
			g.setColor(Color.getHSBColor(40, 240, 128));

			g.fillRect(x + 2, y + 2, 37, 37);
			if (tile) {
				g.setColor(Color.WHITE);
				g.setFont(setFontOnValue(tileValue));
				if (tileValue != 0) {
					g.drawString(String.valueOf(tileValue), x + 14, y + 27);
				}
			}
		}

	}

	void updateTile() {
		tileGlow = false;
		tile = true;
		this.repaint();
	}

	void setGlow(boolean value) {
		tileGlow = value;
		tile = true;
		// timer.setRepeats(true);
		timer.start();

	}

	int getTileValue() {
		return tileValue;
	}

	void setTileValue(int val) {
		tileValue = val;
	}

	int getCurrentx() {
		return x;
	}

	Color getTileColor(int value) {

		if (value == 8) {
			return new Color(255, 127, 39);
		}
		if (value == 16) {
			return new Color(128, 255, 0);
		}
		if (value == 32) {
			return new Color(255, 0, 0);
		}
		if (value == 64) {
			return new Color(0, 0, 255);
		}
		if (value == 128) {
			return new Color(255, 128, 128);
		}
		if (value == 256) {
			return new Color(128, 0, 255);
		}
		if (value == 512) {
			return new Color(128, 128, 0);
		}
		if (value == 1024) {
			return new Color(0, 255, 255);
		}
		if (value == 2048) {
			return new Color(255, 128, 0);
		}
		return Color.GRAY;
	}

	Font setFontOnValue(int value) {
		if (value > 8 && value < 128) {
			fontOffsetX = 12;
			return new Font("Arial", Font.PLAIN, 18);

		}
		if (value >= 128 && value < 1024) {
			fontOffsetX = 8;
			return new Font("Arial", Font.BOLD, 14);
		}
		if (value >= 1024) {
			fontOffsetX = 2;
			return new Font("Arial", Font.BOLD, 14);
		}
		fontOffsetX = 14;
		return new Font("Arial", Font.PLAIN, 20);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == timer && tileGlow == false) {
			tileGlow = true;
			this.repaint();
		} else if (event.getSource() == timer && tileGlow == true) {
			tileGlow = false;
			this.repaint();
		}
		if (event.getSource() == timer) {
			counter++;
		}

		if (counter > 5) {
			timer.stop();
			counter = 0;
			tileGlow = false;
		}

	}
}

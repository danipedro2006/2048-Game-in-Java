package game2048;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TwentyFortyEight {

	public static void main(String[] args) {
		JFrame window = new JFrame("2048");
		JPanel jPanel = new JPanel();
		jPanel.setSize(new Dimension(161, 161));
		jPanel.setLayout(null);
		 
		List<Tile> Tiles = new ArrayList<>();
		int marker = 0;
		for (int j = 0; j <= 120; j = j + 40) {
			for (int i = 0; i <= 120; i = i + 40) {

				try {
					Tiles.add(new Tile(i, j));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Tiles.get(marker).setSize(new Dimension(161, 161));
				Tiles.get(marker).setOpaque(false);
				marker++;
			}
		}
		Matrix mat = new Matrix(Tiles);
		mat.init_matrix();
		int number = (int) (Math.random() * 16);
		int get_row = number / 4;
		int get_column = number - (get_row * 4);

		try {
			Tiles.get(number).initTile();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		mat.setMatrixValue(get_row, get_column, Tiles.get(number).getTileValue());

		int number2 = (int) ((Math.random() * 16));
		while (number2 == number) {
			number2 = (int) ((Math.random() * 16));
		}
		get_row = number2 / 4;
		get_column = number2 - (get_row * 4);

		try {
			Tiles.get(number2).initTile();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mat.setMatrixValue(get_row, get_column, Tiles.get(number2).getTileValue());

		Grid grid = new Grid();
		grid.setSize(new Dimension(161, 161));
		ScoreBoard score = new ScoreBoard(mat);
		score.setSize(new Dimension(480, 380));
		jPanel.setLayout(null);
		for (int i = 0; i < Tiles.size(); i++) {
			jPanel.add(Tiles.get(i));
		}
		score.setLayout(null);
		score.setOpaque(false);
		jPanel.add(score);
		jPanel.add(grid);
		window.setContentPane(jPanel);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(new Dimension(480, 380));
		window.setLocationRelativeTo(null);

		window.setVisible(true);
		Keyboard keyb = new Keyboard(mat, score);
		window.addKeyListener(keyb);
		window.setTitle("2048 Game.");

	}

}

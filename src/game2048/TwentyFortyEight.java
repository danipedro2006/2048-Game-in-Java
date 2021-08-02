package game2048;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TwentyFortyEight {

	public static void main(String[] args) {
		JFrame window=new JFrame("2048");
		JPanel jPanel=new JPanel();
		jPanel.setSize(new Dimension(161, 161));
		jPanel.setLayout(null);
		Grid grid=new Grid();
		grid.setSize(new Dimension(161,161));jPanel.add(grid);
		window.setContentPane(jPanel);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(new Dimension(480, 380));
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}

}

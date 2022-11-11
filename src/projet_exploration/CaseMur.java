package projet_exploration;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


class CaseMur extends Case {

	public CaseMur(int _x, int _y) {
		super(_x, _y);
		setBackground(Color.GRAY);
	}

	public String toString() { return String.format("M"); }

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		this.add(panel);
		this.setVisible(true);
	}
}
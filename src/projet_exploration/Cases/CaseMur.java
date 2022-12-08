package projet_exploration.Cases;

import java.awt.*;
// import javax.swing.JPanel;


class CaseMur extends Case {

	public CaseMur(int _x, int _y) {
		super(_x, _y);
		setBackground(Color.GRAY);
	}

	public String toString() { return String.format("M"); }

	public void dessine(Graphics2D g) {
        g.setColor(Color.RED);
		super.dessine(g);
	}
}
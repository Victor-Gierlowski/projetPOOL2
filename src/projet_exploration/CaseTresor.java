package projet_exploration;

import java.awt.Color;
import java.awt.Graphics;


class CaseTresor extends Case {
	int valeur=1;

	public CaseTresor(int _x, int _y) {
		super(_x, _y);
	}

	public String toString() { return String.format("T"); }

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.YELLOW);
		g.fillRect(0,0,getWidth(),getHeight()); 

	}
}
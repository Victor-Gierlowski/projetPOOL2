package projet_exploration;

import java.awt.Color;
import java.awt.Graphics;


class CasePorte extends Case {
	public CasePorte(int _x, int _y) {
		super(_x, _y);
	}

	public String toString() { return String.format("P"); }

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.ORANGE);
		g.fillRect(0,0,getWidth(),getHeight()); 

	}
}
package projet_exploration.Cases;

import java.awt.*;

class CaseVide extends Case {

	public CaseVide(int _x, int _y) {
		super(_x, _y);
		setBackground(Color.WHITE);
	}

	public String toString() { return String.format(" "); }

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.WHITE);
		g.setColor(Color.WHITE);
		g.fillRect(0,0,getWidth(),getHeight()); 
	}
}
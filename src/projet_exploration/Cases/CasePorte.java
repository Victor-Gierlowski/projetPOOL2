package projet_exploration.Cases;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


class CasePorte extends Case {
	public CasePorte(int _x, int _y) {
		super(_x, _y);
	}

	public String toString() { return String.format("P"); }

	// @Override
	// public void paintComponent(Graphics g) {
	// 	super.paintComponent(g);
    //     Graphics2D g2 = (Graphics2D) g;
	// 	g2.setColor(Color.ORANGE);
	// 	g2.fillRect(0,0,getWidth(),getHeight()); 
	// }

	public void dessine(Graphics2D g) {
        // Graphics2D g2 = (Graphics2D) g;
        g.setColor(Color.ORANGE);
		super.dessine(g);

		// g2.fillRect(this.x*this.size, this.y*this.size, this.size, this.size);
	}
}
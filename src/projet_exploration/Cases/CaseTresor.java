package projet_exploration.Cases;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;


class CaseTresor extends Case {
	int valeur=1;

	public CaseTresor(int _x, int _y) {
		super(_x, _y);
		this.img = new ImageIcon("img/tresor.png").getImage();
	}

	public String toString() { return String.format("T"); }

	// @Override
	// public void paintComponent(Graphics g) {
	// 	super.paintComponent(g);
    //     Graphics2D g2 = (Graphics2D) g;
	// 	g2.setColor(Color.YELLOW);
	// 	g2.fillRect(0,0,getWidth(),getHeight()); 
	// }
	public void dessine(Graphics2D g) {
        // Graphics2D g2 = (Graphics2D) g;
//        g.setColor(Color.YELLOW);
//		super.dessine(g);
		g.drawImage(this.img, this.y*size, this.x*size,size,size,null);
	
		// g2.fillRect(this.x*this.size, this.y*this.size, this.size, this.size);
	}
}
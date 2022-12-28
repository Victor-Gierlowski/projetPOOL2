package projet_exploration.Cases;

import java.awt.*;

import javax.swing.ImageIcon;

import projet_exploration.App.Evenement;
import java.util.List;
public class CaseVide extends Case {

	public CaseVide(int _x, int _y, List<Integer> args) {
		super(_x, _y, args);
		this.img = new ImageIcon("img/vide.png").getImage();
		this.movable = true;
	}

	public String toString() { return String.format(" "); }

	// @Override
	// public void paintComponent(Graphics g) {
	// 	super.paintComponent(g);
    //     Graphics2D g2 = (Graphics2D) g;
	// 	g2.setColor(Color.WHITE);
	// 	g2.fillRect(0,0,getWidth(),getHeight()); 
	// }
	public void dessine(Graphics2D g) {
        // Graphics2D g2 = (Graphics2D) g;
        //g.setColor(Color.WHITE);
		//super.dessine(g);
		// g2.fillRect(this.x*this.size, this.y*this.size, this.size, this.size);
		g.drawImage(this.img, this.y*size, this.x*size,size,size,null);
	}

	@Override
	public Evenement playerOnCase() {
		// TODO Auto-generated method stub
		return null;
	}
}
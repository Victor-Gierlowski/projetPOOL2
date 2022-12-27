package projet_exploration.Cases;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import Evenements.Ramassage;
import projet_exploration.App.Evenement;


public class CaseTresor extends Case {
	int valeur=1;

	public CaseTresor(int _x, int _y) {
		super(_x, _y);
		this.img = new ImageIcon("img/tresor.png").getImage();
		this.movable = true;
	}

	public String toString() { return String.format("T"); }

	
	public void dessine(Graphics2D g) {
		g.drawImage(this.img, this.y*size, this.x*size,size,size,null);
	}

	@Override
	public Evenement playerOnCase() {
		// TODO Auto-generated method stub
		return new Ramassage(this);
	}
}
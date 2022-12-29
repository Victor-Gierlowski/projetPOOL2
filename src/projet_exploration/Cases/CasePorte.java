package projet_exploration.Cases;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import Evenements.Ramassage;
import Evenements.traverser;
import projet_exploration.App.Evenement;
import java.util.List;

public class CasePorte extends Case {
	public int niveauCible;
	public int porteCible;
	public CasePorte(int _x, int _y, List<Integer> args) {
		super(_x, _y, args);
		if(args == null || args.size() != 3) {
			niveauCible = -1;
			porteCible = -1;
			this.img = new ImageIcon("img/porteclose.png").getImage();
		}
		else {
			niveauCible = args.get(1);
			porteCible = args.get(2);
			this.img = new ImageIcon("img/porte.png").getImage();
		}
		this.movable = true;
	}

	public String toString() { return String.format("P"); }

	public void dessine(Graphics2D g) {
		g.drawImage(this.img, this.y*size, this.x*size,size,size,null);
	}

	@Override
	public Evenement playerOnCase() {
		// TODO Auto-generated method stub
		if(this.niveauCible >= 0)
			return new traverser(this);
		return null;
	}
}
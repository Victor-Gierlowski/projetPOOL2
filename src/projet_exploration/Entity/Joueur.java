package projet_exploration.Entity;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Joueur extends Personnage {

	public int points;
	public int totaltue = 0;
	
	
	public Joueur(int pv, int pa) {
		super(pv, pa);
	}


	@Override
	public String getIcon() {
		// TODO Auto-generated method stub
		return "img/personnage1.png";
	}


	@Override
	public Image getMort() {
		// TODO Auto-generated method stub
		return new ImageIcon("img/personnage1.png").getImage();
	}
	

}

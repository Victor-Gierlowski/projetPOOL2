package projet_exploration.App;

import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

import projet_exploration.Entity.Joueur;
import projet_exploration.Entity.Monstre;

public class Combat {
	public Joueur joueur;
	
	
	public Monstre ennemie;
	
	public Image img = new ImageIcon("img/dice.png").getImage();
	public Integer resultatDe = 0;
	public String str;
	
	
	public Combat(Joueur j, Monstre m) {
		joueur = j;
		ennemie = m;
	}
	
	public String getResultatDe() {
		if(resultatDe != 0 && resultatDe>0 && resultatDe <=6) {
			return String.format("img/de%d.png", resultatDe);
		}
		return null;
	}
	
	public Image deImage() {
		String s = getResultatDe();
		//System.out.println(s);
		if(s!= null) return new ImageIcon(s).getImage();
		return this.img;
	}
	public String lancerDe() {
		Random random = new Random();
	    int randomNumber = random.nextInt(6) + 1;
	    resultatDe = randomNumber;
	    switch (randomNumber) {
	      case 1:
	        //System.out.println("1: OUCH!! L'ennemi vous infligent un coup critique!!");
	        this.joueur.pv-=3;
	        str="1: OUCH!! L'ennemi vous infligent un coup critique!!";
	        break;
	      case 2:
	        str="2: L'ennemi vous frappe au tibia!";
	        this.joueur.pv-=2;
	        break;
	      case 3:
	        str="3: OUF! Tu esquive inextremis!";
	        break;
	      case 4:
	        str="4: Touché! l'ennemi est atteint.";
	        ennemie.pv-=1;
	        break;
	      case 5:
	        str="5: Tu frappe l'ennemi de toute tes forces.";
	        ennemie.pv-=3;
	        break;
	      case 6:
	        str="6: Tu boit une potion";
	        this.joueur.pv+=3;
	        break;
	      default:
	        str="Erreur: nombre aléatoire inattendu";
	        break;
	    }
	    
	    return str;
	}
}

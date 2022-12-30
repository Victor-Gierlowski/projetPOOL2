package projet_exploration.App;

import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

import projet_exploration.Entity.Joueur;
import projet_exploration.Entity.Monstre;
import projet_exploration.Entity.Personnage;

public class Combat {
	
	public UI affichage;
	public Joueur joueur;
	public Monstre ennemie;
	
	public Image img;// = new ImageIcon("img/dice.png").getImage();
	public Image imgmort;// = new ImageIcon("img/slime_mort.gif").getImage();
	public Integer resultatDe = 0;
	public String str="";
	
	
	public Combat(Joueur j, Monstre m,UI a) {
		joueur = j;
		ennemie = m;
		affichage= a;
		//img = new ImageIcon(ennemie.getIcon()).getImage();
		imgmort = ennemie.getMort();
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
	public String deString() {
		return this.str;
	}
	
	public int testMort(Personnage P) {
		if (P.pv<=0) {
			return 1;
		}
		else return 0;
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
	        if (testMort(joueur)==1) {
	        	str="GAME OVER LOOSER!!";
	        	//AFFICHE GAME OVER
	        }
	        break;
	      case 2:
	        str="2: L'ennemi vous frappe au tibia!";
	        this.joueur.pv-=2;
	        if (testMort(joueur)==1) {
	        	str="GAME OVER LOOSER!!";
	        	
	        	//AFFICHE GAME OVER
	        }
	        break;
	      case 3:
	        str="3: OUF! Tu esquive inextremis!";
	        break;
	      case 4:
	        str="4: Touché! l'ennemi est atteint.";
	        ennemie.pv-=1;
	        if (testMort(ennemie)==1) {
	        	affichage.ennemieCombat.img=imgmort;
	        	affichage.modeCombat=false;
	        	affichage.finCombatTime = System.currentTimeMillis();
	        }
	        break;
	      case 5:
	        str="5: Tu frappe l'ennemi de toute tes forces.";
	        ennemie.pv-=3;
	        if (testMort(ennemie)==1) {
	        	affichage.ennemieCombat.img=imgmort;
	        	affichage.modeCombat=false;
	        }
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

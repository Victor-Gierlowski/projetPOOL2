package projet_exploration.Entity;

import java.awt.Image;
import javax.swing.ImageIcon;

import Evenements.CombatEvenement;
import Evenements.MouvementMonstre;
import projet_exploration.App.Evenement;
import projet_exploration.App.Game;
import projet_exploration.App.UI;
import projet_exploration.Cases.CasePerso;

public class Monstre extends Personnage {

	public int type;
	
	public Monstre(int _t) {
		super(0,0);
		type = _t;
		switch(type) {
		case 1 : 
			this.pa = 1;
			this.pv = 5;
			break;
		default:
			this.pa = 1;
			this.pv = 5;
		}
	}
	
	public String getIcon() {
		switch(type) {
			case 1:
				return "img/slime.gif";
			case 2:
				return "img/fantome.gif";
			default:
				return "img/slime.gif";
		}
	}
	
	public Evenement action(Game jeu,CasePerso caller) {
		if(jeu.affichage.joueur.getPos().distance(caller.getPos()) < 2)
			return new CombatEvenement(caller);
		else
			return new MouvementMonstre(caller);
	}

	@Override
	public Image getMort() {
		// TODO Auto-generated method stub
		String s ;
		switch(type) {
		case 1 :
			s = "img/slime_mort.gif";
			break;
		case 2:
			s = "img/fantome_mort.gif";
			break;
		default:
			s = "img/slime_mort.gif";
			break;
		};
		return new ImageIcon(s).getImage();
		
	}
	

}

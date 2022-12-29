package projet_exploration.Entity;

import Evenements.Combat;
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
			this.pv = 3;
			break;
		default:
			this.pa = 1;
			this.pv = 3;
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
			return new Combat(caller);
		else
			return new MouvementMonstre(caller);
	}
	

}

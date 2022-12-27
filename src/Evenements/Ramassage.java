package Evenements;

import projet_exploration.App.Evenement;
import projet_exploration.App.Fenetre;
import projet_exploration.App.Game;
import projet_exploration.Cases.*;

public class Ramassage extends Evenement{

	public Ramassage(Case c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action(Fenetre F) {
		// TODO Auto-generated method stub
		F.joueur.points++;
		F.affichage.map[this.caller.x][this.caller.y] = new CaseVide(this.caller.x,this.caller.y);
		System.out.println(String.format("points : %d", F.joueur.points));
	}
	
}

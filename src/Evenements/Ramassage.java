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
	public void action(Game master) {
		// TODO Auto-generated method stub
		master.frame.joueur.points++;
		master.frame.affichage.G.map[this.caller.x][this.caller.y] = new CaseVide(this.caller.x,this.caller.y,null);
		System.out.println(String.format("points : %d", master.frame.joueur.points));
	}
	
}

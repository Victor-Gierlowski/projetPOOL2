package Evenements;

import java.awt.Point;

import projet_exploration.App.Evenement;
import projet_exploration.App.Game;
import projet_exploration.Cases.Case;

public class MouvementMonstre extends Evenement {

	public MouvementMonstre(Case c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action(Game master) {
		// TODO Auto-generated method stub
		int dx = master.affichage.joueur.x-caller.x;
		int dy = master.affichage.joueur.y-caller.y;
		if(Math.abs(dx) > 1) dx = dx/Math.abs(dx);
		if(Math.abs(dy) > 1) dy = dy/Math.abs(dy);
		Point pos = new Point(dx+this.caller.x,dy+this.caller.y);
		if(master.affichage.G.isMovable(pos)) {
			master.affichage.G.map[caller.x][caller.y].movable = true;
			caller.setPos(pos);
			master.affichage.G.map[caller.x][caller.y].movable = false;
		}
	}

}

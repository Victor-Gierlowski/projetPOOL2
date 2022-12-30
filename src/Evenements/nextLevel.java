package Evenements;

import projet_exploration.App.Evenement;
import projet_exploration.App.Game;
import projet_exploration.Cases.Case;

public class nextLevel extends Evenement {

	public nextLevel(Case c) {
		super(c);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void action(Game master) {
		// TODO Auto-generated method stub
		master.load("levels/level1.json");

	}

}

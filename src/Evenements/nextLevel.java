package Evenements;

import javax.swing.plaf.synth.SynthOptionPaneUI;

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
		master.frame.g="BRAVO VOUS AVEZ GAGNER";
		System.out.println();
		System.out.println();
		System.out.println();
		// TODO Auto-generated method stub
		

	}

}

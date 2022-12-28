package projet_exploration.App;

import projet_exploration.Cases.Case;

public abstract class Evenement {
	protected Case caller;
	public Evenement(Case c) {
		this.caller = c;
	}
	
	public abstract void action(Game master);
}

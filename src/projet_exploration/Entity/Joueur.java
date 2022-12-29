package projet_exploration.Entity;

public class Joueur extends Personnage {

	public int points;
	
	
	public Joueur(int pv, int pa) {
		super(pv, pa);
	}


	@Override
	public String getIcon() {
		// TODO Auto-generated method stub
		return "img/personnage1.png";
	}
	

}

package projet_exploration.Entity;

public class Monstre extends Personnage {

	public int type;
	
	public Monstre(int pv, int pa) {
		super(pv, pa);
		this.type = 2;
	}
	public Monstre (int pv, int pa, int type) {
		super(pv,pa);
		this.type = type;
	}
	

}

package projet_exploration.Entity;
import java.awt.Image;

public abstract class Personnage {
	public int pv;
	public int pa;
	public int pvmax;
	
	public Personnage(int pv,int pa) {
		this.pv=pv;
		this.pa=pa;
		
	}
	
	public String toString() {
		return "O";
	}
	
	public abstract Image getMort();
	
	public abstract String getIcon();
	

}

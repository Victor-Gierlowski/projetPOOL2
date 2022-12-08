package projet_exploration.Entity;

public class Personnage {
	public int pv;
	public int pa;
	public int degats;
	
	public Personnage(int pv,int pa) {
		this.pv=pv;
		this.pa=pa;
		
	}
	
	public String toString() {
		return "O";
	}
	
	// Le perso A attaque le perso B
	// retourne 1 si la cible meurt avec l'attaque.
	public static int attaque(Personnage A, Personnage B) {
		if(A instanceof Joueur && B instanceof Monstre) {
			B.pv -=(int) (Math.sqrt(((Monstre) B).type)*A.degats);
		}
		else
			B.pv -= A.degats;
		if(B.pv <= 0)
			return 1;
		return 0;
	}
}

package projet_exploration.App.wfc;

import java.util.ArrayList;
import java.util.List;


/**
 * Classe représentant un pattern de salle pour un algorithme de type Wave Function Collapse (WFC).
 *
 * Cette classe stock une map 2D d'entier pour représenter les zones vide / murs et portes du patterne
 *
 * La classe comporte :
 * Un constructeur qui permet le clonage profond. {@link projet_exploration.App.wfc.wfcPattern#numPortewfcPattern(wfcPattern)};
 * Une fonction qui transforme des coordonées d'une porte en son numéro d'apparition {@link projet_exploration.App.wfc.wfcPattern#numPortePos(int, int)};
 * Une fonction qui transforme l'objet en chaine de caractère {@link projet_exploration.App.wfc.wfcPattern#toString()}
 * @author Victor GIERLOWSKI
 * @version 1.0
 */
public class wfcPattern {
	public List<List<Integer>> map;
	public int id;
	public List<Integer> bottom;
	public List<Integer> right;
	public List<Integer> top;
	public List<Integer> left;
	public int nbrPorte;
	public transient boolean used = false;
	
	
	/**
	 * Constructeur permettant le deep clonage d'un élément.
	 *
	 * Chaque attribut de l'objet est recréer afin de n'avoir
	 * aucune référence vers l'objet initial.
	 * 
	 * @param p l'objet à cloner.
	 */
	public wfcPattern(wfcPattern p) {
		this.map = new ArrayList<List<Integer>>();
		for(int i =0;i< p.map.size();i++) {
			this.map.add(new ArrayList<Integer>());
			for(int j = 0;j<p.map.get(i).size();j++) {
				this.map.get(i).add( p.map.get(i).get(j).intValue());
			}
		}
		id = new Integer(p.id);
		bottom = new ArrayList<Integer>(p.bottom);
		top = new ArrayList<Integer>(p.top);
		left = new ArrayList<Integer>(p.left);
		right= new ArrayList<Integer>(p.right);
		
		
	}
	
	/**
	 * Méthode permettant de renvoyer le numéro d'une porte sur la carte.
	 *
	 * Cette méthode parcourt la carte et compte le nombre 
	 * de portes rencontrées jusqu'à ce qu'elle trouve la porte
	 * dont les coordonnées sont données en 
	 * paramètres. Elle renvoie alors le numéro de celle ci.
	 *
	 * @param x La coordonnée x de la porte
	 * @param y La coordonnée y de la porte
	 * @return Le numéro de la porte.
	 */
	public int numPortePos(int x,int y) {
		int compteur = 0;
		for(int i =0;i<map.size();i++) {
			for(int j=0;j<map.get(i).size();j++) {
				if(i == y && j == x) return compteur;
				if(map.get(i).get(j) == 5) compteur++;
			}
		}
		return compteur;
	}
	
	
	
	public String toString() {
		String c = " ";
		switch(this.id) {
		case 0 : 
			c = "┼";
			break;
		case 1:
			c = "┘";
			break;
		case 2:
			c = "┐";
			break;
		case 3:
			c ="┌";
			break;
		case 4:
			c = "└";
			break;
		case 5:
			c = "─";
			break;
		default:
			c = "A";
		}
		return c;
	}
}

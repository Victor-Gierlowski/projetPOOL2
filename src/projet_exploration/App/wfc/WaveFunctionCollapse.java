package projet_exploration.App.wfc;
import java.util.ArrayList;
import java.util.List;


/**
 * Classe représentant un algorithme de type Wave Function Collapse (WFC).
 *
 * Le but de l'algorithme est de créer une carte 2D, en se basant sur des patternes.
 * Chaque patterne peut être connecté par un certains nombre de ses compères ou lui même par 
 * en haut, à droite, à gauche ou en bas.
 * L'algorithme n'est pas fini, il faudrait ajouter la possibilité de revenir en arrière lorsqu'un mauvais choix est fait,
 * et choisir d'avancer en selectionnant la case avec le moins de possibilité possible. (pour faire le moins de choix aléatoire possible dans la lever de doute)
 * 
 * Pour contourner le fait qu'il ne soit pas finit il génère une carte qui est ensuite découper pour ne garder que le chemin
 * contigue le plus long. {@link projet_exploration.App.wfc.Generator#chercherLePlusGrandChemin(List<List<wfcPattern>>)};
 * 
 * 
 * 
 * 
 * La classe comporte :
 * Une fonction générer qui prends en arguments une largeur, une hauteur et une liste de patternes.
 * Une fonction qui permet de vérifier que les bords de deux patternes colle bien ensemble.
 * Une fonction qui permet de vérifier que le bord d'un patternes possède une connexion ou pas.
 * @author Victor GIERLOWSKI
 * @version 1.0
 */
public class WaveFunctionCollapse {
	public List<List<wfcPattern>> generer(int height,int width, List<wfcPattern> tiles) {
		List<List<wfcPattern>> grid = new ArrayList<List<wfcPattern>>();
		for(int i =0;i<height;i++) {
			grid.add(new ArrayList<wfcPattern>());
			for(int j=0;j<width;j++) {
				grid.get(i).add(null);
			}
		}
		for(int i = 0;i<height;i++) {
			for(int j = 0;j<width;j++) {
				List<wfcPattern> possibles = new ArrayList<wfcPattern>();
				for(wfcPattern t : tiles) possibles.add(new wfcPattern(t));
				if(i-1<0) oneFull(possibles,tiles.get(0),2);
				else match(possibles,grid.get(i-1).get(j),3);
				if(j-1<0) oneFull(possibles,tiles.get(0),0);
				else match(possibles,grid.get(i).get(j-1),1);
				if(i+1>=width) oneFull(possibles,tiles.get(0),3);
				else match(possibles,grid.get(i+1).get(j),2);
				if(j+1>=height) oneFull(possibles,tiles.get(0),1);
				else match(possibles,grid.get(i).get(j+1),0);
//				for(wfcPattern p : possibles)
//					System.out.print(String.format("%s %d %d", p,i,j));
//				System.out.println();
				if(possibles.size() != 0) {
					wfcPattern p = possibles.get((int)(possibles.size()*Math.random()));
					grid.get(i).set(j,new wfcPattern(p)); 
				}
			}
		}
		return grid;
	}
	
	public void match(List<wfcPattern> l,wfcPattern p, int direction) {
		if(p == null) return;
		List<wfcPattern> cl = new ArrayList<wfcPattern>(l);
		for(wfcPattern i : cl) {
			switch(direction) {
			case 0:
				if(!p.left.contains(i.id) || !i.right.contains(p.id)) l.remove(i);
				break;
			case 1:
				if(!p.right.contains(i.id) || !i.left.contains(p.id)) l.remove(i);
				break;
			case 2:
				if(!p.top.contains(i.id) || !i.bottom.contains(p.id)) l.remove(i);
				break;
			case 3:
				if(!p.bottom.contains(i.id) || !i.bottom.contains(p.id)) l.remove(i);
				break;
			}
		}
	}
	
	/*
	 * 0 -> left
	 * 1 -> right
	 * 2 -> top
	 * 3 -> bottom
	 * 
	 * */
	public void oneFull(List<wfcPattern> l, wfcPattern zero,int side) {
		if(zero != null) return;
		List<wfcPattern> cl = new ArrayList<wfcPattern>(l);
		for(wfcPattern wp : cl) {
			switch(side) {
			case 0:
				if(wp == zero || wp.left.contains(0)) {
					l.remove(wp);
				}
				break;
			case 1:
				if(wp == zero || wp.right.contains(0)) {
					l.remove(wp);
				}
				break;
			case 2:
				if(wp == zero || wp.top.contains(0)) {
					l.remove(wp);
				}
				break;
			case 3:
				if(wp == zero || wp.bottom.contains(0)) {
					l.remove(wp);
				}
				break;
			}
		}
	}
}
package projet_exploration.App;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.*;
import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.Random;

import projet_exploration.Cases.CasePerso;
import projet_exploration.Entity.Joueur;
import projet_exploration.Entity.Monstre;

public class Fenetre extends JFrame implements KeyListener{
	public Grille G;
	public UI affichage;
	public Joueur joueur;
	// public Monstre ennemieCombat; truc qui marche pas meme si tu met joueur 
	public JPanel panel;  
	public Game master;


	public Fenetre(String str, Game m){
		super(str);
		this.addKeyListener(this);
		this.master = m;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent arg0) {

		if(!affichage.modeCombat) {

			boolean didS = false;
			Point jPos = affichage.joueur.getPos();
			switch(arg0.getKeyChar()) {
			case 'q':
				jPos.translate(0, -1);
				if(G.isMovable(jPos)) {
					affichage.joueur.setPos(jPos);
					didS = true;
				}
				break;
			case'z':
				jPos.translate(-1, 0);
				if(G.isMovable(jPos)) {
					affichage.joueur.setPos(jPos);
					didS = true;
				}
				break;
			case's':
				jPos.translate(1,0);
				if(G.isMovable(jPos)) {
					affichage.joueur.setPos(jPos);
					didS = true;
				}
				break;
			case'd':
				jPos.translate(0,1);
				if(G.isMovable(jPos)) {
					affichage.joueur.setPos(jPos);
					didS = true;
				}
				break;
			}

			if(didS) {    		
				Evenement E = G.map[jPos.x][jPos.y].playerOnCase();
				if(E != null)
					E.action(master);
				for(CasePerso cp : affichage.Persos) {
					Monstre m = (Monstre) cp.p;
					E = m.action(master, cp);
					if(E != null)
						E.action(master);
				}
			}
		}
		else {
			switch(arg0.getKeyChar()) {
			case 'k':
				Random random = new Random();
			    int randomNumber = random.nextInt(6) + 1;
			    
			    switch (randomNumber) {
			      case 1:
			        System.out.println("1: OUCH!! L'ennemi vous infligent un coup critique!!");
			        this.joueur.pv-=3;
			        break;
			      case 2:
			        System.out.println("2: L'ennemi vous frappe au tibia!");
			        this.joueur.pv-=2;
			        break;
			      case 3:
			        System.out.println("3: OUF! Tu esquive inextremis!");
			        break;
			      case 4:
			        System.out.println("4: Touché! l'ennemi est atteint.");
			        this.ennemieCombat.pv-=1;
			        break;
			      case 5:
			        System.out.println("5: Tu frappe l'ennemi de toute tes forces.");
			        this.ennemieCombat.pv-=3;
			        break;
			      case 6:
			        System.out.println("6: Tu boit une potion");
			        this.joueur.pv+=3;
			        break;
			      default:
			        System.out.println("Erreur: nombre aléatoire inattendu");
			        break;
			    }
			    
			    break;
			}
		}

		affichage.repaint();
	}


}

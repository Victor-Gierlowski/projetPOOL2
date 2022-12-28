package projet_exploration.Cases;

import javax.swing.*;

import projet_exploration.App.Evenement;

import java.awt.*;
import java.util.List;

public abstract class Case extends JPanel {
	
	public int x;
	public int y;
	public Image img;
	protected boolean movable =false;
	public static int size = 160;
	public static final int VIDE = 2;
	public static final int MUR = 1;
	public static final int PERSO = 3;
	public static final int TRESOR = 4;
	public static final int PORTE = 5;

	protected Case(int _x, int _y,List<Integer> args) {
		super();
		this.x=_x;
		this.y=_y;
		setPreferredSize(new Dimension(160, 160));
	}
	
	public void setPos(Point p) {
		this.x = p.x;
		this.y = p.y;
	}

	public int getX() { return this.x; }

	public int getY() { return this.y; }
	
	public Point getPos() {
		return new Point(this.x,this.y);
	}

	// Type : VIDE = 1, MUR = 2, PERSO = 3, TRESOR = 4, PORTE = 5
	public static Case createCase(int TYPE, int _x, int _y, List<Integer>  args) {
		if(TYPE==VIDE)
			return new CaseVide(_x, _y, args);
		else if(TYPE==MUR)
			return new CaseMur( _x, _y, args);
		//else if(TYPE==PERSO)
			//return new CasePerso(_x, _y);
		else if(TYPE==TRESOR)
			return new CaseTresor( _x, _y, args);
		else if(TYPE==PORTE)
			return new CasePorte(_x, _y, args);
		else return new CaseVide(_x, _y, args);
	}

	public void dessine(Graphics2D g) {
		
		g.fillRect( this.y*size,this.x*size, size,size);
		// g.fillOval(this.y*size, this.x*size,size, size/2);
	}

	public boolean isMovable() {
		// TODO Auto-generated method stub
		return this.movable;
	}

	public abstract Evenement playerOnCase();
}
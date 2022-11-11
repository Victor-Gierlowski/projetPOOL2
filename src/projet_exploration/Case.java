package projet_exploration;

import java.util.List;
import java.nio.file.*;
import javax.swing.*;
import java.awt.*;

public abstract class Case extends JPanel {
	
	public int x;
	public int y;
	public static final int VIDE = 2;
	public static final int MUR = 1;
//	public static final int PERSO = 3;
	public static final int TRESOR = 4;
	public static final int PORTE = 5;

	protected Case(int _x, int _y) {
		super();
		this.x=_x;
		this.y=_y;
		setPreferredSize(new Dimension(100, 100));
	}

	public int getX() { return this.x; }

	public int getY() { return this.y; }

	// Type : VIDE = 1, MUR = 2, PERSO = 3, TRESOR = 4, PORTE = 5
	public static Case createCase(int TYPE, int _x, int _y, int ...b) {
		if(TYPE==VIDE)
			return new CaseVide(_x, _y);
		else if(TYPE==MUR)
			return new CaseMur( _x, _y);
//		else if(TYPE==PERSO)
//			return new CasePerso(_x, _y);
		else if(TYPE==TRESOR)
			return new CaseTresor( _x, _y);
		else if(TYPE==PORTE)
			return new CasePorte(_x, _y);
		else return new CaseVide(_x, _y);
	}

	
}
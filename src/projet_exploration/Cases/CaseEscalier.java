package projet_exploration.Cases;

import java.awt.*;

import javax.swing.*;
// import javax.swing.JPanel;

import Evenements.nextLevel;
import projet_exploration.App.Evenement;
import java.util.List;

public class CaseEscalier extends Case{

	public CaseEscalier(int _x, int _y, List<Integer> args) {
		super(_x, _y, args);
		// setBackground(Color.GRAY);
		this.img = new ImageIcon("img/escalier.png").getImage();
		this.movable = true;
	}

	public String toString() { return String.format("E"); }

	public void dessine(Graphics2D g) {
		// g.setColor(Color.RED);
		// super.dessine(g);
		g.drawImage(this.img, this.y*size, this.x*size,size,size,null);
	}

	@Override
	public Evenement playerOnCase() {
		
		return new nextLevel(this);
	}
	public void stopmove() {
		this.movable=false;
	}
}


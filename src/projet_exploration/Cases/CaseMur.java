package projet_exploration.Cases;

import java.awt.*;

import javax.swing.*;
// import javax.swing.JPanel;

import projet_exploration.App.Evenement;


public class CaseMur extends Case {

	public CaseMur(int _x, int _y) {
		super(_x, _y);
		// setBackground(Color.GRAY);
		this.img = new ImageIcon("img/mur.png").getImage();
	}

	public String toString() { return String.format("M"); }

	public void dessine(Graphics2D g) {
        // g.setColor(Color.RED);
		// super.dessine(g);
		g.drawImage(this.img, this.y*size, this.x*size,size,size,null);
	}

	@Override
	public Evenement playerOnCase() {
		// TODO Auto-generated method stub
		return null;
	}
}
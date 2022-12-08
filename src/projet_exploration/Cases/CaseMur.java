package projet_exploration.Cases;

import java.awt.*;

import javax.swing.ImageIcon;
// import javax.swing.JPanel;


class CaseMur extends Case {

	public CaseMur(int _x, int _y) {
		super(_x, _y);
		setBackground(Color.GRAY);
	}

	public String toString() { return String.format("M"); }

	public void dessine(Graphics2D g) {
        //g.setColor(Color.RED);
		ImageIcon img= new ImageIcon("img/mur.png");
		img.paintIcon(this,g,160,160);
		super.dessine(g);
	}
}
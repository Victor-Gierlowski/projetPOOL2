package projet_exploration.Cases;

import java.awt.*;

import javax.swing.ImageIcon;

import projet_exploration.App.Evenement;
import projet_exploration.Entity.Personnage;

public class CasePerso extends Case { //j ai add public ici
    public Personnage p;

    public CasePerso(int _x, int _y, Personnage _p) {
        super(_x, _y,null);
        this.p = _p;
        this.img = new ImageIcon(_p.getIcon()).getImage();
    }
    
    public CasePerso(Point p, Personnage _p) {
    	this(p.x,p.y,_p);
    }

	public String toString() { return String.format("F"); }

    // @Override
    // public void paintComponent(Graphics g) {
    //     super.paintComponent(g);
    //     Graphics2D g2 = (Graphics2D) g;
    //     g2.setColor(Color.BLUE);
    //     g2.drawLine(0, 0, 800, 600);
    // }
    public void dessine(Graphics2D g) {
        //g.setColor(Color.BLUE);
        //super.dessine(g);
        g.drawImage(this.img, this.y*size, this.x*size,size,size,null);
		//g2.fillRect(this.x*this.size, this.y*this.size, this.size, this.size);
	}

	public Personnage getP() {
		return p;
	}

	public void setP(Personnage p) {
		this.p = p;
	}

	@Override
	public Evenement playerOnCase() {
		// TODO Auto-generated method stub
		return null;
	}
}
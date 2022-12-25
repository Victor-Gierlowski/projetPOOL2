package projet_exploration.Cases;

import java.awt.*;

import javax.swing.ImageIcon;

import projet_exploration.Entity.Personnage;

public class CasePerso extends Case { //j ai add public ici
    public int pv=1;
    private Personnage p;

    public CasePerso(int _x, int _y) {
        super(_x, _y);
        this.img = new ImageIcon("img/personnage1.png").getImage();
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
}
package projet_exploration.Cases;

import java.awt.*;

import projet_exploration.Entity.Personnage;

class CasePerso extends Case {
    public int pv=1;
    private Personnage p;

    public CasePerso(int _x, int _y) {
        super(_x, _y);
    }

    public String toString() { return this.p.toString(); }

    @Override
    public void paintComponent(Graphics g) {
        setBackground(Color.BLUE);
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(0,0,getWidth(),getHeight());
    }
}
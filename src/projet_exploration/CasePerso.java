package projet_exploration;

import java.awt.*;

class CasePerso extends Case {
    int pv=1;

    public CasePerso(int _x, int _y) {
        super(_x, _y);
    }

    public String toString() { return String.format("O"); }

    @Override
    public void paintComponent(Graphics g) {
        setBackground(Color.BLUE);
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(0,0,getWidth(),getHeight());
    }
}
package projet_exploration.App;
import java.awt.event.*;
import javax.swing.JFrame;

public class Fenetre extends JFrame implements KeyListener{
    public Grille G;

    public Fenetre(String str){
        super(str);
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub
        this.G.map[0][0].x ++;
        UI a = (UI)(this.getComponents()[0]);
        a.map = this.G.map;
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }
}

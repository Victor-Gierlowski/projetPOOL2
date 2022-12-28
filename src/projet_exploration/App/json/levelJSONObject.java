package projet_exploration.App.json;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class levelJSONObject {
	public List<Integer> spawn;
	public List<String> ennemies;
	public List<List<List<Integer>>> map;
	public List<Point> portes;
	
	public void setupPortes() {
		this.portes = new ArrayList();
		for(int i=0;i<map.size();i++) {
			for(int j=0;j<map.get(0).size();j++) {
				if(map.get(i).get(j).get(0) == 5)
					portes.add(new Point(i,j));
			}
		}
	}
	
	public Point getSpawn() {
		if(this.spawn != null && this.spawn.size() == 2) {
			return new Point(this.spawn.get(0),this.spawn.get(1));
		}
		else
			return new Point(1,1);
	}
	
	public Point getPorte(int n) {
		System.out.println(String.format("%d %d",n,portes.size()));
		if(n < portes.size() && n >= 0)
			return portes.get(n);
		return getSpawn();
	}
}

package cm.graham.enveloppe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cm.graham.point.Point;

public class Points {

	private List<Point> points;

	
	public Points(List<Point> points) {
		super();
		this.points = points;
	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}
		
	/*point le plus bas et le plus à gauche*/
	public Point plusBasGauche() {
		Point p = points.get(0);
		
		for (int i = 0; i < points.size(); i++) {
		
			if ((points.get(i).getOrd() < p.getOrd()) || (points.get(i).getOrd() == p.getOrd() && points.get(i).getAbs() < p.getAbs()) ) {
				p = points.get(i);
			}
		}	
		return p;
	}
	
	/*trie sur les points*/
	public List<Point> trierPoints() {
		
		List<Point> pointTrier = new ArrayList<Point>();
		Map<Double, Point> map = new HashMap<Double, Point>();
		double[] tab = new double[points.size()-1];
		int i = 0;
		
		for (Point point : points) {
			if (!point.equals(plusBasGauche())) {
				double val  = produitEnCroix(plusBasGauche(), point);
				map.put(val, point);
				
				tab[i]=val;
				i++;
			}
			
			triTab(tab);
			
			for (double d : tab) {
				pointTrier.add(map.get(d));
			}
			
		/*	for (int j = 0; j < tab.length; j++) {
				for (int k = j+1; k < tab.length; k++) {
					if (tab[j] == tab[k] && map.get(tab[k]).getAbs() < map.get(tab[j]).getAbs()) {
						pointTrier.remove(k);
					}
					
					if (tab[j] == tab[k] && map.get(tab[j]).getAbs() < map.get(tab[k]).getAbs()) {
						pointTrier.remove(k);
					}
						
				}
			}
			for (double d : tab) {
				
			}*/
		}		
		return pointTrier;
	}
	
	private void triTab(double tab[]) {
		
		double cle;
		int i;
		
		for (int j = 1; j < tab.length; j++) {
			cle = tab[j];
			i = j - 1;
			
			while (i > -1 && tab[i] > cle) {
				tab[i + 1] = tab[i];
				i = i - 1;
			}
			tab[i+1] = cle;
		}
	}
	
	/*eliminer les points ayant les meme anngle polaire par rapport au plus bas point*/
	public List<Point> eliminerPoint(){
		return null;
	}
	
	/*determiner la nature de bifurcation au point q*/
	public double produitEnCroix(Point p, Point q) {
		return p.getAbs()*q.getOrd() - q.getAbs()*p.getOrd();
	}
}

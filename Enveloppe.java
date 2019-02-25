package cm.graham.enveloppe;

import java.util.ArrayList;
import java.util.List;

import cm.graham.point.Point;

public class Enveloppe {
	List<Point> enveloppeConvexe = new ArrayList<Point>();
	
public Enveloppe(Point...pts) {
		for (Point point : pts) {
			enveloppeConvexe.add(point);
		}
	}
	public Enveloppe() {}
	
	/*ajouter un element au sommet d'une liste*/
	
	public void empiler(Point point) {
		this.enveloppeConvexe.add(point);
	}

	/*retirer un element du sommet d'une liste*/
	
	public void depiler(int indexTete) {
		
		indexTete = enveloppeConvexe.size();
		this.enveloppeConvexe.remove(indexTete);
	}
	
	/*retourner le sommet*/
	public Point sommet() {
		int indexTete = enveloppeConvexe.size();
		Point dernier = enveloppeConvexe.get(indexTete-1);
		
		return dernier;
	}
	
	/*retourner le sous-sommet*/
	public Point sousSommet() {
		int index2 = enveloppeConvexe.size()-2;
		Point avDernier = enveloppeConvexe.get(index2);
		
		return avDernier;
		
	}
	
	/*determiner la nature de bifurcation au point q*/
	public double bifurcation(Point p, Point q, Point r) {
		double x1 = r.getAbs() - p.getAbs(),
				x2 = q.getAbs() - p.getAbs(),
				y1 = r.getOrd() - p.getOrd(),
				y2 = q.getOrd() - p.getOrd();
		return ( (x1*y2) - (x2*y1) );
	}

}

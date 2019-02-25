package cm.graham.enveloppe;

import java.util.ArrayList;
import java.util.List;

import cm.graham.point.Point;

public class Application {

	public Application() {}
	
	public List< Point> graham(Points points, Enveloppe env){
		
		Point p0 = points.plusBasGauche();
		List<Point> pointsTries = new ArrayList<Point>();
				
		pointsTries = points.trierPoints();
	
		env.empiler(pointsTries.get(0));
		env.empiler(pointsTries.get(1));
		env.empiler(pointsTries.get(2));
		
		for (int i = 2; i < pointsTries.size(); i++) {
			while (env.bifurcation(env.sousSommet(), env.sommet(), pointsTries.get(i)) > 0) {
				env.depiler(env.enveloppeConvexe.size());
			}
			env.empiler(pointsTries.get(i));
		}
		
	return env.enveloppeConvexe;
	}
	
	public static void main(String[] args) {
		Point p1 = new Point(1, 2);
		Point p2 = new Point(3, 4);
		Point p3 = new Point(5, 6);
		Point p4 = new Point(7, 8);
		Point p5 = new Point(9, 10);
		
		List<Point> pts = new ArrayList<Point>();
		pts.add(p5);pts.add(p4);pts.add(p3);pts.add(p2);pts.add(p1);
		
		Points region = new Points(pts);
		
		List<Point> env = new ArrayList<Point>();
		Enveloppe ev = new Enveloppe(p1,p2,p3);	
		
		Application app = new Application();
		env = app.graham(region, ev);
		
	}
}

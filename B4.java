import java.util.HashSet;
import java.util.Set;

/**
 * Created by caotung on 13/12/2017.
 */
public class B4 {

    public static double distance(Point2D p1, Point2D p2){
        double distance;
        distance = Math.sqrt(Math.pow((p1.getX()-p2.getX()), 2) + Math.pow((p1.getY()-p2.getY()), 2));
        return distance;
    }

    public static void main(String[] args){
        Set<Point2D> set = new HashSet<>();
        Set<Point2D> set8000 = new HashSet<>(); //max : 1200, 1200
        Set<Point2D> set10000 = new HashSet<>(); //max : 4500, 1300
        Set<Point2D> set12000 = new HashSet<>(); //max : 3000, 3000
        Point2D A = new Point2D(800,800);
        Point2D B = new Point2D(4000, 800);
        Point2D C = new Point2D(2400, 2400);

        //8000 first point
        while(set.size() < 8000){
            int x;
            int y;
            x = (int)(Math.random()*1200 + 1);
            y = (int)(Math.random()*1200 + 1);
            Point2D point = new Point2D(x,y);
            if (distance(A,point) <= 400.0){
                set.add(point);
            }
        }

        //10000 next point
        while(set.size() < 18000){
            int x;
            int y;
            x = (int)(Math.random()*4500 + 1);
            y = (int)(Math.random()*1300 + 1);
            Point2D point = new Point2D(x,y);
            if (distance(B,point) <= 500.0){
                set.add(point);
            }
        }

        //12000 last point
        while(set.size() < 30000){
            int x;
            int y;
            x = (int)(Math.random()*3000 + 1);
            y = (int)(Math.random()*3000 + 1);
            Point2D point = new Point2D(x,y);
            if (distance(C,point) <= 600.0){
                set.add(point);
            }
        }
        System.out.println(set.size());
    }
}

import java.util.HashSet;
import java.util.Set;

/**
 * Created by caotung on 13/12/2017.
 */
public class B1 {
    public static void main(String[] args)
    {
        Set<Integer> set1 = new HashSet<>();
        while(set1.size() < 200000){
            int item;
            item = (int)(Math.random()*500000 + 1);
            set1.add(item);
        }
        Set<Integer> set2 = new HashSet<>();
        while(set2.size() < 200000){
            int item;
            item = (int)(Math.random()*500000 + 1);
            set2.add(item);
        }
        Set<Integer> intersection = new HashSet<Integer>(set1);
        intersection.retainAll(set2);
        System.out.println("Lenght of Intersect : ");
        System.out.println(intersection.size());
    }
}

import java.util.ArrayList;
import java.util.List;

import javax.swing.Spring;

public class SpiralPrintMatrix {
	
	public static <T> List<T> asList(T ... items) {
        List<T> list = new ArrayList<T>();
        for (T item : items) {
            list.add(item);
        }

        return list;
    }

	public static void main(String[] args) {
		List<List<Integer>> list = asList(
                asList(1,2,3),
                asList(4,5,6),
                asList(7,8,9));
		
		List<Integer> result = spiralOrder(list);
		for(int i = 0 ; i<result.size();i++){
			System.out.println(result.get(i));
		}
		
	}
	
	public static ArrayList<Integer> spiralOrder(final List<List<Integer>> a) {
		 ArrayList<Integer> result = new ArrayList<Integer>();
		 // Populate result;
		 
		 int rows = a.size();
		 int cols = a.get(0).size();
		 
		 int r = 0,c=0;
		 while(r<rows && c<cols){
			 for(int i = c;i<cols;i++){
				 result.add(a.get(r).get(i));
			 }
			 
		 }
		 
		 return result;
	}
}

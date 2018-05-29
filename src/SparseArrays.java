import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * There are strings. Each string's length is no more than characters. There are also queries. For each query, you are given a string, and you need to find out how many times this string occurred previously.

Input Format

The first line contains , the number of strings.
The next lines each contain a string.
The nd line contains , the number of queries.
The following lines each contain a query string. 
 */
public class SparseArrays {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> map = new HashMap<>();
		int n = sc.nextInt();
		for(int i = 0 ;i<n;i++){
			String str = sc.next();
			if(map.containsKey(str)){
				int value = map.get(str);
				value++;
				map.put(str, value);
			}else{
				map.put(str, 1);
			}
		}
		int q = sc.nextInt();
		for(int i = 0 ;i<q;i++){
			String str = sc.next();
			if(map.containsKey(str)){
				System.out.println(map.get(str));
			}else{
				System.out.println(0);
			}
		}
	}
}

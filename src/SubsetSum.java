import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//Dynamic programming solution
/*
 * You are given a list of N positive integers, A = {a[1], a[2], ..., a[N]} and another integer S. You have to find whether there exists a non-empty subset of A whose sum is greater than or equal to S.

You have to print the size of minimal subset whose sum is greater than or equal to S. If there exists no such subset then print -1 instead.

Input
First line will contain an integer, N, which is the size of list A. Second line contains N space separated integers, representing the elements of list A. In third line there is an integer, T, which represent the number of test cases to follow. Then follows T lines. Each one of them contains an single integer, S.

Output
For each test case, print the size of minimal subset whose sum is greater than or equal to S. If there's no such subset then print -1.
 */
public class SubsetSum {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		
		long[] arr = new long[size];
		String[] input = br.readLine().split(" ");
		
		for(int i =0;i<size;i++){
			arr[i] = Integer.parseInt(input[i]);
		}
		
		int t = Integer.parseInt(br.readLine());
		
		long[] sumArr = new long[t];
		
		long max = 0;
		
		for(int i =0;i<t;i++){
			sumArr[i] = Integer.parseInt(br.readLine());
			if(sumArr[i] > max){
				max = sumArr[i];
			}
		}
		Arrays.sort(sumArr);
		
		boolean[][] aux = buildAux(size,max);
		
		for(int i =1;i<=size;i++){
			for(int j =1 ;j<=max;j++){
				if(sumArr[i] > j){
					aux[i][j] = aux[i-1][j];
				}else{
					aux[i][j] = aux[i-1][j] || aux[i][j-sumArr[j]];
				}
			}
		}
		for(int i = 0;i<sumArr.length;i++){
			int num = sumArr[i];
			if(aux[])
		}
	}

	private static boolean[][] buildAux(int size,int max) {
		
		boolean[][] aux = new boolean[size+1][max+1];
		
		for(int i = 0;i<=size;i++){
			aux[i][0] = true;
		}
		for(int i =1;i<=max;i++){
			aux[0][i] = false;
		}
		return aux;
	}
	
}

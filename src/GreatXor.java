import java.util.Scanner;

public class GreatXor {

	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int q = in.nextInt();
	        for(int a0 = 0; a0 < q; a0++){
	            long x = in.nextLong();
	int b = 0;
		            double count=0;
		            for(int temp = (int)Math.pow(2, b);temp<x;){
		            	long num = temp & x;
		            	if(num == 0){
		            		count = count+(Math.pow(2, b+1) - Math.pow(2, b));
		            	}
		            	b++;
		            	temp = (int)Math.pow(2, b);
		            }
		            System.out.println((int)count);        }
	    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoComplement {
	 public static void main(String[] args) throws IOException, NumberFormatException{

	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int t = Integer.parseInt(br.readLine().trim());
	        while(t>0){
	            String[] str = br.readLine().split(" ");
	            int a = Integer.parseInt(str[0]);
	            int b = Integer.parseInt(str[1]);
	            long result = 0;
	            for(int i =a;i<=b;i++){
	            	int compliment = i;
	            	while(compliment != 0){
	            		compliment = compliment & (compliment-1);
	            		result++;
	            	}
	            }
	            System.out.println(result);
	            t--;
	        }
	    }

}

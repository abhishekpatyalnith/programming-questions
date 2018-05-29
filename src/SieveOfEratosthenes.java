import java.util.Arrays;

public class SieveOfEratosthenes {

	public static void main(String[] args) {
		int n = 50;
		
		boolean[] arr = new boolean[n+1];
		Arrays.fill(arr, true);
		
		for(int i =2;i*i<=n;i++){
			if(arr[i]){
				for(int j = i*2;j<=n;){
					arr[j] = false;
					j = j+i;
				}
			}
		}
		for(int i = 2;i<=n;i++){
			if(arr[i]){
				System.out.print(i+" ");
			}
		}
	}
	void checkPrimality(int n){
		boolean[] primes = new boolean[(2*(int)Math.pow(10, 9))+1];
		Arrays.fill(primes, true);
		for(int i=2;i*i<primes.length;i++){
			if(primes[i]){
				for(int j=i*2;j<=primes.length;){
					primes[j] = false;
					j = j+i;
				}
			}
		}
	}
}

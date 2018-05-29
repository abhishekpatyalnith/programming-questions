
public class Combanotorics {
	
	static int fact(int n)
	   {
	       int output;
	       if(n==1){
	         return 1;
	       }
	       //Recursion: Function calling itself!!
	       output = fact(n-1)* n;
	       return output;
	   }

	public static void main(String[] args) {
		
		int[] arr = new int[]{2,2,0,0};
		
		int total = 0;
		for( int i =0;i<arr.length;i++){
			total +=arr[i];
		}
		int perms = fact(total);
		for(int i = 0;i<arr.length;i++){
			if(arr[i]!=1 && arr[i]!=0){
				perms = perms/fact(arr[i]);
			}
		}
		int count = 0;
		for(int i =0;i<arr.length;i++){
			if(arr[i]!=1 && arr[i]!=0){
				count++;
			}
		}
		int factorial = fact(count);
		System.out.println(perms-factorial);
	}
}


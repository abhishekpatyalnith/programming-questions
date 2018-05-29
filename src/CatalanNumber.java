
public class CatalanNumber {

	public static void main(String[] args) {
		
        int n = 3;
        long[] aux = new long[n+1];
        
        aux[0] = 1;
        aux[1] = 1;
        
        for(int i=2;i<=n;i++){
            aux[i] = 0;
            for(int j=0;j<i;j++){
                aux[i] = aux[j]*aux[i-j];
            }
        }
        long result = aux[0]/2;
        for(int i=0;i<=n;i++){
        	 System.out.println(aux[i]);
        }
        System.out.println(result);
	}
}


public class Power {
public static void main(String[] args) {
		
		int x = 2;
		int y = 5;
		boolean yNegative = false;
		if(y < 0){
			yNegative = true;
		}
		y = Math.abs(y);
		float result = pow(x,y);
		if(yNegative){
			result = 1/result;
		}
		System.out.println(result);
	}

	/*private static int pow(int x, int y) {
		
		if(y == 0){
			return 1;
		}
		int temp = pow(x,y/2);
		if(y%2==0){
			temp = temp * temp;
		}else{
			temp = temp * temp * x;
		}
		return temp;
	}*/

	private static int pow(int x, int y){
		int temp = 1;
		boolean yOdd = false;
		if(y%2!=0){
			yOdd = true;
		}
		while(y>0){
			temp = temp * x;
			y = y/2;
		}
		if(yOdd){
			temp = temp * temp *x;
		}
		else{
			temp = temp * temp;
		}
		return temp;
	}

}

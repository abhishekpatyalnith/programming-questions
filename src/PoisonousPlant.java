import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Plant{
	long pestcide;
	int daysAlive;
	public Plant(long pestcide, int daysAlive) {
		super();
		this.pestcide = pestcide;
		this.daysAlive = daysAlive;
	}
	
}
public class PoisonousPlant {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Long[] arr = new Long[n];
        String[] str = br.readLine().split(" ");
        for(int i = 0;i<n;i++){
            arr[i] = Long.parseLong(str[i]);
        }
        Stack<Plant> stack = new Stack<>();
        int maxDaysAlive = 0;
        for(int i=0;i<n;i++){
        	int daysAlive = 0;
        	while(!stack.isEmpty() && arr[i] <= stack.peek().pestcide){
        		daysAlive = Math.max(daysAlive, stack.pop().daysAlive);
        	}
        	daysAlive = stack.isEmpty() ? 0 : daysAlive+1;
        	maxDaysAlive = Math.max(maxDaysAlive, daysAlive);
        	stack.push(new Plant(arr[i],daysAlive));
        }
        System.out.println(maxDaysAlive);
	}
}

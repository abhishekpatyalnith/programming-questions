import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// hotstar question 8
public class TestClass {

    public static void main(String[] args) throws Exception {
        BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
        String inp = br.readLine();
        int n = Integer.parseInt(inp.split(" ")[0]);
        int x = Integer.parseInt(inp.split(" ")[1]);
        inp = br.readLine();
        String[] inps = inp.split(" ");
        int[] a = new int[1000000];
        int[] index = new int[1000000];
        for (int i=1 ; i<=n ; i++) {
            a[i] = Integer.parseInt(inps[i-1]);
            index[i]=i;
        }
        int s = 1;
        int e = n+1;
        ArrayList<Integer> res= new ArrayList<>();
        for(int i=0 ; i<x ; i++) {
            int maxin = s;
            for(int j=s ; j<=Math.min(s+x-1, e-1) ; j++) {
                if(a[maxin]<a[j]) {
                    maxin=j;
                }
            }
            res.add(index[maxin]);
            int ef = e;
            for(int j=s ; j<=Math.min(s+x-1, ef-1) ; j++) {
                if(j!=maxin) {
                    if(a[j]!=0) {
                        a[e] = a[j]-1;
                    }
                    index[e] = index[j];
                    e++;
                }
            }
            s=Math.min(s+x,ef);
        }
        for(int i=0 ; i<res.size() ; i++) {
            System.out.print(res.get(i)+" ");
        }
    }
}
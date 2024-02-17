import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main{
	static int mod = 1000000;
	static int pisano = 1500000;
	public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	int N = (int)(Long.parseLong(br.readLine()) % pisano);
    	
    	int[] num = new int[pisano+1];
    	num[1] = 1;
    	
    	for(int i = 2; i <= pisano; i++) {
    		num[i] = (num[i - 2] + num[i - 1]) % mod;
    	}
    	System.out.print(num[N]);
    }
}

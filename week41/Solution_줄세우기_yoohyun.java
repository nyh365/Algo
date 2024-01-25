import java.util.*;
import java.lang.*;
import java.io.*;
 
public class Main{
    public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	int N = Integer.parseInt(br.readLine());
    	
    	int[] children = new int[N];
    	int[] dp = new int[N];
    	for(int i = 0; i < N; i++) {
    		children[i] = Integer.parseInt(br.readLine());
    	}
  
    	Arrays.fill(dp, 1);
    	
    	for(int i = 1; i < N; i++) {
    		int max = dp[i];
    		for(int j = 0; j < i; j++) {
    			if(children[j] < children[i]) {
    				max = Math.max(dp[j] + 1, max);      				
    			}
    		}
    		dp[i] = max;
    	}
    	
    	int result = 0;
    	for(int i = 0; i < N; i++) {
    		result = Math.max(result, dp[i]);
    	}
    	
    	System.out.print(N - result);
    }
}

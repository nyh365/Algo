import java.util.*;
import java.lang.*;
import java.io.*;
 
public class Main{
	public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	int N = Integer.parseInt(br.readLine());
    	int[] num = new int[N];
    	int[][] dp = new int[N][2];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < N; i++) {
    		num[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	dp[0][0] = 1;
    	for(int i = 1; i < N; i++) {
    		dp[i][0] = 1;
    		for(int j = 0; j < i; j++) {
    			if(num[j] < num[i]) {
        			if(dp[i][0] < dp[j][0] + 1) {
        				dp[i][0] = dp[j][0] + 1;
        				dp[i][1] = j;
        			}
        		}
    		}
    	}
    	
    	int resultCnt = 0, index = 0;
    	for(int i = 0; i < N; i++) {
    		if(resultCnt < dp[i][0]) {
    			resultCnt = dp[i][0];
    			index = i;
    		}
    	}
    	
    	int[] result = new int[resultCnt];
    	result[0] = num[index];
    	for(int i = 1; i < resultCnt; i++) {
    		result[i] = num[dp[index][1]];
    		index = dp[index][1];
    	}
    	
    	Arrays.sort(result);
    	
    	sb.append(resultCnt).append("\n");
    	for(int i = 0; i < resultCnt; i++) {
    		sb.append(result[i]).append(" ");
    	}
    	
    	System.out.print(sb);
    }
}

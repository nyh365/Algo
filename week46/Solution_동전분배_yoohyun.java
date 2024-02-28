import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main{
	static boolean[] totals = new boolean[50001];
	static int[][] coins;
	public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	int total;
    	for(int test_case = 0; test_case < 3; test_case++) {
    		Arrays.fill(totals, false);
    		totals[0] = true;
    		
    		int N = Integer.parseInt(br.readLine());
    		coins = new int[N][2];
    		
    		total = 0;
    		
    		int coinType, coinCnt;
    		for(int i = 0; i < N; i++) {
    			st = new StringTokenizer(br.readLine());
    			
    			coinType = Integer.parseInt(st.nextToken());
    			coinCnt = Integer.parseInt(st.nextToken());
    			
    			coins[i][0] = coinType;
    			coins[i][1] = coinCnt;
    			total += coinType * coinCnt;
        	}
        	
    		sb.append(canDivide(total, N) ? 1 : 0).append("\n");
    	}
    	System.out.print(sb);
	}
	public static boolean canDivide(int total, int N) {
		if(total % 2 != 0) return false;
		
		total /= 2;
		
		for(int i = 0; i < N; i++) {
			for(int j = total; j >= 0; j--) {
				if(!totals[j]) continue;
				for(int k = 1; k <= coins[i][1]; k++) {
					if(j + coins[i][0] * k > total) break;
					totals[j + coins[i][0] * k] = true;
				}
			}
		}
		return totals[total];
	}
}

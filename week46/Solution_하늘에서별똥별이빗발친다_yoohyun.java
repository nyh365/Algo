import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class Main{
	static int[][] stars;
	public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int L = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	
    	stars = new int[K][2];
    	
    	for(int i = 0; i < K; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		stars[i][0] = Integer.parseInt(st.nextToken());
    		stars[i][1] = Integer.parseInt(st.nextToken());
    	}
    	
    	int result = Integer.MIN_VALUE;
    	
    	int x, y, cnt;
    	for(int i = 0; i < K; i++) {
    		for(int j = 0; j < K; j++) {
    			x = stars[i][0];
    			y = stars[j][1];
    			cnt = 0;
    			for(int k = 0; k < K; k++) {
    				if(x <= stars[k][0] && stars[k][0] <= x + L && y <= stars[k][1] && stars[k][1] <= y + L) cnt++;
    			}
    			result = Math.max(result, cnt);
    		}
    	}
    	System.out.print(K - result);
    }
}

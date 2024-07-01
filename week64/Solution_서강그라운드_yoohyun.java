import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
 
public class Main{
	static final int INF = 1501;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        
        int[][] ground = new int[N + 1][N + 1];
        int[] items = new int[N + 1];
        for(int i = 1; i <= N; i++) {
        	for(int j = 1; j <= N; j++) {
        		if(i == j) continue;
        		ground[i][j] = INF; 
        	}
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
        	items[i] = Integer.parseInt(st.nextToken());
        }
        
        int a, b, l;
        for(int i = 0; i < R; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
        
            ground[a][b] = l;
            ground[b][a] = l;
        }
        
        for(int k = 1; k <= N; k++) {
        	for(int i = 1; i <= N; i++) {
        		for(int j = 1; j <= N; j++) {
        			ground[i][j] = Math.min(ground[i][j], ground[i][k] + ground[k][j]);
        		}
        	}
        }
        
        int result = 0, temp;
        for(int i = 1; i <= N; i++) {
        	temp = 0;
        	for(int j = 1; j <= N; j++) {
    			if(ground[i][j] > M) continue;
    			temp += items[j];
    		}
        	result = Math.max(result, temp);
    	}
        
        System.out.print(result);
        
    }
}

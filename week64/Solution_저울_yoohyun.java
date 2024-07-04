import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;
 
public class Main{
	static final int INF = 100;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        int[][] stuffs = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
        	for(int j = 1; j <= N; j++) {
        		if(i == j) continue;
        		stuffs[i][j] = INF; 
        	}
        }
        
        int from, to;
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	from = Integer.parseInt(st.nextToken());
        	to = Integer.parseInt(st.nextToken());

        	stuffs[from][to] = 1;
        }
        
        for(int k = 1; k <= N; k++) {
        	for(int i = 1; i <= N; i++) {
        		for(int j = 1; j <= N; j++) {
        			stuffs[i][j] = Math.min(stuffs[i][j], stuffs[i][k] + stuffs[k][j]);
        		}
        	}
        }
        
        int cnt;
        for(int i = 1; i <= N; i++) {
        	cnt = 0;
        	for(int j = 1; j <= N; j++) {
        		if(i == j) continue;
    			if(stuffs[i][j] == INF && stuffs[j][i] == INF) cnt++;
    		}
        	sb.append(cnt).append("\n");
    	}

        System.out.print(sb);
    }
}

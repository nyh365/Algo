import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
 
public class Main{
	static final int INF = 1000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] students = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
        	for(int j = 1; j <= N; j++) {
        		if(i == j) continue;
        		students[i][j] = INF; 
        	}
        }
        
        int from, to;
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
        
            students[from][to] = 1;
        }
        
        for(int k = 1; k <= N; k++) {
        	for(int i = 1; i <= N; i++) {
        		for(int j = 1; j <= N; j++) {
        			students[i][j] = Math.min(students[i][j], students[i][k] + students[k][j]);
        		}
        	}
        }
        
        int result = 0;
        boolean possible;
        for(int i = 1; i <= N; i++) {
    		possible = true;
        	for(int j = 1; j <= N; j++) {
    			if(i == j) continue;
    			if(students[i][j] == INF && students[j][i] == INF) {
    				possible = false;
    				break;
    			}
    		}
        	
        	if(possible) {
        		result++;
        	}
    	}
        
        System.out.print(result);
        
    }
}

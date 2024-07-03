import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;
 
public class Main{
	static final int INF = 51;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        
        int N = Integer.parseInt(br.readLine());
        
        int[][] candidates = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
        	for(int j = 1; j <= N; j++) {
        		if(i == j) continue;
        		candidates[i][j] = INF; 
        	}
        }
        
        int from, to;
        while(true) {
        	st = new StringTokenizer(br.readLine());
        	
        	from = Integer.parseInt(st.nextToken());
        	to = Integer.parseInt(st.nextToken());

        	if(from == -1 && to == -1) break;
        	candidates[from][to] = 1;
        	candidates[to][from] = 1;
        }
        
        for(int k = 1; k <= N; k++) {
        	for(int i = 1; i <= N; i++) {
        		for(int j = 1; j <= N; j++) {
        			candidates[i][j] = Math.min(candidates[i][j], candidates[i][k] + candidates[k][j]);
        		}
        	}
        }
        
        LinkedList<int[]> result = new LinkedList<>();
        int temp;
        for(int i = 1; i <= N; i++) {
        	temp = 0;
        	for(int j = 1; j <= N; j++) {
    			if(candidates[i][j] == INF) continue;
    			temp = Math.max(temp, candidates[i][j]);
    		}
        	result.add(new int[] {i, temp});
    	}

        Collections.sort(result, (a,b) 
        		-> Integer.compare(a[1], b[1]) == 0 ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        
        int cnt = 1;
        for(int i = 1; i < result.size(); i++) {
        	if(result.get(i - 1)[1] != result.get(i)[1]) break;
        	cnt++;
        }
        sb.append(result.get(0)[1]).append(" ").append(cnt).append("\n");
        for(int i = 0; i < cnt; i++) {
        	sb.append(result.get(i)[0]).append(" ");
        }
        
        System.out.print(sb);
        
    }
}

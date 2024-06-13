import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
 
public class Main{
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static double[] dir = new double[4];
	static boolean[][] visited = new boolean[30][30];
	static double result;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < 4; i++) {
        	dir[i] = Integer.parseInt(st.nextToken()) * 0.01;
        }

        visited[15][15] = true;
        solve(1, N, 15, 15);
        
        System.out.print(result);
	}
	public static void solve(double total, int N, int x, int y) {
		if(N == 0) {
			result += total;
			return;
		}
		
		int xx, yy;
		for(int i = 0; i < 4; i++) {
			xx = x + dx[i];
			yy = y + dy[i];
			
			if(visited[yy][xx]) continue;
			visited[yy][xx] = true;
			solve(total * dir[i], N - 1, xx, yy);
			visited[yy][xx] = false;
		}
	}
}

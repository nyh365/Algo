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
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < 4; i++) {
        	dir[i] = Integer.parseInt(st.nextToken()) * 0.01;
        }
        
        System.out.print(solve(0, 0, N - 1, 15, 15));
	}
	public static double solve(double total, int direction, int N, int x, int y) {
		if(N == 0) {
			return total;
		}
		
		double result = 0;
		for(int i = 0; i < 4; i++) {
			result += solve(total * dir[i], i, N - 1, x, y);
		}
		
		return result;
	}
}

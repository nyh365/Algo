import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] cost = new int[N + 1][3];
		int[][] result = new int[N + 1][3];
		for(int i = 1; i <= N; i++) {
			Arrays.fill(result[i], Integer.MAX_VALUE);
		}
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}	
		}
		
		for(int i = 1; i <= N; i++) {
			result[i][0] = Math.min(result[i-1][1] + cost[i][0], result[i-1][2] + cost[i][0]);
			result[i][1] = Math.min(result[i-1][0] + cost[i][1], result[i-1][2] + cost[i][1]);
			result[i][2] = Math.min(result[i-1][0] + cost[i][2], result[i-1][1] + cost[i][2]);
		}
		int min = Math.min(result[N][0], result[N][1]);
		System.out.println(Math.min(min, result[N][2]));
	}
}

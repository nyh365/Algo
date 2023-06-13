import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] memo;
	static int[][] city;
	static int result = Integer.MAX_VALUE;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		city = new int[N][N];
		memo = new int[N][1 << N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(memo[i], Integer.MAX_VALUE);
			for(int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		memo[0][1] = 0;
		dfs(0 ,1);
		
		System.out.println(result);
	}
	public static void dfs(int current, int visit) {
		if(visit == (1 << N) - 1) {
			if(city[current][0] > 0) {
				result = Math.min(result, memo[current][visit] + city[current][0]);
				return;
			}
		}
		
		for(int i = 0; i < N; i++) {
			if((1 << i & visit) == 0) {
				if(city[current][i] != 0) {
					memo[i][(1 << i) | visit] = Math.min(memo[i][(1 << i) | visit], memo[current][visit] + city[current][i]);
					dfs(i, (1 << i) | visit);
				}
			}
		}
		
	}
}

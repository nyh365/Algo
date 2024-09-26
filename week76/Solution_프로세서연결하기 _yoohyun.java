import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList; 
import java.util.StringTokenizer;

public class Solution {
	static int N, result, total;
	static ArrayList<int[]> core;
	static boolean[][] maxi;
	// 상,하,좌,우
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int test_case = Integer.parseInt(br.readLine());
		for(int t = 1; t <= test_case; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			maxi = new boolean[N][N];
			
			core = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					if(Integer.parseInt(st.nextToken()) == 1) {
						maxi[i][j] = true;
						if(i == 0 || i == N - 1 || j == 0 || j == N - 1) continue;
						core.add(new int[] {j,i});
					}
					else
						maxi[i][j] = false;
				}
			}
			total = 0;
			result = Integer.MAX_VALUE;
			//부분집합 구하기
			for(int i = (1 << core.size()) - 1; i >= 0; i--) {
				dfs(0, i, 0, maxi);
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
	public static void dfs(int cur, int subset, int length, boolean[][] arr) {
		if(cur == core.size()) {
			if(total < Integer.bitCount(subset)) {
				total = Integer.bitCount(subset);
				result = length;
			}
			else if(total == Integer.bitCount(subset)) {
				result = Math.min(length, result);
			}
			return;
		}
		if((subset & (1 << cur)) != 0) {
			for(int k = 0; k < 4; k++) {
				int[] loc = core.get(cur);
				int x = loc[0];
				int y = loc[1];
				boolean flag = true;
				while(true) {
					x += dx[k]; y += dy[k];
					if(x < 0 || x >= N || y < 0 || y >= N) break;
					if(arr[y][x]) {
						flag = false;
						break;
					}
				}
				boolean[][] tmp = copy(arr);
				int len = 0;
				if(flag) {
					x = loc[0]; y = loc[1];
					while(true) {
						x += dx[k]; y += dy[k];
						if(x < 0 || x >= N || y < 0 || y >= N) break;
						tmp[y][x] = true;
						len++;
					}
					dfs(cur + 1, subset, length + len, tmp);
				}
			}
		}
		else {
			dfs(cur + 1, subset, length, arr);
		}
	} 
	public static boolean[][] copy(boolean[][] arr){
		boolean[][] tmp = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				tmp[i][j] = arr[i][j];
			}
		}
		return tmp;
	}
}

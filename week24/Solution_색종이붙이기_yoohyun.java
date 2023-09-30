import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] capacity = new int[6];
	static boolean[][] visited = new boolean[10][10];
	static int result;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		for(int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 10; j++) {
				visited[i][j] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
			}
		}
		
		Arrays.fill(capacity, 5);
		
		result = Integer.MAX_VALUE;
		dfs(0,0);
		
		System.out.print(result == Integer.MAX_VALUE ? -1 : result);
	}
	public static void dfs(int x, int y) {
		if(isOver()) {
			result = Math.min(result, total());
			return;
		}
		
		int j = x;
		for(int i = y; i < 10; i++) {
			for(; j < 10; j++) {
				if(!visited[i][j]) continue;
				
				for(int k = 5; k >= 1; k--) {
					if(capacity[k] < 1) continue;
					if(!isOK(j, i, k)) continue;
					capacity[k]--;
					attachPaper(j, i, k);
					dfs(j + k, i);
					
					capacity[k]++;
					detachPaper(j, i, k);
				}
				return;
			}
			j = 0;
		}
	}
	public static int total() {
		int total = 0;
		for(int i = 1; i < 6; i++) {
			total += 5 - capacity[i];
		}
		return total;
	}
	public static boolean isOver() {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(visited[i][j]) return false;
			}
		}
		return true;
	}
	public static boolean isOK(int x, int y, int length) {
		for(int i = y; i < y + length; i++) {
			for(int j = x; j < x + length; j++) {
				if(i < 0 || i > 9 || j < 0 || j > 9) return false;
				if(!visited[i][j]) return false;
			}
		}
		return true;
	}
	public static void attachPaper(int x, int y, int length) {
		for(int i = y; i < y + length; i++) {
			for(int j = x; j < x + length; j++) {
				visited[i][j] = false;
			}
		}
	}
	public static void detachPaper(int x, int y, int length) {
		for(int i = y; i < y + length; i++) {
			for(int j = x; j < x + length; j++) {
				visited[i][j] = true;
			}
		}
	}
}

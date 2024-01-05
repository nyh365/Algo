import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;
	static int N;
	static LinkedList<Integer> result;
	static int[] arr;
	public static void main(String args[]) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			N = Integer.parseInt(br.readLine());
			
			visited = new boolean[N + 1];
			arr = new int[N + 1];
			for(int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			
			result = new LinkedList<>();
			for(int i = 1; i <= N; i++) {
				visited[i] = true;	
				dfs(i, i);
				visited[i] = false;
			}
			
			Collections.sort(result);
			sb.append(result.size()).append("\n");
			
			for(int n : result) {
				sb.append(n).append("\n");
			}
			System.out.print(sb);
	}
	public static void dfs(int cur, int target) {
		if(!visited[arr[cur]]) {
			visited[arr[cur]] = true;
			dfs(arr[cur], target);
			visited[arr[cur]] = false;
		}
		
		if(arr[cur] == target) {
			result.add(target);
		}
	}
}

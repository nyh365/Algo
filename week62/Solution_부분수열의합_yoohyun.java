import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main{
	static boolean[] visited;
	static int N, MAX_VALUE = 100000;
	static int[] num;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        visited = new boolean[MAX_VALUE * N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	num[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(0, 0);
        
        System.out.print(find());
	}
	public static void dfs(int index, int total) {
		if(index == N) return;
		for(int i = index; i < N; i++) {
			visited[num[i] + total] = true;
			dfs(i + 1, total + num[i]);
		}
		return;
	}
	public static int find() {
		for(int i = 1; i < MAX_VALUE * N; i++) {
			if(!visited[i]) return i;
		}
		return 0;
	}
}

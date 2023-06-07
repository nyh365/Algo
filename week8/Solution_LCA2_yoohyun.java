import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] tree;
	static int[] depth;
	static int[][] parent;
	static int dept, N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		//트리의 높이 계산
		dept = 1;
		while((1 << (dept - 1)) < N) dept++;
		
		depth = new int[N + 1];
		parent = new int[N + 1][dept];
		
		
		//트리 생성
		tree = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>(); 
		}
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
		
			tree[p].add(c);
			tree[c].add(p);
		}
		
		
		dfs(1,1);
		makeParent();
		
		M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
		
			sb.append(LCA(a,b)).append("\n");
		}
		System.out.println(sb);
	} 
	public static int LCA(int a, int b) {
		if(depth[a] < depth[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		for(int i = dept - 1; i >= 0; i--) {
			if(Math.pow(2, i) <= depth[a] - depth[b]) {
				a = parent[a][i];
			}
		}
		
		if(a == b) return a;
		
		for(int i = dept - 1; i >= 0; i--) {
			if(parent[a][i] != parent[b][i]) {
				a = parent[a][i];
				b = parent[b][i];
			}
		}
		return parent[a][0];
	}
	
	public static void makeParent() {
		for(int i = 1; i < dept; i++) {
			for(int j = 1; j <= N; j++) {
				parent[j][i] = parent[parent[j][i-1]][i-1];
			}
		}
	}
	public static void dfs(int cur, int cnt) {
		depth[cur] = cnt;
		
		for(Integer next : tree[cur]) {
			if(depth[next] == 0) {
				dfs(next, cnt + 1);
				parent[next][0] = cur;
			}
		}
		return;
	}
}





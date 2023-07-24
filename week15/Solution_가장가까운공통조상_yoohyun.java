import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {	
	static int[] parents, dept;
	static ArrayList<Integer>[] nodes;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int test_case = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= test_case; t++) {
			int N = Integer.parseInt(br.readLine());
			parents = new int[N + 1];
			dept = new int[N + 1];
			nodes = new ArrayList[N + 1];
			
			for(int i = 1; i <= N; i++) {
				nodes[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				
				parents[child] = parent;
				nodes[parent].add(child);
			}
			// root 구하기
			int root = -1;
			for(int i = 1; i <= N; i++) {
				if(parents[i] == 0) {
					root = i;
					break;
				}
			}
			// 깊이 구하기
			dfs(root, 1);
			
			// 공통 조상 구하기
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int result = findLCS(A, B);
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
	public static void dfs(int cur, int deep) {
		dept[cur] = deep;
		
		for(int child : nodes[cur]) {
			dfs(child, deep + 1);
		}
	}
	public static int findLCS(int A, int B) {
		int a = dept[A] <= dept[B] ? A : B; // 입력받은 인수 중 루트와 가장 가까운 노드
		int b = dept[A] <= dept[B] ? B : A;
		
		if(dept[a] != dept[b]) {
			int diff = dept[b] - dept[a];
			for(int i = 0; i < diff; i++) {
				b = parents[b];
			}
		}
		
		while(a != b) {
			a = parents[a];
			b = parents[b];
		}
		return a;
	}
}

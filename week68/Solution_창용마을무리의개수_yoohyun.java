import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		
		int N, M;
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			init(N);
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());

				union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			sb.append(getGroup(N)).append("\n");
		}
		System.out.print(sb);
	}
	public static void init(int N) {
		parent = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}
	public static int find(int a) {
		if(parent[a] == a) {
			return a;
		}
		
		return parent[a] = find(parent[a]);
	}
	
	public static void union(int a, int b) {
		int findA = find(a);
		int findB = find(b);
		
		if(findA != findB) {
			parent[findA] = findB;
		}
	}
	
	public static int getGroup(int N) {
		HashSet<Integer> set = new HashSet<>();
		for(int i = 1; i <= N; i++) {
			find(i);
			
			set.add(parent[i]);
		}
		return set.size();
	}
}

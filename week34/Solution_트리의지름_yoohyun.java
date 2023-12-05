import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {	
	public static ArrayList<Node>[] nodes;
	public static int max, maxIndex;
	public static boolean[] visited;
	public static class Node{
		int to, weight;

		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		nodes = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			nodes[i] = new ArrayList<>();
		}
		
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			nodes[from].add(new Node(to, weight));
			nodes[to].add(new Node(from, weight));
		}
		//1. 루트 노드를 기준으로 가장 먼 노드의 길이와 번호 구하기
		visited = new boolean[N + 1];
		visited[1] = true;
		max = Integer.MIN_VALUE; maxIndex = -1;
		dfs(1, 0);
		//1에서 구한 노드를 기준으로 다시 가장 먼 노드의 길이와 번호 구하기 
		visited = new boolean[N + 1];
		visited[maxIndex] = true;
		max = Integer.MIN_VALUE;
		dfs(maxIndex, 0);
		
		System.out.print(max);
	}
	public static void dfs(int parent, int length) {
		if(max < length) {
			max = length;
			maxIndex = parent;
		}
		for(int i = 0; i < nodes[parent].size(); i++) {
			Node node = nodes[parent].get(i);
			if(visited[node.to]) continue;
			visited[node.to] = true;
			dfs(node.to, length + node.weight);
		}
	}
}

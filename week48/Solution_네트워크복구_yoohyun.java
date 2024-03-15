import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static List<Node>[] adjList;
	static class Node implements Comparable<Node>{
		int vertex, weight;

		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[N + 1];
		for(int i = 0; i < N + 1; i++) {
			adjList[i] = new ArrayList<Node>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from].add(new Node(to, weight));
			adjList[to].add(new Node(from, weight));
		}
				
		int[] minWeight = new int[N + 1];
		boolean[] check = new boolean[N + 1];
		Arrays.fill(minWeight, Integer.MAX_VALUE);
		minWeight[1] = 0;
		
		PriorityQueue<Node> pQueue = new PriorityQueue<>();
		pQueue.offer(new Node(1, minWeight[1]));
		
		int[] route = new int[N + 1];
		int result = 0;
		while(!pQueue.isEmpty()) {
			Node cur = pQueue.poll();
			if(check[cur.vertex]) continue;
			check[cur.vertex] = true;
			int cnt = 0;
			if(++cnt == N) break;
			
			for(Node tmp : adjList[cur.vertex]) {
				if(!check[tmp.vertex] && minWeight[tmp.vertex] > minWeight[cur.vertex] + tmp.weight) {
					minWeight[tmp.vertex] = minWeight[cur.vertex] + tmp.weight;
					pQueue.offer(new Node(tmp.vertex, minWeight[tmp.vertex]));
					route[tmp.vertex] = cur.vertex;
				}
			}
		}
		
		for(int i = 2; i <= N; i++) {
			if(route[i] == 0) continue;
			result++;
			sb.append(i).append(" ").append(route[i]).append("\n");
		}
		
		System.out.print(result + "\n" + sb);
	}
	
}

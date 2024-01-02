import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V, E;
	static class Node implements Comparable<Node>{
		int vertex, weight;
		Node next;
		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}
		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		Node[] adjList = new Node[V + 1];
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to, weight, adjList[from]);
		}
		
		int[] minWeight = new int[V + 1];
		boolean[] check = new boolean[V + 1];
		Arrays.fill(minWeight, Integer.MAX_VALUE);
		minWeight[start] = 0;
		
		PriorityQueue<Node> pQueue = new PriorityQueue<>();
		pQueue.offer(new Node(start, minWeight[start]));
		int cnt = 0;
		
		while(!pQueue.isEmpty()) {
			Node minNode = pQueue.poll();
			if(check[minNode.vertex]) continue;
			check[minNode.vertex] = true;
			if(++cnt == V) break;
			
			for(Node tmp = adjList[minNode.vertex]; tmp != null; tmp = tmp.next) {
				if(!check[tmp.vertex] && minWeight[tmp.vertex] > minWeight[minNode.vertex] + tmp.weight) {
					minWeight[tmp.vertex] = minWeight[minNode.vertex] + tmp.weight;
					pQueue.offer(new Node(tmp.vertex, minWeight[tmp.vertex]));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= V; i++) {
			if(minWeight[i] != Integer.MAX_VALUE)
				sb.append(minWeight[i]).append("\n");
			else
				sb.append("INF").append("\n");
		}
		System.out.println(sb);
		
	}
}

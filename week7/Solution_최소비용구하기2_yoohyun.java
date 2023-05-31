import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
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
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		Node[] adjList = new Node[N + 1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			adjList[from] = new Node(to, weight, adjList[from]);
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int des = Integer.parseInt(st.nextToken());
		
		int[] minWeight = new int[N + 1];
		Arrays.fill(minWeight, Integer.MAX_VALUE);
		minWeight[start] = 0;
		boolean[] check = new boolean[N + 1];
		int cnt = 0;
		
		PriorityQueue<Node> pQueue = new PriorityQueue<>();
		pQueue.offer(new Node(start, minWeight[start]));
		Node[] route = new Node[N + 1];
		for(int i =  1; i <= N; i++) {
			route[i] = new Node(i, 0);
		}
		while(!pQueue.isEmpty()) {
			Node minNode = pQueue.poll();
			if(check[minNode.vertex]) continue;
			check[minNode.vertex] = true;
			if(++cnt == N) break;
			
			for(Node tmp = adjList[minNode.vertex]; tmp != null; tmp = tmp.next) {
				if(!check[tmp.vertex] && minWeight[tmp.vertex] > minWeight[minNode.vertex] + tmp.weight) {
					minWeight[tmp.vertex] = minWeight[minNode.vertex] + tmp.weight;
					pQueue.offer(new Node(tmp.vertex, minWeight[tmp.vertex]));
					route[tmp.vertex] = new Node(tmp.vertex, tmp.weight, route[minNode.vertex]);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(minWeight[des]).append("\n");
		int result = 0;
		StringBuilder sb2 = new StringBuilder();
		for(Node tmp = route[des]; tmp != null; tmp = tmp.next) {
			result++;
		}
		sb.append(result).append("\n");
		print_route(sb2, route[des]);
		sb.append(sb2);
		System.out.print(sb);
		
	}
	public static void print_route(StringBuilder sb, Node node) {
		if(node == null) return;
		print_route(sb, node.next);
		sb.append(node.vertex).append(" ");
	}
}

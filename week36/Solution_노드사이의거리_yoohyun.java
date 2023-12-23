import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {	
	public static class Node implements Comparable<Node>{
		int vertex, weight;
		Node next;
		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node node) {
			return Integer.compare(this.weight, node.weight);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Node[] nodes = new Node[N + 1];
		
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
		
			nodes[from] = new Node(to, weight, nodes[from]);
			nodes[to] = new Node(from, weight, nodes[to]);
		}
		int[][] minValue = new int[N + 1][N + 1];
		for(int i = 1; i <= N; i++) {
			boolean[] visited = new boolean[N + 1];
			Arrays.fill(minValue[i], Integer.MAX_VALUE);
			minValue[i][i] = 0;
			
			int cnt = 0;
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(i, minValue[i][i]));
			while(!pq.isEmpty()) {
				Node cur = pq.remove();
				if(visited[cur.vertex]) continue;
				visited[cur.vertex] = true;
				if(++cnt == N) break;
				
				for(Node tmp = nodes[cur.vertex]; tmp != null; tmp = tmp.next) {
					if(visited[tmp.vertex]) continue;
					if(minValue[i][tmp.vertex] > minValue[i][cur.vertex] + tmp.weight) {
						minValue[i][tmp.vertex] = minValue[i][cur.vertex] + tmp.weight;
						pq.add(new Node(tmp.vertex, minValue[i][tmp.vertex]));
					}
				}
				
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			sb.append(minValue[from][to]).append("\n");
		}
		
		System.out.print(sb);
	}
}

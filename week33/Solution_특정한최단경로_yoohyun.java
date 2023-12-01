import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, E;
	static final int INF = 200000000;
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
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		Node[] adjList = new Node[N + 1];
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
		
			adjList[from] = new Node(to, weight, adjList[from]);
			adjList[to] = new Node(from, weight, adjList[to]);
		}
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		int[][] minWeight = new int[N + 1][N + 1];
		
		for(int i = 1; i <= N; i++) {
			if(i == 1 || i == v1 || i == v2 || i == N) {
				Arrays.fill(minWeight[i], INF);
				boolean[] check = new boolean[N + 1];
				minWeight[i][i] = 0;
				int cnt = 0;
				
				PriorityQueue<Node> pQueue = new PriorityQueue<>();
				pQueue.offer(new Node(i, minWeight[i][i]));
				
				while(!pQueue.isEmpty()) {
					Node minNode = pQueue.poll();
					if(check[minNode.vertex]) continue;
					check[minNode.vertex] = true;
					if(++cnt == N) break;
					
					for(Node tmp = adjList[minNode.vertex]; tmp != null; tmp = tmp.next) {
						if(!check[tmp.vertex] && minWeight[i][tmp.vertex] > minWeight[i][minNode.vertex] + tmp.weight) {
							minWeight[i][tmp.vertex] = minWeight[i][minNode.vertex] + tmp.weight;
							pQueue.offer(new Node(tmp.vertex, minWeight[i][tmp.vertex]));
						}
					}
				}
			}
		}
		int result = Math.min(minWeight[1][v1] + minWeight[v1][v2] + minWeight[v2][N], minWeight[1][v2] + minWeight[v2][v1] + minWeight[v1][N]);
		System.out.println(result >= INF ? -1 : result);
	}
}

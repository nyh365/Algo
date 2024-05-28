import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
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
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
	
		Node[] adjList = new Node[V + 1];
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to, weight, adjList[from]);
			adjList[to] = new Node(from, weight, adjList[to]);
		}
		
		boolean[] visited = new boolean[V + 1];	
		int result = 0;
		int cnt = 0;
		PriorityQueue<Node> pQueue = new PriorityQueue<>();
		pQueue.offer(new Node(1,0));
		
		while(true) {
			
			Node minNode = pQueue.poll();
			if(visited[minNode.vertex]) continue;
			visited[minNode.vertex] = true;
			result += minNode.weight;
			if(++cnt == V) break;
			
			for(Node tmp = adjList[minNode.vertex]; tmp != null; tmp = tmp.next) {
				if(!visited[tmp.vertex]) {
					pQueue.offer(new Node(tmp.vertex, tmp.weight));
				}				
			}
			
		}
		System.out.println(result);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main{
	static class Node implements Comparable<Node> {
		int vertex, cost;
		Node next;
		
		public Node(int vertex, int cost, Node next){
			this.vertex = vertex;
			this.cost = cost;
			this.next = next;
		}
		
		public Node(int vertex, int cost){
			this.vertex = vertex;
			this.cost = cost;
		}
		public int compareTo(Node node) {
			return Integer.compare(this.cost, node.cost);
		}
	}
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());

    	Node[] edges = new Node[N + 1];
    	
    	int from, to, cost;
    	for(int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		from = Integer.parseInt(st.nextToken());
    		to = Integer.parseInt(st.nextToken());
    		cost = Integer.parseInt(st.nextToken());
   
    		edges[from] = new Node(to, cost, edges[from]);
    		edges[to] = new Node(from, cost, edges[to]);
    	}

    	st = new StringTokenizer(br.readLine());
    	int s = Integer.parseInt(st.nextToken());
    	int t = Integer.parseInt(st.nextToken());
    	
    	
    	
    	System.out.print(dijkstra(N, s, t, edges));
	}
	
	public static int dijkstra(int N, int start, int des, Node[] edges) {
		boolean[] visited = new boolean[N + 1];
		int[] minValue = new int[N + 1];
		
		Arrays.fill(minValue, Integer.MAX_VALUE);
		
		minValue[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, minValue[start]));
		
		Node cur;
		int cnt = 0;
		while(!pq.isEmpty()) {
			cur = pq.remove();
			
			if(visited[cur.vertex]) continue;
			visited[cur.vertex] = true;
			
			if(++cnt == N) break;
			
			for(Node temp = edges[cur.vertex]; temp != null; temp = temp.next) {
				if(visited[temp.vertex]) continue;

				if(minValue[cur.vertex] + temp.cost < minValue[temp.vertex]) {
					minValue[temp.vertex] = minValue[cur.vertex] + temp.cost;
					pq.add(new Node(temp.vertex, minValue[temp.vertex]));
				}
			}
		}
		return minValue[des];
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main{
	static int MAX_VALUE; 
	static class Node implements Comparable<Node> {
		int vertex;
		long cost;
		Node next;
		
		public Node(int vertex, long cost, Node next){
			this.vertex = vertex;
			this.cost = cost;
			this.next = next;
		}
		
		public Node(int vertex, long cost){
			this.vertex = vertex;
			this.cost = cost;
		}
		public int compareTo(Node node) {
			return Long.compare(this.cost, node.cost);
		}
	}
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int A = Integer.parseInt(st.nextToken());
    	int B = Integer.parseInt(st.nextToken());
    	long C = Long.parseLong(st.nextToken());

    	Node[] edges = new Node[N + 1];
    	
    	int from, to, cost;
    	for(int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		from = Integer.parseInt(st.nextToken());
    		to = Integer.parseInt(st.nextToken());
    		cost = Integer.parseInt(st.nextToken());
   
    		MAX_VALUE = Math.max(MAX_VALUE, cost);
    		
    		edges[from] = new Node(to, cost, edges[from]);
    		edges[to] = new Node(from, cost, edges[to]);
    	}
    	
    	System.out.print(binaraySearch(N, A, B, C, edges));
	}
	public static int binaraySearch(int N, int A, int B, long C, Node[] edges) {
		int start = 1;
		int end = MAX_VALUE;
		
		int mid;
		int result = -1;
		while(start <= end) {
			mid = (start + end) / 2;
			
			if(dijkstra(N, A, B, C, edges, mid)) {
				end = mid - 1;
				result = mid;
			} else {
				start = mid + 1;
			}
		}
		return result;
	}
	
	public static boolean dijkstra(int N, int start, int des, long budget, Node[] edges, int target) {
		boolean[] visited = new boolean[N + 1];
		long[] minValue = new long[N + 1];
		
		Arrays.fill(minValue, Long.MAX_VALUE);
		
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
				if(temp.cost > target) continue;
				if(minValue[cur.vertex] + temp.cost > budget) continue;

				if(minValue[cur.vertex] + temp.cost < minValue[temp.vertex]) {
					minValue[temp.vertex] = minValue[cur.vertex] + temp.cost;
					pq.add(new Node(temp.vertex, minValue[temp.vertex]));
				}
			}
		}
		return minValue[des] <= budget;
	}
}

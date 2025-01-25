import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static Node[] nodes;
	static class Node implements Comparable<Node> {
		int vertex, weight;
		Node next;
		
		public Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
		
		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
		
		public int compareTo(Node next) {
			return Long.compare(this.weight, next.weight);
		}
	}
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        nodes = new Node[V + 1];
        
        for(int i = 0; i < E; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        
        	nodes[a] = new Node(b, c, nodes[a]);
        	nodes[b] = new Node(a, c, nodes[b]);
        }
        
        int minDistance = dijkstra(V, 1)[V];
        int[] distanceP = dijkstra(V, P);
        if(minDistance == distanceP[V] + distanceP[1]) {
        	System.out.println("SAVE HIM");
        } else {
        	System.out.println("GOOD BYE");
        }
    }
	
	public static int[] dijkstra(int V, int start) {
		int[] minValue = new int[V + 1];
		Arrays.fill(minValue, Integer.MAX_VALUE);
		
		boolean[] visited = new boolean[V + 1];
		minValue[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, minValue[start]));
				
		int cnt = 0;
		Node cur;
		while(!pq.isEmpty()) {
			cur = pq.remove();
			
			if(visited[cur.vertex]) continue;
			visited[cur.vertex] = true;
			
			if(++cnt == V + 1) break;
			
			for(Node tmp = nodes[cur.vertex]; tmp != null; tmp = tmp.next) {
				if(visited[tmp.vertex]) continue;
				if(minValue[cur.vertex] + tmp.weight >= minValue[tmp.vertex]) continue;
				
				minValue[tmp.vertex] = minValue[cur.vertex] + tmp.weight;
				pq.add(new Node(tmp.vertex, minValue[tmp.vertex]));
			}
		}	
		
		return minValue;
	}
}

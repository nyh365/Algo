import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static Node[] nodes;
	static int size = 10000;
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
			return Integer.compare(this.weight, next.weight);
		}
	}
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        
        nodes = new Node[size + 1];
        for(int i = 0; i < size; i++) {
        	nodes[i] = new Node(i + 1, 1, nodes[i]);
        }
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	int distance = Integer.parseInt(st.nextToken());
        
        	nodes[from] = new Node(to, distance, nodes[from]);
        }
        
        System.out.println(dijkstra(D));
    }
	
	public static int dijkstra(int D) {
		int[] minValue = new int[size + 1];
		Arrays.fill(minValue, Integer.MAX_VALUE);
		boolean[] visited = new boolean[size + 1];
		
		minValue[0] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, minValue[0]));
		
		Node cur;
		while(!pq.isEmpty()) {
			cur = pq.remove();
			
			if(visited[cur.vertex]) continue;
			visited[cur.vertex] = true;
			
			for(Node tmp = nodes[cur.vertex]; tmp != null; tmp = tmp.next) {
				if(visited[tmp.vertex]) continue;
				if(minValue[cur.vertex] + tmp.weight >= minValue[tmp.vertex]) continue;
				
				minValue[tmp.vertex] = minValue[cur.vertex] + tmp.weight;
				pq.add(new Node(tmp.vertex, minValue[tmp.vertex]));
			}
		}
		return minValue[D];
	}
}

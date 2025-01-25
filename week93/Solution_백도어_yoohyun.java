import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static Node[] nodes;
	static boolean[] isVisible;
	static class Node implements Comparable<Node> {
		int vertex;
		long weight;
		Node next;
		
		public Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
		
		public Node(int vertex, long weight) {
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
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        nodes = new Node[N];
        isVisible = new boolean[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	isVisible[i] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
        }
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int t = Integer.parseInt(st.nextToken());
        
        	nodes[a] = new Node(b, t, nodes[a]);
        	nodes[b] = new Node(a, t, nodes[b]);
        }
        
        System.out.println(dijkstra(N));
    }
	
	public static long dijkstra(int N) {
		long[] minValue = new long[N];
		Arrays.fill(minValue, Long.MAX_VALUE);
		
		boolean[] visited = new boolean[N];
		minValue[0] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, minValue[0]));
				
		int cnt = 0;
		Node cur;
		while(!pq.isEmpty()) {
			cur = pq.remove();
			
			if(visited[cur.vertex]) continue;
			visited[cur.vertex] = true;
			
			if(++cnt == N) break;
			
			for(Node tmp = nodes[cur.vertex]; tmp != null; tmp = tmp.next) {
				if(visited[tmp.vertex]) continue;
				if(tmp.vertex != N - 1 && isVisible[tmp.vertex]) continue;

				if(minValue[cur.vertex] + tmp.weight >= minValue[tmp.vertex]) continue;
				
				minValue[tmp.vertex] = minValue[cur.vertex] + tmp.weight;
				pq.add(new Node(tmp.vertex, minValue[tmp.vertex]));
			}
		}	
		
		return minValue[N - 1] == Long.MAX_VALUE ? -1 : minValue[N - 1];
	}
	
}

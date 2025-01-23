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
			return Integer.compare(this.weight, next.weight);
		}
	}
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        nodes = new Node[N + 1];
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int A = Integer.parseInt(st.nextToken());
        	int B = Integer.parseInt(st.nextToken());
        
        
        	nodes[A] = new Node(B, 1, nodes[A]);
        }
        
        dijkstra(N, K, X);
    }
	
	public static void dijkstra(int N, int K, int X) {
		StringBuilder sb = new StringBuilder();
		
		int[] minValue = new int[N + 1];
		Arrays.fill(minValue, Integer.MAX_VALUE);
		boolean[] visited = new boolean[N + 1];
		
		minValue[X] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(X, minValue[X]));
		
		int cnt = 0;
		Node cur;
		while(!pq.isEmpty()) {
			cur = pq.remove();
			
			if(visited[cur.vertex]) continue;
			visited[cur.vertex] = true;
			
			if(++cnt == N) break;
			
			for(Node tmp = nodes[cur.vertex]; tmp != null; tmp = tmp.next) {
				if(visited[tmp.vertex]) continue;
				if(minValue[cur.vertex] + tmp.weight >= minValue[tmp.vertex]) continue;
				
				minValue[tmp.vertex] = minValue[cur.vertex] + tmp.weight;
				pq.add(new Node(tmp.vertex, minValue[tmp.vertex]));
				
			}
		}
		
		int result = 0;
		for(int i = 1; i <= N; i++) {
			if(minValue[i] == K) {
				result++;
				sb.append(i).append("\n");
			}
		}
		
		if(result == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sb);
		}	
	}
}

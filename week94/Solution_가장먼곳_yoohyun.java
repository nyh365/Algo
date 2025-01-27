import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static Node[] nodes;
	static int N;
	public static class Node implements Comparable<Node> {
		int vertex, weight;
		Node next;
		
		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		public Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}

		@Override
		public int compareTo(Node node) {
			return Integer.compare(this.weight, node.weight);
		}
		
	}
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        nodes = new Node[N + 1];
        
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
    
        
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            
            nodes[D] = new Node(E, L, nodes[D]);
            nodes[E] = new Node(D, L, nodes[E]);
        }
        
        System.out.print(dijkstra(new int[] {A, B, C}));
	}
	public static int dijkstra(int[] start) {
		int[] candidate = new int[N + 1];
		
		for(int i = 0; i < 3; i++) {
			boolean[] visited = new boolean[N + 1];
			int[] minValue = new int[N + 1];
			Arrays.fill(minValue, Integer.MAX_VALUE);
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			
			minValue[start[i]] = 0;
			pq.add(new Node(start[i], minValue[start[i]]));
			
			Node cur;
			int cnt = 0;
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
			
			for(int k = 1; k <= N; k++) {
				if(i == 0) {
					candidate[k] = minValue[k];
				} else {
					if(candidate[k] == Integer.MAX_VALUE) continue;
					if(minValue[k] == Integer.MAX_VALUE) {
						candidate[k] = Integer.MAX_VALUE;	
					} else {
						candidate[k] = Math.min(candidate[k], minValue[k]);
					}
				}
			}
		}
		
		int result = Integer.MIN_VALUE;
		int number = -1;
		for(int i = 1; i <= N; i++) {
			if(candidate[i] == Integer.MAX_VALUE) continue;
			if(result < candidate[i]) {
				result = candidate[i];
				number = i;
			}
		}
		
		return number;
	}
}

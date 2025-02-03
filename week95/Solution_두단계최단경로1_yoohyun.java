import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static Node[] nodes;
	static int N, M, X, Y, Z;
	static class Node implements Comparable<Node> {
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

		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        nodes = new Node[N + 1];

        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int u = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	int w = Integer.parseInt(st.nextToken());
        	
        	nodes[u] = new Node(v, w, nodes[u]); 
        }
        
        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        Z = Integer.parseInt(st.nextToken());
        
        int distanceXY = dijkstra(X, Y, X); 
        int distanceYZ = dijkstra(Y, Z, Y);
        int directZ = dijkstra(X, Z, Y);
        
        System.out.print(distanceXY == Integer.MAX_VALUE || distanceYZ == Integer.MAX_VALUE ? -1 : (distanceXY + distanceYZ));
        System.out.print(" " + (directZ == Integer.MAX_VALUE ? -1 : directZ));
	}
	
	public static int dijkstra(int start, int des, int visit) {
        int cnt = 0;
		boolean[] visited = new boolean[N + 1];
		if(visit != start) {
			visited[visit] = true;
		}
		
        int[] minValue = new int[N + 1];
        Arrays.fill(minValue, Integer.MAX_VALUE);
        
        minValue[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, minValue[start]));
        
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
        
        return minValue[des];
	}
}

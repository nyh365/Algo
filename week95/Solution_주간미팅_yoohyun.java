import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static Node[] nodes;
	static int[] houses;
	static int N, V, E, A, B;
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
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        nodes = new Node[V + 1];
        
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        
        houses = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	houses[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < E; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int l = Integer.parseInt(st.nextToken());
        	
        	nodes[a] = new Node(b, l, nodes[a]); 
        	nodes[b] = new Node(a, l, nodes[b]); 
        }
        
        int[] KIST = dijkstra(A);
        int[] CRFOOD = dijkstra(B);
        
        int result = 0;
        
        for(int house: houses) {
        	result += (KIST[house] == Integer.MAX_VALUE ? -1 : KIST[house]);
        	result += (CRFOOD[house] == Integer.MAX_VALUE ? -1 : CRFOOD[house]);
        }
        System.out.println(result);
	}
	public static int[] dijkstra(int start) {
        int cnt = 0;
		boolean[] visited = new boolean[V + 1];
        int[] minValue = new int[V + 1];
        Arrays.fill(minValue, Integer.MAX_VALUE);
        
        minValue[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, minValue[start]));
        
        Node cur;
        while(!pq.isEmpty()) {
    		cur = pq.remove();
    		
    		if(visited[cur.vertex]) continue;
    		visited[cur.vertex] = true;
    		
    		if(++cnt == V) break;
    		
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

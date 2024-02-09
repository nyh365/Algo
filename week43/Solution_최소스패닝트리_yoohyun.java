import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main{
	static ArrayList<Node>[] edges;
	public static class Node implements Comparable<Node> {
		int to, cost;

		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int V = Integer.parseInt(st.nextToken());
    	int E = Integer.parseInt(st.nextToken());
    	
    	edges = new ArrayList[V + 1];
    	for(int i = 0; i <= V; i++) {
    		edges[i] = new ArrayList<>();
    	}
    	
    	int from, to, cost;
    	for(int i = 0; i < E; i++) {
    		st = new StringTokenizer(br.readLine());
    		from = Integer.parseInt(st.nextToken());
    		to = Integer.parseInt(st.nextToken());
    		cost = Integer.parseInt(st.nextToken());
    	
    		edges[from].add(new Node(to, cost));
    		edges[to].add(new Node(from, cost));
    	}
    	
    	boolean[] visited = new boolean[V + 1];
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	pq.add(new Node(1,0));
    	
    	Node cur;
    	int result = 0;
    	while(!pq.isEmpty()) {
    		cur = pq.remove();
    	
    		if(visited[cur.to]) continue;
    		visited[cur.to] = true;
    		result += cur.cost;
    		
    		for(Node next : edges[cur.to]) {
    			if(visited[next.to]) continue;
    			
    			pq.add(next);
    		}
    	}
    	System.out.print(result);
    }
}

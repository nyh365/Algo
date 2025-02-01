import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static Node[] nodes;
	static int N, M, X, Y;
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
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        
        nodes = new Node[N];

        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	int weight = Integer.parseInt(st.nextToken());
        	
        	nodes[from] = new Node(to, weight, nodes[from]); 
        	nodes[to] = new Node(from, weight, nodes[to]); 
        }
        
        System.out.print(dijkstra());
	}
	
	public static int dijkstra() {
        int result = 0, cnt = 0;
		boolean[] visited = new boolean[N];
        int[] minValue = new int[N];
        Arrays.fill(minValue, Integer.MAX_VALUE);
        minValue[Y] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(Y, minValue[Y]));
        
        int totalDis = 0;
        while(!pq.isEmpty() && cnt != N) {
        	result++;
        	
        	Node cur;
        	totalDis = 0;
        	while(!pq.isEmpty()) {
        		cur = pq.remove();
        		
        		if(visited[cur.vertex]) continue;
        		if(totalDis + 2 * cur.weight > X) {
        			if(totalDis != 0) {
        				pq.add(cur);
        			}
        			
        			break;
        		}
        		
        		totalDis += 2 * cur.weight;
        		visited[cur.vertex] = true;
        		
        		if(++cnt == N) break;
        		
        		for(Node tmp = nodes[cur.vertex]; tmp != null; tmp = tmp.next) {
        			if(visited[tmp.vertex]) continue;
        			if(minValue[cur.vertex] + tmp.weight >= minValue[tmp.vertex]) continue;
        			
        			minValue[tmp.vertex] = minValue[cur.vertex] + tmp.weight;
        			
        			pq.add(new Node(tmp.vertex, minValue[tmp.vertex]));
        		}
        	}
        }
        
        return cnt != N ? -1 : result;
	}
}

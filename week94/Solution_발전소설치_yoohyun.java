import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static double[][] nodes;
	static int[][] locs;
	static int N, W;
	static double M;
	static class Node implements Comparable<Node> {
		int vertex;
		double distance;
		
		public Node(int vertex, double distance) {
			this.vertex = vertex;
			this.distance = distance;
		}

		public int compareTo(Node o) {
			return Double.compare(this.distance, o.distance);
		}
	}
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        
        locs = new int[N + 1][2];
        
        M = Double.parseDouble(br.readLine()); 
        
        for(int i = 1; i <= N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        
        	locs[i][0] = x; 
        	locs[i][1] = y; 
        }
        
        nodes = new double[N + 1][N + 1];
        
        for(int i = 1; i <= W; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	
	    	int from = Integer.parseInt(st.nextToken());
	    	int to = Integer.parseInt(st.nextToken());
        
	    	nodes[from][to] = 1;
	    	nodes[to][from] = 1;
        }
        
        System.out.println(dijkstra());
	}
	
	public static int dijkstra() {
        boolean[] visited = new boolean[N + 1];
        double[] minValue = new double[N + 1];
        
        Arrays.fill(minValue, Double.MAX_VALUE);
        
        minValue[1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, minValue[1]));
        
        Node cur;
        int cnt = 0;
        while(!pq.isEmpty()) {
        	cur = pq.remove();
        	
        	if(visited[cur.vertex]) continue;
        	visited[cur.vertex] = true;
        	
        	if(++cnt == N) break;
        	
        	for(int i = 1; i <= N; i++) {
        		if(cur.vertex == i) continue;
        		if(visited[i]) continue;
        		
        		double dis = Math.sqrt(Math.pow(locs[cur.vertex][0] - locs[i][0], 2) + Math.pow(locs[cur.vertex][1] - locs[i][1], 2) );
        		
        		if(minValue[cur.vertex] + dis >= minValue[i]) continue;
        		minValue[i] = minValue[cur.vertex] + dis;
        		
        		pq.add(new Node(i, minValue[i]));
        	}
        	
        }
        
        return (minValue[N] * 1000) / 1000;
	}
}

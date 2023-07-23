import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static class Node implements Comparable<Node>{
		int vertex, cost;
		Node next;
		
		
		public Node(int vertex, int cost) {
			super();
			this.vertex = vertex;
			this.cost = cost;
		}

		public Node(int vertex, int cost, Node next) {
			super();
			this.vertex = vertex;
			this.cost = cost;
			this.next = next;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	public static void main(String args[]) throws Exception{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     StringTokenizer st;
	     StringBuilder sb = new StringBuilder();
	     for(int test_case = 1; (N = Integer.parseInt(br.readLine())) != 0; test_case++) {
	    	 int[][] cave = new int[N][N];
	    	 
	    	 for(int i = 0; i < N; i++) {
	    		 st = new StringTokenizer(br.readLine());
	    		 for(int j = 0; j < N; j++) {
	    			 cave[i][j] = Integer.parseInt(st.nextToken());
	    		 }
	    	 }
	    	 Node[] node = new Node[N * N];
	    	 
	    	 for(int i = 0 ; i < N; i++) {
	    		 for(int j = 0; j < N; j++) {
	    			 int index = N * i + j;
	    			 for(int k = 0; k < 4; k++) {
	    				 int x = j + dx[k];
	    				 int y = i + dy[k];
	    				 if(x >= 0 && x < N && y >= 0 && y < N) {
	    					 node[index] = new Node(N * y + x, cave[y][x], node[index]);
	    				 }
	    			 }
	    		 }
	    	 }
	    	 
	    	 int start = 0;
	    	 int[] minValue = new int[N * N];
	    	 Arrays.fill(minValue, Integer.MAX_VALUE);
	    	 boolean check[] = new boolean[N * N];
	    	 minValue[start] = cave[0][0];
	    	 PriorityQueue<Node> pQueue = new PriorityQueue<>();
	    	 pQueue.offer(new Node(start, minValue[start]));
	    	 int cnt = 0;
	    	 while(true) {
	    		 Node current = pQueue.poll();
	    		 
	    		 if(check[current.vertex]) continue;
	    		 check[current.vertex] = true;
	    		 if(++cnt == N * N - 1) break;
	    		 
	    		 
	    		 for(Node tmp = node[current.vertex]; tmp != null; tmp = tmp.next) {
	    			if(!check[tmp.vertex] && minValue[tmp.vertex] > minValue[current.vertex] + tmp.cost) {
	    				minValue[tmp.vertex] = minValue[current.vertex] + tmp.cost;
	    				pQueue.offer(new Node(tmp.vertex, minValue[tmp.vertex]));
	    			} 
	    		 }
	    	 }
	    	 sb.append("Problem ").append(test_case).append(": ").append(minValue[N * N -1]).append("\n");
	     }
	     System.out.println(sb);
	}
}

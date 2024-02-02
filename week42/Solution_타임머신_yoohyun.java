import java.util.*;
import java.lang.*;
import java.io.*;
 
public class Main{
	public static class Node{
		int from, to, weight;

		public Node(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine());

    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	LinkedList<Node> edge = new LinkedList<>();
    	
    	int A, B, C;
    	for(int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		A = Integer.parseInt(st.nextToken());
    		B = Integer.parseInt(st.nextToken());
    		C = Integer.parseInt(st.nextToken());
    		
    		edge.add(new Node(A, B, C));
    	}
    	
    	long[] minValue = new long[N + 1];
    	Arrays.fill(minValue, Long.MAX_VALUE);
    	minValue[1] = 0;
    	
    	boolean cycle = false;
    	for(int i = 1; i <= N; i++) {
    		for(Node cur : edge) {
    			if(minValue[cur.from] == Long.MAX_VALUE) continue;
    			if(minValue[cur.from] + cur.weight < minValue[cur.to]) {
    				minValue[cur.to] = Math.min(minValue[cur.from] + cur.weight, minValue[cur.to]);
    				if(i == N) {
    					cycle = true;
    				}
    			}
    		}
    	}
    	
    	if(cycle) {
    		sb.append(-1);
    	} else {
    		for(int i = 2; i <= N; i++) {
    			sb.append(minValue[i] == Long.MAX_VALUE ? -1 : minValue[i]).append("\n");
    		}
    	}
    	
    	System.out.print(sb);
    }
}

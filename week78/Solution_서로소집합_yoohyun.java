import java.io.*;
import java.util.*;

public class Solution {
	static Node[] nodes;
	static int N;
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	int T = Integer.parseInt(br.readLine());
    	for(int test_case = 1; test_case <= T; test_case++) {
    		sb.append("#").append(test_case).append(" ");
    		st = new StringTokenizer(br.readLine());
    		N = Integer.parseInt(st.nextToken());
    		int M = Integer.parseInt(st.nextToken());
    		nodes = new Node[N + 1];
    		make();
    		
    		for(int i = 0; i < M; i++) {
    			st = new StringTokenizer(br.readLine());
    			int order = Integer.parseInt(st.nextToken());
    			int a = Integer.parseInt(st.nextToken());
    			int b = Integer.parseInt(st.nextToken());
    			if(order == 0) {
    				union(a,b);
    			}
    			else {
    				if(find(a) == find(b)) sb.append("1");
    				else sb.append("0");
    			}
    		}
    		sb.append("\n");
    	}
    	System.out.println(sb);
    }
	public static void make() {
		for(int i = 1; i <= N; i++) {
			nodes[i] = new Node(i);
		}
	}
	public static void union(int a, int b) {
		if(find(a) != find(b)) {
			nodes[find(b)].parent = nodes[a].parent;
		}
	}
	
	public static int find(int a){
		if(nodes[a].parent == a) {
			return a;
		}
		else {
			return nodes[a].parent = find(nodes[a].parent);
		}
	}
	
	
}
class Node{
	int parent;

	public Node(int parent) {
		super();
		this.parent = parent;
	}
}

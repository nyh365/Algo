import java.util.*;
import java.lang.*;
import java.io.*;
 
public class Main{
	static int[] parents;
	public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	parents = new int[N + 1];
    	init();
    	
    	int op, a, b;
    	for(int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		op = Integer.parseInt(st.nextToken());
    		a = Integer.parseInt(st.nextToken());
    		b = Integer.parseInt(st.nextToken());
    	
    		switch(op) {
    			case 0 :
    				union(a,b);
    				break;
    			case 1 :
    				sb.append(find(parents[a]) == find(parents[b]) ? "YES" : "NO").append("\n");
    		}
    	}
    	System.out.print(sb);
    }
	public static void init() {
		int size = parents.length;
		for(int i = 0; i < size; i++) {
			parents[i] = i;
		}
	}
	public static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	public static boolean union(int a, int b) {
		int findA = find(a);
		int findB = find(b);
		
		if(findA == findB) return false;
		
		parents[findB] = findA;
		return true;
	}
}

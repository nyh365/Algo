import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;
 
public class Main{
	static int[] parents;
	static int[][] gods;
	public static class God implements Comparable<God>{
		int from, to;
		double distance;

		public God(int from, int to, double distance) {
			this.from = from;
			this.to = to;
			this.distance = distance;
		}
		
		public int compareTo(God god) {
			return Double.compare(this.distance, god.distance);
		}
	}
	public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
   
    	init(N);
    	
    	double result = 0;
    	for(int i = 1; i <= N; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		gods[i][0] = Integer.parseInt(st.nextToken());
    		gods[i][1] = Integer.parseInt(st.nextToken());
    	}
   
    	int cnt = 0;
    	for(int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		int A = Integer.parseInt(st.nextToken());
        	int B = Integer.parseInt(st.nextToken());
    	
        	if(union(A, B)) cnt++;
    	}
    	
    	LinkedList<God> disList = new LinkedList<>();
    	for(int i = 1; i <= N; i++) {
    		for(int j = i + 1; j <= N; j++) {
    			disList.add(new God(i, j, getDistance(gods[i], gods[j])));
    		}
    	}
    	
    	Collections.sort(disList);
    	for(God god : disList) {
    		if(cnt == N - 1) break;
    		if(!union(god.from, god.to)) continue;
    		result += god.distance;
    	}
    	System.out.printf("%.2f",result);
    }
	public static void init(int N) {
		parents = new int[N + 1];
		gods = new int[N + 1][2];
		for(int i = 1; i <= N; i++) {
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
	
	public static double getDistance(int[] a, int[] b) {
		return Math.sqrt(Math.pow(Math.abs(a[0] - b[0]), 2) + Math.pow(Math.abs(a[1] - b[1]), 2));
	}
}

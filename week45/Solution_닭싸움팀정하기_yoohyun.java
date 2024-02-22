import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
 
public class Main{
	static int[] friends;
	static ArrayList<Integer>[] enemies;
	public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	int M = Integer.parseInt(br.readLine());
    	
    	init(N);
    	
    	String[] input;
    	int A, B;
    	for(int i = 0; i < M; i++) {
    		input = br.readLine().split(" ");
    		A = Integer.parseInt(input[1]);
    		B = Integer.parseInt(input[2]);
    		if("F".equals(input[0])){
    			union(A, B);
    		} else {
    			enemies[A].add(B);
    			enemies[B].add(A);
    		}
    	}
    	
    	findFriends(N);
    	
    	System.out.print(countTeam(N));
    }
	public static void init(int N) {
		friends = new int[N + 1];
		enemies = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			friends[i] = i;
			enemies[i] = new ArrayList<>();
		}
	}
	public static int find(int A) {
		if(friends[A] == A) return A;
		
		return friends[A] = find(friends[A]);
	}
	public static void union(int A, int B) {
		int findA = find(A);
		int findB = find(B);
		
		if(findA == findB) return;
		
		friends[findB] = findA;
	}
	public static void findFriends(int N) {
		int size;
		for(int i = 1; i <= N; i++) {
			size = enemies[i].size();
			for(int j = 1; j < size; j++) {
				union(enemies[i].get(0), enemies[i].get(j));
			}
		}
	}
	public static int countTeam(int N) {
		HashSet<Integer> set = new HashSet<>();
		for(int i = 1; i <= N; i++) {
			find(i);
			set.add(friends[i]);
		}
		return set.size();
	}
}

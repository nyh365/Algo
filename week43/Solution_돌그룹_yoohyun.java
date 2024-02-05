import java.util.*;
import java.lang.*;
import java.io.*;
 
public class Main{
	static int total, result;
	static boolean[][] visited;
	public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int A = Integer.parseInt(st.nextToken());
    	int B = Integer.parseInt(st.nextToken());
    	int C = Integer.parseInt(st.nextToken());
    	
    	total = A + B + C;
    	result = 0;
    	
    	if(total % 3 != 0) {
    		result = 0;
    	} else {
    		visited = new boolean[1501][1501];
    		dfs(A, B, C);
    	}
    	System.out.print(result);
    }
	public static void dfs(int A, int B, int C) {
		if(A == B && B == C) {
			result = 1;
			return;
		}
		
		makeStone(A, B, C);
		makeStone(A, C, B);
		makeStone(B, C, A);
	}
	
	public static void makeStone(int A, int B, int C) {
		int min = Math.min(A, B) * 2;
		int max = Math.max(A, B) - Math.min(A, B);
		
		if(!visited[min][max]){
			visited[min][max] = true;
			visited[max][min] = true;
			dfs(min, max, C);
		}
	}
}

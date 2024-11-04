import java.util.*;
import java.io.*;

public class Solution {
    static int result;
    static int N;
    static int[] weight;
    static int total;
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	int T = Integer.parseInt(br.readLine());
    	for(int test_case = 1; test_case <= T; test_case++) {
    		sb.append("#").append(test_case).append(" ");
    		N = Integer.parseInt(br.readLine());
    		weight = new int[N];
    		result = 0;
    		total = 0;
    		st = new StringTokenizer(br.readLine());
    		for(int i = 0; i < N; i++) {
    			weight[i] = Integer.parseInt(st.nextToken());
    			total += weight[i];
    		}
    		dfs(0, 0, 0, 0);
    		sb.append(result).append("\n");
    	}
    	System.out.println(sb);
    }
	public static void dfs(int count, int visit, int left_s, int right_s) {
		if(left_s < right_s) return;
		
		if(count == N) {
			result++;
			return;
		}
		
		if(left_s >= total / 2.0) {
			int left_count = 0;
			for(int i = 0; i < N; i++) {
				if((visit & 1 << i) > 0)
					left_count++;
			}
			int sum = 1;
			for(int i = N - left_count; i > 0; i--) {
				sum *= i;
			}
			result += (sum * Math.pow(2, N-left_count));
			return;
		}
		
		
		for(int i = 0; i < N; i++) {
			if((visit & 1 << i) > 0) continue;
			dfs(count + 1, visit | 1 << i, left_s + weight[i], right_s);
			dfs(count + 1, visit | 1 << i, left_s, right_s + weight[i]);
		}
	}
}

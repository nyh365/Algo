import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			int N = Integer.parseInt(br.readLine());
			int arr[] = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			for(int i = 0; i < N ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int result = 0;
			for(int i = 2; i <= N - 1- 2; i++) {
				int max = arr[i-2];
				max = Math.max(max, arr[i-1]);
				max = Math.max(max, arr[i+1]);
				max = Math.max(max, arr[i+2]);
				
				if(max < arr[i])
					result += arr[i] - max; 
			}
			sb.append(result).append("\n");
		}
		System.out.print(sb);
	}
}

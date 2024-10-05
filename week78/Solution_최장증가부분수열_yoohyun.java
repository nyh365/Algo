import java.util.*;
import java.io.*;

class Solution{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			int N = Integer.parseInt(br.readLine());
			int arr[] = new int[N];
			int memo[] = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int result = 0;
			for(int i = 0; i < N; i++) {
				memo[i] = 1;
                for(int j = 0; j < i; j++) {
					if(arr[i] >= arr[j] && memo[j] + 1 > memo[i])
						memo[i] = memo[j] + 1;
				}
                result = Math.max(result,memo[i]);
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}

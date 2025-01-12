import java.util.*;
import java.io.*;

class Solution
{
	static int total = 362880;
	static int A[] = new int[9];
	static int B[] = new int[9];
	static int result = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			boolean[] check = new boolean[19];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 9; i++) {
				A[i] = Integer.parseInt(st.nextToken());
				check[A[i]] = true;
			}
			int cnt = 0;
			for(int i = 1; i < 19; i++) {
				if(!check[i])
					B[cnt++] = i; 
			}
			result = 0;
			dfs(0, 9);
			sb.append(result).append(" ").append(total - result).append("\n");
		}
		System.out.print(sb);
	}
	public static void dfs(int start, int N) {
		if(start == N) {
			int sumA = 0, sumB = 0;
			for(int i = 0; i < 9; i++) {
				if(A[i] > B[i]) sumA += (A[i] + B[i]);
				else sumB += (B[i] + A[i]);
			}
			if(sumA > sumB) result++;
			return;
		}
		for(int i = start; i < N; i++) {
			int tmp = B[start];
			B[start] = B[i];
			B[i] = tmp;
			
			dfs(start + 1, N);
			
			B[i] = B[start];
			B[start] = tmp;
		}
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			int N = Integer.parseInt(br.readLine());
			int area[][] = new int[N][N];
			int result = 0;
			for(int i = 0; i < N; i++) {
				String input = br.readLine();
				for(int j = 0; j < N; j++) {
					area[i][j] = input.charAt(j) -'0';
				}
			}
			for(int i = 0; i < N / 2; i++) {
					for(int j = 1 ; j <= i; j++) {
						result += area[i][N / 2 + j] + area[i][N / 2 - j];
					}
					result += area[i][N / 2];
				}
				for(int i = N / 2; i < N; i++) {
					for(int j = 1 ; j < N - i; j++) {
						result += area[i][N / 2 + j] + area[i][N / 2 - j];
					}
					result += area[i][N / 2];
				}
			sb.append(result).append("\n");
		}
		System.out.print(sb);
	}
}

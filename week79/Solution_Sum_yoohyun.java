import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			int N = Integer.parseInt(br.readLine());
			int board[][] = new int[100][100];
			StringTokenizer st;
			for(int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max = Integer.MIN_VALUE;
			for(int i = 0; i < 100; i++) {
				int sum1 = 0;
				int sum2 = 0;
				for(int j = 0; j < 100; j++) {
					sum1 += board[i][j];
					sum2 += board[j][i];
				}
				max = Math.max(max, sum1);
				max = Math.max(max, sum2);
			}
			int sum1 = 0;
			int sum2 = 0;
			for(int i = 0; i < 100; i++) {
				sum1 = board[i][i];
				sum2 = board[99 - i][i];
			}

			max = Math.max(max, sum1);
			max = Math.max(max, sum2);
			
			
			sb.append(max).append("\n");
		}
		System.out.print(sb);
	}
}

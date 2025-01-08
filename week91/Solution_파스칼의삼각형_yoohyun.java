import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ").append("\n");
			int N = Integer.parseInt(br.readLine());
			int area[][] = new int[N + 1][N + 1];
			area[1][0] = 1;
			for(int i = 2; i <= N; i++) {
				for(int j = 0; j <= i; j++) {
					if(j - 1 >= 0)
						area[i][j] += area[i - 1][j -1]; 
					area[i][j] += area[i-1][j];
					
				}
			}
			for(int i = 1; i <= N; i++) {
				for(int j = 0; j < i; j++) {
					sb.append(area[i][j] + " ");
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}

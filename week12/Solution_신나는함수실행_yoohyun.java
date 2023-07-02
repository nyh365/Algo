import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int[][][] dp = new int[101][101][101];
		
		for(int i = 0; i <= 70; i++) {
			for(int j = 0; j <= 70; j++) {
				for(int k = 0; k <= 70; k++) {
					if(i <= 50 || j <= 50 || k <= 50) {
						dp[i][j][k] = 1;
					}
					else if(i < j && j < k) {
						dp[i][j][k] = dp[i][j][k - 1] + dp[i][j - 1][k - 1] - dp[i][j - 1][k]; 
					} else {
						dp[i][j][k] = dp[i-1][j][k] + dp[i-1][j-1][k]+ dp[i - 1][j][k - 1] - dp[i - 1][j - 1][k - 1];
					}
				}
			}
		}
		
		for(int i = 0; i <= 100; i++) {
			for(int j = 0; j <= 100; j++) {
				for(int k = 0; k <= 100; k++) {
					if(i <= 50 || j <= 50 || k <= 50) {
						dp[i][j][k] = 1;
					}
					else if(i > 70 || j > 70 || k > 70) {
						dp[i][j][k] = dp[70][70][70];
					}
					else if(i < j && j < k) {
						dp[i][j][k] = dp[i][j][k - 1] + dp[i][j - 1][k - 1] - dp[i][j - 1][k]; 
					} else {
						dp[i][j][k] = dp[i-1][j][k] + dp[i-1][j-1][k]+ dp[i - 1][j][k - 1] - dp[i - 1][j - 1][k - 1];
					}
				}
			}
		}
		
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        int c = Integer.parseInt(st.nextToken());
		
	        if(a == -1 && b == -1 && c == -1) break;
	        sb.append("w(").append(a).append(", ").append(b).append(", ").append(c)
	        .append(") = ").append(dp[a + 50][b + 50][c + 50]).append("\n");
		}
        System.out.println(sb);
	}
}

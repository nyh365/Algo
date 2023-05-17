import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] S = new int[N + 1][N + 1];
		int total = 0;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
				total += S[i][j];
			}
		}
		int min = Integer.MAX_VALUE;
		
		for(int round = 1; round <= ((1 << N) - 2); round++) {
			int start = 0;
			int link = total;
			
			for(int i = 1; i <= N; i++) {
				if(((1 << i - 1) & round) != 0) {
					for(int j = 1; j <= N; j++) {
						if(((1 << j - 1) & round) != 0) {
							start += S[i][j];
							link -= S[i][j];
						}
						else {
							link -= S[i][j] + S[j][i];
						}
					}
				}
			}
			
			min = Math.min(min, Math.abs(start - link));
		}
		
		System.out.println(min);
	}
}

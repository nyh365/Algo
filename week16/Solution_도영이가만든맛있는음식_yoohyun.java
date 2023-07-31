import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] food_ingredient = new int[N][2];
		int min = Integer.MAX_VALUE;
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			food_ingredient[i][0] = Integer.parseInt(st.nextToken());
			food_ingredient[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i < (1 << N); i++) {
			int sum1 = 1; int sum2 = 0;
			for(int j = 0; j < N; j++) {
				if((i & (1 << j)) != 0) {
					sum1 *= food_ingredient[j][0];
					sum2 += food_ingredient[j][1];
				}
			}
			min = Math.min(min, Math.abs(sum1 - sum2));
		}
		System.out.println(min);
		
	}
}
 

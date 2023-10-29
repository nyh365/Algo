import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[] building = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			building[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] total = new int[N];
		
		double slope, tmp;
		int result = 0;
		for(int i = 0; i < N; i++) {
			slope = Integer.MAX_VALUE;
			for(int j = i - 1; j >= 0; j--) {
				tmp = (building[i] - building[j]) / (double) (i - j);
				if(tmp < slope) {
					total[i]++;
					slope = tmp;
				}
			}
			
			slope = Integer.MIN_VALUE;
			for(int j = i + 1; j < N; j++) {
				tmp = (building[i] - building[j]) / (double) (i - j);
				if(tmp > slope) {
					total[i]++;
					slope = tmp;
				}
			}
			result = Math.max(result, total[i]);
		}
		System.out.print(result);
	}
}

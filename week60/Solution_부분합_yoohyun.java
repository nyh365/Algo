import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = Integer.MAX_VALUE;
		int sum = 0, start = 0, end = 0;
		while(true) {
			if(sum >= K) {
				sum -= num[start++];
				result = Math.min(result, end - start + 1);
			} else if(end == N) {
				break;
			} else if(sum < K) {
				sum += num[end++];
			} 
		}
		System.out.print(result == Integer.MAX_VALUE ? 0 : result);
	}
}

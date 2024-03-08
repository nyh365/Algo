import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] num = new int[N];
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(num);
		int start = 0, end = 0;
		int result = Integer.MAX_VALUE;
		while(start <= end) {
			if(end == N) break;
			int temp = Math.abs(num[start] - num[end]);
			if(temp < M) {
				end++;
			} else if(temp >= M) {
				result = Math.min(result, temp);
				start++;
			}
		}
		
		System.out.print(result);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] liq = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			liq[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(liq);
		int start = 0, end = N - 1;
		int min = liq[start];
		int max = liq[end];
		int result = Integer.MAX_VALUE;
		int temp = Integer.MAX_VALUE;
		while(start < end) {
			temp = liq[start] + liq[end];
			if(Math.abs(temp) < Math.abs(result)) {
				result = temp;
				min = liq[start];
				max = liq[end];
			}
			if(temp == 0) {
				break;
			} else if(temp < 0) {
				start++;
			} else {
				end--;
			}
		}
		
		System.out.print(min + " " + max);
	}
}

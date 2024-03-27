import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		long[] liq = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			liq[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(liq);
		long min = 0, mid = 0, max = 0;
		long result = 3000000001L;
		long temp = 3000000001L;
		boolean flag = false;
		for(int i = 0; i < N - 2; i++) {
			int start = i + 1;
			int end = N - 1;
			while(start < end) {
				temp = liq[i] + liq[start] + liq[end];
				if(Math.abs(temp) < Math.abs(result)) {
					result = temp;
					min = liq[i];
					mid = liq[start];
					max = liq[end];
				}
				if(result == 0) {
					flag = true;
					break;
				}
				else if(temp < 0) {
					start++;
				} else {
					end--;
				}
			}
			if(flag) break;
		}
		System.out.print(min + " " + mid + " "+ max);
	}
}

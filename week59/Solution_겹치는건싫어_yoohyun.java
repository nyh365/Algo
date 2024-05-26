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
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0, end = 0;
		int[] cntNum = new int[100001];
		int result = Integer.MIN_VALUE;
		while(start <= end) {
			if(end == N) break;
			if(cntNum[num[end]] < M) {
				cntNum[num[end++]]++;
			} else {
				result = Math.max(result, end - start);
				cntNum[num[start++]]--;
			}
		}
		result = Math.max(result, end - start);
		System.out.print(result);
	}
}

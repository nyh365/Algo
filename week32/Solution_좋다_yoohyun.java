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
		int[] num = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		long result = 0;
		for(int i = 0; i < N; i++) {
			int start = 0;
			int end = N - 1;
			while(start < end) {
				if(start == i || end == i) {
					if(start == i) start++;
					else end--;
				} else {
					int sum = num[start] + num[end];
					if(sum == num[i]) {
						result++;
						break;
					}
					else if(sum < num[i]) {
						start++;
					} else {
						end--;
					}
				}
			}
		}
		System.out.print(result);
	}
}

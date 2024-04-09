import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		
		int start = 0, end = N - 1, result = 0;
		while(start < end) {
			int temp = num[start] + num[end];
			if(temp == K) {
				start++;
				end--;
				result++;
			} else if(temp < K) {
				start++;
			} else {
				end--;
			}
		}
		
		System.out.print(result);
	}
}

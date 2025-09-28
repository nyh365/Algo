import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long K = Long.parseLong(br.readLine());

		System.out.println(binarySearch(N, K));
	}
	public static long binarySearch(int N, long K) {
		long start = 0, end = K;
		long mid;
		
		while(start <= end) {
			mid = (start + end) / 2;
			
			int total = 0;
			for(int i = 1; i <= N; i++) {
				total += Math.min(mid / i, N);
			}
			
			if(total < K) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		
		return start;
	}
}

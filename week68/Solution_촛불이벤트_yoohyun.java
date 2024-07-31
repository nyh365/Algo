import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		
		long N;
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			N = Long.parseLong(br.readLine());
			
			sb.append(binarySearch(N)).append("\n");
		}
		System.out.print(sb);
	}
	public static long binarySearch(long target) {
		long start = 1, end = (long) Math.sqrt(target * 2);
		long mid;
		
		while(start <= end) {
			mid = (start + end) / 2;
			
			if((mid * (mid + 1) / 2) < target) {
				start = mid + 1;
			} else if((mid * (mid + 1) / 2) > target) {
				end = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}

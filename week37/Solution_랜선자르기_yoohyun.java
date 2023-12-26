import java.io.*;
import java.util.*;


public class Main {
	static long[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		arr = new long[K];
		long max = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Long.parseLong(br.readLine());
			max = Math.max(arr[i], max);
		}
		System.out.print(binary(max, N));
	}
	public static boolean canMake(long length, int target) {
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			count += arr[i] / length;
		}
		return count < target;
	}
	public static long binary(long end, int target) {
		long s = 0;
		long e = end + 1;
		long mid = 0;
		while(s < e) {
			mid = (s + e) / 2;
			if(canMake(mid, target)){
				e = mid;
			}
			else {
				s = mid + 1;
			}
		}
		
		return s - 1;
	}
}

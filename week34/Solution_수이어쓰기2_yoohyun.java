import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if(countOfN(N) < K)
			System.out.print(-1);
		else {
			int result = binary(K, countOfN(N));
			String s = String.valueOf(result + 1);
			System.out.print(s.charAt(K - countOfN(result) -1));
		}
	}
	public static int countOfN(int N) {
		int count = 0;
		int length = 1;
		while(N >= Math.pow(10, length)) {
			count += (Math.pow(10, length) - Math.pow(10, length - 1)) * length;
			length++;
		}
		count += (N - Math.pow(10, length - 1) + 1) * length; 
		return count;
	}
	public static int binary(int target, int end) {
		int s = 1;
		int e = end;
		int mid = 0;
		while(s <= e) {
			mid = (s + e) / 2;
			if(countOfN(mid) >= target) {
				e = mid - 1;
			}
			else {
				s = mid + 1;
			}
		}
		return e;
	}
}

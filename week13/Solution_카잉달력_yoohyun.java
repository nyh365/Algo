import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			boolean flag = false;
			int max = M * N / gcd(M,N);
			for(int i = x; i <= max; i += M) {
				if(i % N == y) {
					flag = true;
					System.out.println(i + 1);
					break;
				}
			}
			if(!flag)
				System.out.println(-1);
			
		}
		
	}
	public static int gcd(int M, int N) {
		int min = (M > N) ? N : M;
		int result = 0;
		for(int i = 1; i <= min; i++) {
			if(M % i == 0 && N % i == 0)
				result = i;
		}
		return result;
	}
}

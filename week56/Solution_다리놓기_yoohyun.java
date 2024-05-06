import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	static int[][] square;
	static int N, M;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 0; test_case < T; test_case++) {
			st = new StringTokenizer(br.readLine()); 
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			BigInteger sum = BigInteger.valueOf(1L);
			if(N == 1) {
				sum = BigInteger.valueOf(M);
			}
			else if(N == M) {
				sum = BigInteger.valueOf(1);
			}
			else {
				for(int i = M; i > M - N; i--) {
					sum = sum.multiply(BigInteger.valueOf(i));
				}
				
				for(int i = 1; i <= N; i++) {
					sum = sum.divide(BigInteger.valueOf(i));
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}

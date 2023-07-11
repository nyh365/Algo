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
		int[] A = new int[N];
		int[] B = new int[N];
		int[] C = new int[N];
		int[] D = new int[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] AB = new int[N * N];
		int[] CD = new int[N * N];
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				AB[cnt] = A[i] + B[j];
				CD[cnt++] = C[i] + D[j];
			}
		}
		
		Arrays.sort(AB);
		Arrays.sort(CD);
		
		int start = 0, end = N * N - 1;
		long result = 0;
		while(true) {
			if(start > N * N - 1 || end < 0) break;
			int temp = AB[start] + CD[end];
			if(temp < 0) {
				start++;
			} else if(temp > 0) {
				end--;
			} else if(temp == 0) {
				long startCnt = 1, endCnt = 1; 
				while(start + 1 <= N * N - 1 && AB[start] == AB[start + 1]) {
					startCnt++;
					start++;
				}
				while(end - 1 >= 0 && CD[end] == CD[end - 1]) {
					endCnt++;
					end--;
				}
				result += startCnt * endCnt;
				start++;
			}
		}
		
		System.out.print(result);
	}
}

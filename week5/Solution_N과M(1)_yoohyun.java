import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		result = new int[M];
		
		perm(0, 0);
		System.out.println(sb);
	} 
	public static void perm(int cnt, int bit) {
		if(cnt == M) {
			for(int num : result) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if((bit & (1 << i)) != 0) continue;
			result[cnt] = i+1;
			perm(cnt + 1, (bit | (1 << i)));
		}
		
	}
}

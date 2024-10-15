import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			int N = Integer.parseInt(br.readLine());
			int A[] = new int[N];
			int B[] = new int[N];
			for(int i = 0 ; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				A[i] = Integer.parseInt(st.nextToken());
				B[i] = Integer.parseInt(st.nextToken());
			}
			int P = Integer.parseInt(br.readLine());
			int C[] = new int[P + 1];
			for(int i = 1 ; i <= P; i++) {
				C[i] = Integer.parseInt(br.readLine());
			}
			int result[] = new int[P + 1];
			for(int i = 0; i < N; i++) {
				for(int j = 1; j <= P; j++) {
					if(C[j] >= A[i] && C[j] <= B[i])
						result[j]++;
				}
			}
			for(int i = 1; i <= P; i++) {
				sb.append(result[i]).append(" ");
			}
            sb.append("\n");
		}
		System.out.print(sb);
	}
}

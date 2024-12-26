import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			int arr[] = new int[N + 1];
			int need = 0;
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			arr[0] = 1;
			for(int i = 0; i <= N;) {
				if(arr[i] != 1) {
					need += 1;
				}
				boolean flag = true;
				for(int j = i + D; j > i; j--) {
					if(j <= N && arr[j] == 1) {
						flag = false;
						i = j;
						break;
					}
				}
				if(flag)
					i += D;
			}
			
			sb.append(need).append("\n");
		}
		System.out.print(sb);
	}
}

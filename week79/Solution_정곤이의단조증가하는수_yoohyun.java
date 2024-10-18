import java.util.*;
import java.io.*;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			int N = Integer.parseInt(br.readLine());
			int arr[] = new int[N];
			int tmp[] = new int[N * (N - 1) / 2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int cnt = 0;
			for(int i = 0; i < N - 1; i++) {
				for(int j = i + 1; j < N; j++) {
					tmp[cnt++] = arr[i] * arr[j];
				}
			}
			Arrays.sort(tmp);
			int result = -1;
			for(int i = tmp.length - 1; i >= 0; i--) {
				if(isTrue(tmp[i])) {
					result = tmp[i];
					break;
				}
			}
			
			sb.append(result).append("\n");
		}
		System.out.print(sb);
	}
	public static boolean isTrue(int n) {
        while(n > 0) {
        	int t = n % 10;
        	n /= 10;
        	if( n % 10 > t) return false;
        }
        return true;
    }
}

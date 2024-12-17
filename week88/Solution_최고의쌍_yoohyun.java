import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			int N = Integer.parseInt(br.readLine());
			int arr[] = new int[N];
			int max = -1;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = 0; i < N - 1; i++) {
				for(int j = i + 1; j < N; j++) {
					if(special_num(arr[i], arr[j]))
						max = Math.max(arr[i] * arr[j], max);
				}
			}
			sb.append(max).append("\n");
		}
		System.out.print(sb);
	}
	public static boolean special_num(int A, int B) {
		int tmp = A * B;
		String s = Integer.toString(tmp);
		for(int i = 1; i < s.length(); i++) {
			if(s.charAt(i) -'0' - (s.charAt(i - 1) -'0') != 1)
				return false;
		}
		return true;
	}
}

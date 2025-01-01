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
			boolean check[] = new boolean[N];
			int count = 0;
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			for(int i = 1; i < N; i++) {
				int diff = 0;
				int cur = 0;
				if(!check[i]) {
					diff = arr[i] - 1;
					check[i] = true;
					cur = i;
					count++;
					for(int j = i + 1; j < N; j++) {
						if(arr[j] - arr[cur] == diff) {
							check[j] = true;
							cur = j;
						}
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.print(sb);
	}
}

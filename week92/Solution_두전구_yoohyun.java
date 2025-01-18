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
			int arr[] = new int[4];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 4; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int min = Math.min(arr[1], arr[3]);
			int max = Math.max(arr[0], arr[2]);
			if(max > min)
				sb.append(0);
			else
				sb.append(min - max);
			sb.append("\n");
		}
		System.out.print(sb);
	}
}

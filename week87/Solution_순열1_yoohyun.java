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
			String s = "Yes";
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			for(int i = 1; i <= N; i++) {
				if(upper(i, arr) - lower(i, arr) > 0) {
					s = "No";
				}
			}
			sb.append(s).append("\n");
		}
		System.out.print(sb);
	}
	public static int upper(int target, int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		while(start < end) {
			int mid = (start + end) / 2;
			if(arr[mid] <= target)
				start = mid + 1;
			else
				end = mid;
		}
		return start - 1;
	}
	public static int lower(int target, int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		while(start < end) {
			int mid = (start + end) / 2;
			if(arr[mid] < target)
				start = mid + 1;
			else
				end = mid;
		}
		return end;
	}
}

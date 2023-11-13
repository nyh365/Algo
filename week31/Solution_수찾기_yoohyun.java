import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr1[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		int arr2[] = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		Arrays.sort(arr1);
		for(int i = 0; i < M; i++) {
			if(binary_search(arr1, arr2[i]))
				sb.append(1).append("\n");
			else
				sb.append(0).append("\n");
		}

		System.out.print(sb);
	}
	public static boolean binary_search(int[] arr, int target) {
		int s = 0;
		int e = arr.length - 1;
		while(s <= e) {
			int mid = (s + e) / 2;
			if(arr[mid] < target)
				s = mid + 1;
			else if(arr[mid] > target) {
				e = mid - 1;
			}
			else
				return true;
		}
		return false;
	} 
}

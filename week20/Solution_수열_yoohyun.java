import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int max = Integer.MIN_VALUE;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i <= N - K; i++) {
			int tmp = 0;
			for(int j = i; j < i + K; j++) {
				tmp += arr[j];
			}
			max = Math.max(max, tmp);
		}
		System.out.println(max);

	}
}

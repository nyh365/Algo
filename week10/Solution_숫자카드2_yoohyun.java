import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] have = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++){
			have[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(have);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");

		for(int i = 0; i < M; i++){
			int find = Integer.parseInt(st.nextToken());
			int result = upperbound(have, find) - lowerbound(have, find);
			sb.append(result + " ");
		}
		System.out.println(sb);
	}
	public static int lowerbound(int[] arr, int key){
		int lo = 0;
		int hi = arr.length;

		while(lo < hi){
			int mid = (lo + hi) / 2;
			if(arr[mid] >= key){
				hi = mid;
			}
			else{
				lo = mid + 1;
			}

		}
		return lo;
	}
	public static int upperbound(int[] arr, int key){
		int lo = 0;
		int hi = arr.length;

		while(lo < hi){
			int mid = (lo + hi) / 2;
			if(arr[mid] > key){
				hi = mid;
			}
			else{
				lo = mid + 1;
			}

		}
		return lo;
	}
}

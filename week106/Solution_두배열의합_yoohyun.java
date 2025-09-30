import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		int[] B = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int[] sumA = makeSumArray(A, N);
		Arrays.sort(sumA);
		
		int[] sumB = makeSumArray(B, M);
		Arrays.sort(sumB);
		
		long result = 0;
		for(int i = 0; i < sumA.length; i++) {
			result += findTarget(sumB, T - sumA[i]);
		}
		
		System.out.println(result);
	}
	public static int[] makeSumArray(int[] num, int n) {
		int[] sumArray = new int[n * (n + 1) / 2];
		
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			int total = 0;
			for(int j = i; j < n; j++) {
				total += num[j];
				sumArray[cnt++] = total;
			}
		}
		
		return sumArray;
	}
	
	public static int findTarget(int[] sumArray, int target) {
		int startIdx = lowerBinarySearch(sumArray, target);
		int endIdx = upperBinarySearch(sumArray, target);
		
		if(startIdx == -1 || endIdx == -1) return 0;
		
		return endIdx - startIdx + 1;
	}
	
	public static int lowerBinarySearch(int[] sumArray, int target) {
		int start = 0, end = sumArray.length;
		int mid;
		
		while(start < end) {
			mid = (start + end) / 2;
			
			if(sumArray[mid] < target) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		
		if(start == sumArray.length) return -1;
		if(sumArray[start] != target) return -1;
		
		return start;
	}
	
	public static int upperBinarySearch(int[] sumArray, int target) {
		int start = 0, end = sumArray.length;
		int mid = 0;
		
		while(start < end) {
			mid = (start + end) / 2;
			
			if(sumArray[mid] <= target) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		
		end -= 1;
		
		if(end == -1) return -1;
		if(sumArray[end] != target) return -1;
		
		return end;
	}
}

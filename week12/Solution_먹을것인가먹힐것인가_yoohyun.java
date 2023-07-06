import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int test_case = Integer.parseInt(br.readLine());
		for(int t = 1; t <= test_case; t++) {
			st = new StringTokenizer(br.readLine());
			int lenA = Integer.parseInt(st.nextToken());
			int lenB = Integer.parseInt(st.nextToken());
			
			int[] numA = new int[lenA];
			int[] numB = new int[lenB];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < lenA; i++) {
				numA[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < lenB; i++) {
				numB[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(numB);
			int result = 0;
			for(int i = 0; i < lenA; i++) {
				result += binarySearch(numB, numA[i]) + 1;
			}
			sb.append(result).append("\n");
		}
		System.out.print(sb);
	}
	public static int binarySearch(int[] numB, int target) {
		int start = 0;
		int end = numB.length - 1;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(numB[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return start - 1;
	}
}

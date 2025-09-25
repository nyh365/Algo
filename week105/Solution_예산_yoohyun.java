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
		
		int N = Integer.parseInt(br.readLine());
		int[] cities = new int[N];
		int max = Integer.MIN_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			cities[i] = Integer.parseInt(st.nextToken());
		
			max = Math.max(max, cities[i]);
		}
		
		Arrays.sort(cities);
		
		int budget = Integer.parseInt(br.readLine());
		
		System.out.print(binarySearch(max, budget, cities));
	}
	public static int binarySearch(int max, int budget, int[] cities) {
		int start = 0;
		int end = max;
		int mid = 0;
		
		while(start <= end) {
			mid = (start + end) / 2;
			
			if(isInBudget(budget, mid, cities)) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		return start - 1;
	}
	
	public static boolean isInBudget(int budget, int target, int[] cities) {
		int total = 0;
		for(int m : cities) {
			if(m > target) {
				total += target;
			} else {
				total += m;
			}
		}
		
		return total > budget ? false : true;
	}
}

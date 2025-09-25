import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] list = new int[N];
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			int index = binarySearch(list, cnt, num[i]);
			if(index == cnt) {
				list[cnt++] = num[i];
			} else {
				list[index] = num[i];
			}
		}
		
		System.out.println(cnt);
	
	}
	public static int binarySearch(int[] list, int cnt, int target) {
		int start = 0, end = cnt;
		int mid;
		
		while(start <= end) {
			mid = (start + end) / 2;

			if(mid == cnt) return start;
			
			if(list[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		return start;
	}
}

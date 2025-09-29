import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int max = Integer.MIN_VALUE;
		int[] lecture = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			lecture[i] = Integer.parseInt(st.nextToken());
		
			max = Math.max(max, lecture[i]);
		}

		System.out.println(binarySearch(lecture, max * ((int) (N / M) + 1), M));
	}
	public static int binarySearch(int[] lecture, int end, int M) {
		int start = 0;
		int mid;
		
		while(start <= end) {
			mid = (start + end) / 2;
			
			if(canDivide(mid, lecture, M)) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		return start;
	}
	public static boolean canDivide(int target, int[] lecture, int M) {
		int cdCnt = 1;
		
		int total = 0;
		for(int i = 0; i < lecture.length; i++) {
			if(lecture[i] > target) return false;
			if(cdCnt > M) return false;
			if(total + lecture[i] <= target) {
				total += lecture[i];
			} else {
				total = lecture[i];
				cdCnt++;
			}
		}
		
		return cdCnt <= M ? true : false;
	}
}

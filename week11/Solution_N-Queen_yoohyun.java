import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int result;
	static int N;
	static int[] queen;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		queen = new int[N];
		
		for(int i = 0; i < N; i++) {
			queen[0] = i;
			backTracking(1);
		}
		
		System.out.print(result);
	}
	public static void backTracking(int col) {
		if(col == N) {
			result++;
			return;
		}
		for(int i = 0; i < N; i++) {
			queen[col] = i;
			if(check(col)) {
				backTracking(col+1);
			}
		}
	}
	public static boolean check(int col) {
		for(int i = 0; i < col; i++) {
			if(queen[i] == queen[col]) return false;
			if(Math.abs(col - i) == Math.abs(queen[i] - queen[col])) return false;
		}
		return true;
	}
}


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		int result[][] = new int[N + 1][N + 1];
		for(int i = 0; i <= N; i++) {
			Arrays.fill(result[i], -1);
		}
		result[1][0] = 0;
		queue.add(1);
		queue.add(0);
		while(!queue.isEmpty()) {
			int e = queue.remove();
			int c = queue.remove();
			if(e > 0 && e <= N) {
				if(result[e][e] == -1) {
					queue.add(e);
					queue.add(e);
					result[e][e] = result[e][c] + 1;
				}
			}
			if(c > 0 && e + c <= N) {
				if(result[e + c][c] == -1) {
					queue.add(e + c);
					queue.add(c);
					result[e + c][c] = result[e][c] + 1;
				}
			}
			if(e - 1 >= 0) {
				if(result[e-1][c] == -1) {
					queue.add(e-1);
					queue.add(c);
					result[e-1][c] = result[e][c] + 1;
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0; i <= N; i++) {
			if(result[N][i] == -1)
				continue;
			if(min > result[N][i])
				min = result[N][i];
		}
		
		System.out.print(min);
	}
}

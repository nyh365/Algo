import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int MAX = 10000;
	static boolean prime[] = new boolean[MAX];
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		boolean[][] relation = new boolean[N + 1][N + 1];
		boolean[] check = new boolean[N + 1];
		int result[] = new int[N + 1];
		Arrays.fill(result, -1);
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			relation[from][to] = true;
			relation[to][from] = true;
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(A);
		result[A] = 0;
		check[A] = true;
		
		while(!queue.isEmpty()) {
			int cur = queue.remove();
			for(int j = 1; j <= N; j++) {
				if(relation[cur][j] && !check[j]) {
					queue.add(j);
					check[j] = true;
					result[j] = result[cur] + 1;
				}
			}
		}
		if(result[B] == -1) {
			System.out.print(-1);
		}
		else {
			System.out.print(result[B]);
		}
	}
}

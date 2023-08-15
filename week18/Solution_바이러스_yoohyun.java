import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean net[][] = new boolean[N + 1][N + 1];
		boolean check[] = new boolean[N + 1];
		int result = 0;
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			net[from][to] = true;
			net[to][from] = true;
		}
		Queue<Integer> queue = new LinkedList<>();
		check[1] = true;
		queue.add(1);
		while(!queue.isEmpty()) {
			int cur = queue.remove();
			for(int i = 1; i <= N; i++) {
				if(net[cur][i] || net[i][cur] ) {
					check[i] = true;
					queue.add(i);
					net[cur][i] = false;
					net[i][cur] = false;
				}
			}
		}
		for(int i = 1; i <= N; i++) {
			if(check[i])
				result++;
		}
		System.out.print(result - 1);
	}
}

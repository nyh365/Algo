import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean board[][] = new boolean[N][M];
		int result[][] = new int[N][M];
		int dx[] = {1,0,-1,0};
		int dy[] = {0,1,0,-1};
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			for(int j = 0; j < M; j++) {
				if(input.charAt(j) == '1')
					board[i][j] = true;
				else
					board[i][j] = false;
			}
		}
		Queue<Integer> queue = new LinkedList<>();
		board[0][0] = false;
		result[0][0] = 1;
		queue.add(0);
		queue.add(0);
		while(!queue.isEmpty()) {
			int x = queue.remove();
			int y = queue.remove();
			
			for(int i = 0; i < 4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				if(0 <= xx && xx < M && 0 <= yy && yy < N) {
					if(board[yy][xx]) {
						board[yy][xx] = false;
						result[yy][xx] = result[y][x] + 1;
						queue.add(xx);
						queue.add(yy);
					}
				}
			}
			
		}
		System.out.print(result[N-1][M-1]);
	}
}

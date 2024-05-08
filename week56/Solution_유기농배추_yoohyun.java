import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int board[][] = new int[N][M];
			int cnt = 0;
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				board[Y][X] = 1;
			}
			Queue<Integer> queue = new LinkedList<>();
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(board[i][j] == 1) {
						queue.add(j);
						queue.add(i);
						board[i][j] = 0;
						while(!queue.isEmpty()) {
							int X = queue.remove();
							int Y = queue.remove();
							if(X + 1 < M && board[Y][X + 1] == 1) {
								board[Y][X + 1] = 0;
								queue.add(X + 1);
								queue.add(Y);
							}
							if(X - 1 >= 0 && board[Y][X - 1] == 1) {
								board[Y][X - 1] = 0;
								queue.add(X - 1);
								queue.add(Y);
							}
							if(Y + 1 < N && board[Y + 1][X] == 1) {
								board[Y + 1][X] = 0;
								queue.add(X);
								queue.add(Y + 1);
							}
							if(Y - 1 >= 0 && board[Y - 1][X] == 1) {
								board[Y - 1][X] = 0;
								queue.add(X);
								queue.add(Y - 1);
							}
						}
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	
	}
}

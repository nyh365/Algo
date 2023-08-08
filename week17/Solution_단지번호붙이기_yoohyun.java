import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int board[][] = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			String s = br.readLine();
			for(int j = 1; j <= N; j++) {
				if(s.charAt(j-1) -'0' == 1) {
					board[i][j] = 1;
				}
			}
		}
		int result[] = new int[N * N];
		boolean check[][] = new boolean[N+1][N+1];
		
		Queue<Integer> queue = new LinkedList<>();
		
		int cnt = 1;
			
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(board[i][j] == 1 && check[i][j] == false) {
					queue.add(j);
					queue.add(i);
					result[cnt]++;
					check[i][j] = true;
					while(!queue.isEmpty()) {
						int X = queue.remove();
						int Y = queue.remove();
						if(X + 1 <= N && check[Y][X+1] == false && board[Y][X+1] == 1 ) {
							queue.add(X + 1);
							queue.add(Y);
							check[Y][X+1] = true;
							result[cnt] = result[cnt] + 1;
						}
						if(X - 1 >= 1 && check[Y][X - 1] == false && board[Y][X - 1] == 1) {
							queue.add(X - 1);
							queue.add(Y);
							check[Y][X - 1] = true;
							result[cnt] = result[cnt] + 1;
						}
						if(Y + 1 <= N && check[Y + 1][X] == false && board[Y + 1][X] == 1) {
							queue.add(X);
							queue.add(Y + 1);
							check[Y + 1][X] = true;
							result[cnt] = result[cnt] + 1;
						}
						if(Y - 1 >= 1 && check[Y - 1][X] == false && board[Y - 1][X] == 1) {
							queue.add(X);
							queue.add(Y - 1);
							check[Y - 1][X] = true;
							result[cnt] = result[cnt] + 1;
						}
					}
					cnt++;
				}
				
			}
		}
		Arrays.sort(result);
		System.out.println(cnt-1);
		for(int i = N * N - cnt + 1; i < N * N; i++)
			System.out.println(result[i]);
	}
}

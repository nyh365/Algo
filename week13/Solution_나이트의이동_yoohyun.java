import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int[] dx = {1,2,1,2,-1,-2,-1,-2};
		int[] dy = {2, 1,-2,-1,2,1,-2,-1};
		int T = Integer.parseInt(br.readLine());
		int[] night_loc = new int[2];
		int[] des = new int[2];
		int[][] chess;
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			chess = new int[N][N];
			st = new StringTokenizer(br.readLine());
			night_loc[0] = Integer.parseInt(st.nextToken());
			night_loc[1] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			des[0] = Integer.parseInt(st.nextToken());
			des[1] = Integer.parseInt(st.nextToken());
			Queue<Integer> queue = new LinkedList<>();
			queue.add(night_loc[0]);
			queue.add(night_loc[1]);
			chess[night_loc[1]][night_loc[0]] = 1;
			while(!queue.isEmpty()) {
				int x = queue.remove();
				int y = queue.remove();
				for(int k = 0; k < 8; k++) {
					int xx = x + dx[k];
					int yy = y + dy[k];
					if(xx >= 0 && yy >= 0 && xx < N && yy < N) {
						if(chess[yy][xx] == 0) {
							chess[yy][xx] = chess[y][x] + 1;
							queue.add(xx);
							queue.add(yy);
						}
					}
					
				}
			}
			sb.append(chess[des[1]][des[0]] - 1).append("\n");
		}
		System.out.println(sb);
	}
}

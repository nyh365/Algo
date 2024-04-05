import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
	
		for(int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				map[i][j]= input[j] -'0';
			}
		}
		Queue<Integer> queue = new LinkedList<>();
		boolean[][][] check = new boolean[N][M][2];
		queue.add(0);queue.add(0);queue.add(1);queue.add(1);
		check[0][0][1] = true;
		boolean flag = false;
		int result = -1;
		while(!queue.isEmpty()) {
			int x = queue.remove();
			int y = queue.remove();
			int cnt = queue.remove();
			int broke = queue.remove();
			if(x == M - 1 && y == N -1) {
				result = cnt;
				break;
			}
			for(int k = 0; k < 4; k++) {
				int xx = x + dx[k];
				int yy = y + dy[k];
				if(xx >= 0 && xx < M && yy >=0 && yy < N) {
					if(!check[yy][xx][broke]) {
						if(map[yy][xx] == 0) {
							check[yy][xx][broke] = true;
							queue.add(xx);queue.add(yy);queue.add(cnt+1);queue.add(broke);
						}
						else {
							if(broke == 1) {
								check[yy][xx][broke] = true;
								queue.add(xx);queue.add(yy);queue.add(cnt+1);queue.add(broke - 1);
							}
						}
					}
				}
			}
		}
		System.out.println(result);
	}
}

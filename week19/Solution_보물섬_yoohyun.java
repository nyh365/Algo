import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int result = Integer.MIN_VALUE;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static int W, H;
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		char[][] map = new char[H][W];
		for(int i = 0; i < H; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j = 0; j < W; j++) {
				map[i][j] = input[j];
			}
		}

		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(map[i][j] == 'L') {
					bfs(i, j, map);
				}
			}
		}
		System.out.println(result);
	}

	public static void bfs(int i, int j, char[][] map) {
		boolean[][] visited = new boolean[H][W];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(j); queue.add(i); queue.add(0);
		visited[i][j] = true;
		while(!queue.isEmpty()) {
			int x = queue.remove();
			int y = queue.remove();
			int length = queue.remove();
			result = Math.max(result, length);

			for(int k = 0; k < 4; k++) {
				int xx = x + dx[k];
				int yy = y + dy[k];
				if(xx < 0 || xx >= W || yy < 0 || yy >= H || visited[yy][xx]) continue;
				if(map[yy][xx] == 'W') continue;
				visited[yy][xx] = true;
				queue.add(xx);
				queue.add(yy);
				queue.add(length + 1);
			}
		}
	}
}

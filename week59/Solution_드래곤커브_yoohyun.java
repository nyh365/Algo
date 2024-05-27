import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,-1,0,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] map = new boolean[101][101];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			map[y][x] = true;
			LinkedList<Integer> list = new LinkedList<>();
			x += dx[d]; y += dy[d];
			map[y][x] = true;
			list.add(d);
			for(int G = 1; G <= g; G++) {
				for(int j = list.size() - 1; j >= 0; j--) {
					list.add((list.get(j) + 1) % 4);
					x += dx[(list.get(j) + 1) % 4];
					y += dy[(list.get(j) + 1) % 4];
					map[y][x] = true;
				}
			}
		}
		int result = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) result++;
			}
		}
		System.out.println(result);
	} 
}

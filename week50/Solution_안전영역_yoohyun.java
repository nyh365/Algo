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
		int[][] area = new int[N][N];
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				area[i][j] = tmp;
				max = Math.max(max, tmp);
			}
		}		
		int result_max = Integer.MIN_VALUE;
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0; i <= max; i++) {
			boolean[][] check = new boolean[N][N];
			int sum = 0;
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					if(!check[j][k] && area[j][k] > i) {
						check[j][k] = true;
						queue.add(j);
						queue.add(k);
						while(!queue.isEmpty()) {
							int y = queue.remove();
							int x = queue.remove();
							for(int move = 0; move < 4; move++) {
								int yy = y + dy[move];
								int xx = x + dx[move];
								if(0 <= yy && yy < N && 0 <= xx && xx < N && !check[yy][xx]) {
									if(area[yy][xx] > i) {
										queue.add(yy);
										queue.add(xx);
										check[yy][xx] = true;
									}
								}
							}
						}
						sum++;
					}
				}
			}
			result_max = Math.max(result_max, sum);
		}
		System.out.print(result_max);
	}
}

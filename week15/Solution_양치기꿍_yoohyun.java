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
		char area[][] = new char[N][M];
		int dx[] = {1,-1,0,0};
		int dy[] = {0,0,1,-1};
		int result_wolf = 0;
		int result_sheep = 0;
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			for(int j = 0; j < M; j++) {
				area[i][j] = input.charAt(j);
			}
		}
		int wolf = 0;
		int sheep = 0;
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(area[i][j] != '#') {
					queue.add(i);
					queue.add(j);
					if(area[i][j] == 'v')
						wolf++;
					else if(area[i][j] == 'k')
						sheep++;
					area[i][j] = '#';
					while(!queue.isEmpty()) {
						int y = queue.remove();
						int x = queue.remove();
						for(int k = 0; k < 4; k++) {
							int yy = y + dy[k];
							int xx = x + dx[k];
							if(0 <= xx && xx < M && 0 <= yy && yy < N && area[yy][xx] != '#') {
								queue.add(yy);
								queue.add(xx);
								if(area[yy][xx] == 'v')
									wolf++;
								else if(area[yy][xx] == 'k')
									sheep++;
								area[yy][xx] = '#'; 
							}
						}
					}
				}
				if(wolf >= sheep) {
					result_wolf += wolf;
				}
				else
					result_sheep += sheep;
				wolf = 0;
				sheep = 0;
			}
		}
		System.out.print(result_sheep + " " + result_wolf);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main{
	static int N, M, virusCnt, total, result = Integer.MAX_VALUE;
	static int[][] lab;
	static boolean[][] checked;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static LinkedList<int[]> virus = new LinkedList<>();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][N];
        checked = new boolean[N][N];
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < N; j++) {
        		lab[i][j] = Integer.parseInt(st.nextToken());
        		if(lab[i][j] == 2) {
        			virus.add(new int[] {j, i});
        		} else if(lab[i][j] == 0) {
        			total++;
        		}
        	}
        }
        
        virusCnt = virus.size();
        
        combination(0,0,0);
        
        System.out.print(result == Integer.MAX_VALUE ? -1 : result);
	}
	public static void combination(int index, int cnt, int visited) {
		if(cnt == M) {
			result = Math.min(result, solve(visited));
			return;
		}
		
		for(int i = index; i < virusCnt; i++) {
			combination(i + 1, cnt + 1, (1 << i) | visited);
		}
	}
	
	public static int solve(int visited) {
		initChecked();
		
		Queue<Integer> queue = new LinkedList<>();
	
		for(int i = 0; i < virusCnt; i++) {
			if(((1 << i) & visited) > 0) {
				queue.add(virus.get(i)[0]);
				queue.add(virus.get(i)[1]);
				queue.add(0);
			}
		}
		
		int curX, curY, curTime;
		int xx, yy, time = 0, cnt = 0;
		while(!queue.isEmpty()) {
			if(cnt == total) break;
			curX = queue.remove();
			curY = queue.remove();
			curTime = queue.remove();
			
			for(int k = 0; k < 4; k++) {
				xx = curX + dx[k];
				yy = curY + dy[k];
				
				if(xx < 0 || xx >= N || yy < 0 || yy >= N) continue;
				if(checked[yy][xx]) continue;
				if(lab[yy][xx] == 1) continue;
				
				if(lab[yy][xx] == 0) cnt++;
				
				checked[yy][xx] = true;
				
				queue.add(xx);
				queue.add(yy);
				queue.add(curTime + 1);

				if(lab[yy][xx] != 2) {
					time = Math.max(curTime + 1, time);
				}
			}
		}
		return cnt == total ? time: Integer.MAX_VALUE;
	}
	public static void initChecked() {
		for(int i = 0; i < N; i++) {
			Arrays.fill(checked[i], false);
		}
	}
}

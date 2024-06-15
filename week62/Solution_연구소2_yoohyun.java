import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main{
	static int N, M, result = Integer.MAX_VALUE, cnt, total;
	static int[][] lab;
	static boolean[][] checked;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static HashMap<Integer, int[]> virus = new HashMap<>();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        lab = new int[N][N];
        checked = new boolean[N][N];
        
        cnt = 0;
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < N; j++) {
        		lab[i][j] = Integer.parseInt(st.nextToken());
        		if(lab[i][j] == 2) {
        			virus.put(cnt++, new int[] {j, i});
        			total++;
        		} else if(lab[i][j] == 0) {
        			total++;
        		}
        	}
        }
        
        combination(0,0,0);
        
        System.out.print(result == Integer.MAX_VALUE ? -1 : result);
	}
	public static void combination(int selectCnt, int index, int visited) {
		if(selectCnt == M) {
			result = Math.min(result, getResult(visited));
			return;
		}
		
		for(int i = index; i < cnt; i++) {
			combination(selectCnt + 1, i + 1, visited | 1 << i);
		}
	}

	public static int getResult(int visited) {
		Queue<int[]> queue = new LinkedList<>();
		Queue<int[]> temp = new LinkedList<>();
		int time = 0, count = 0;

		initChecked();
		
		for(int i = 0; i < cnt; i++) {
			if(((1 << i) & visited) > 0) {
				queue.add(virus.get(i));
				checked[virus.get(i)[1]][virus.get(i)[0]] = true;
				count++;
			}
		}
		
		int xx, yy;
		int[] cur;
		while(!queue.isEmpty()) {
			cur = queue.remove();
			
			for(int k = 0; k < 4; k++) {
				xx = cur[0] + dx[k];
				yy = cur[1] + dy[k];
				
				if(xx < 0 || xx >= N || yy < 0 || yy >= N) continue;
				if(checked[yy][xx]) continue;
				if(lab[yy][xx] == 1) continue;
				
				checked[yy][xx] = true;
				count++;
				temp.add(new int[] {xx, yy});
			}
			
			if(queue.isEmpty()) {
				time++;
				while(!temp.isEmpty()) {
					queue.add(temp.remove());
				}
			}
		}
		return count == total ? time - 1 : Integer.MAX_VALUE;
	}
	public static void initChecked() {
		for(int i = 0; i < N; i++) {
			Arrays.fill(checked[i], false);
		}
	}
}

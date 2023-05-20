import java.io.*;
import java.util.*;

public class Main {
	static int[][] lab;
	static int N, M;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {-1,1,0,0};
	static int result = Integer.MIN_VALUE;
	static int[][] list;
	static Queue<Integer> virus = new LinkedList<>();
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lab = new int[N][M];
		int empty = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				if(lab[i][j] == 0) {
					empty++;
				}
			}
		}
		list = new int[empty][2];
		empty = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(lab[i][j] == 0) {
					list[empty][0] = j;
					list[empty++][1] = i;
				}
			}
		}
		
		buildWall(0, 0);
		System.out.println(result);
	}
	public static void buildWall(int cnt, int cur) {
		if(cnt == 3) {
			bfs(copyLab());
			return;
		}
		for(int i = cur; i < list.length; i++) {
			lab[list[i][1]][list[i][0]] = 1;
			buildWall(cnt+1, i + 1);
            lab[list[i][1]][list[i][0]] = 0;
		}
	}
	public static void bfs(int[][] tmp) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(lab[i][j] == 2) {
					virus.add(j);
					virus.add(i);
				}
			}
		}
		
		while(!virus.isEmpty()) {
			int x = virus.remove();
			int y = virus.remove();
			
			for(int k = 0; k < 4; k++) {
				int xx = x + dx[k];
				int yy = y + dy[k];
				
				if(xx >= 0 && xx < M && yy >= 0 && yy < N) {
					if(tmp[yy][xx] == 0) {
						tmp[yy][xx] = 2;
						virus.add(xx);
						virus.add(yy);
					}
				}
			}
		}
		
		result = Math.max(result, countSafeZone(tmp));
	}
	
	public static int countSafeZone(int[][] tmp) {
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(tmp[i][j] == 0) count++;
			}
		}
		return count;
	}
	
	public static int[][] copyLab(){
		int tmp[][] = new int[N][M];
		for(int i = 0; i < N; i++) {
			tmp[i] = lab[i].clone();
		}
		return tmp;
	}
}

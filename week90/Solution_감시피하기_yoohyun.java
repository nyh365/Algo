import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static ArrayList<int[]> teacher;
	static char[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
     
        teacher = new ArrayList<>();
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < N; j++) {
        		map[i][j] = st.nextToken().toCharArray()[0];
        		
        		if(map[i][j] == 'T') {
        			teacher.add(new int[] {j, i});
        		}
        	}
        }
        
        System.out.println(isOK() ? "YES" : "NO");
    }
	public static boolean isOK() {
		for(int i = 0; i < N * N; i++) {
			if(map[i / N][i % N] != 'X') continue;
			map[i / N][i % N] = 'W';
			for(int j = i + 1; j < N * N; j++) {
				if(map[j / N][j % N] != 'X') continue;
				map[j / N][j % N] = 'W';
				
				for(int k = j + 1; k < N * N; k++) {
					if(map[k / N][k % N] != 'X') continue;
				
					map[k / N][k % N] = 'W';
					
					if(isSafe()) {
						return true;
					}
					
					map[k / N][k % N] = 'X';
				}
				map[j / N][j % N] = 'X';
			}
			map[i / N][i % N] = 'X';
		}
		return false;
	}
	public static boolean isSafe() {
		int x, y;
		for(int[] cur : teacher) {
			for(int k = 0; k < 4; k++) {
				x = cur[0];
				y = cur[1];
				
				while(true) {
					x += dx[k];
					y += dy[k];
					
					if(x < 0 || x >= N || y < 0 || y >= N) break;
					if(map[y][x] == 'S') return false;
					if(map[y][x] == 'W') break;
				}
			}
		}
		return true;
	}
}

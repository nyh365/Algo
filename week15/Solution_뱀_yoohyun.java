import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	//상,우,하,좌
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int apple = Integer.parseInt(br.readLine());
		int map[][] = new int[N + 1][N + 1];
		map[1][1] = 1;
		//사과 위치
		for(int i = 0; i < apple; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()); // 행
			int c = Integer.parseInt(st.nextToken()); // 열
			map[r][c] = 2;
		}
		
		LinkedList<Integer> list = new LinkedList<>();
		int L = Integer.parseInt(br.readLine());
		int hx = 1; int hy = 1; int hd = 1; 
		int tx = 1; int ty = 1; int td = 1;
		boolean flag = false;
		int result = 0;
		int totalTime = 0;
		for(int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int tTime = time - totalTime;
			String dir = st.nextToken();
			for(int j = 0; j < tTime; j++) {
				result++;
				hx += dx[hd]; hy += dy[hd];
				if(hx <= 0 || hx > N || hy <= 0 || hy > N ) {     
					flag = true;
					break;
				}
				if(map[hy][hx] == 2) {
					map[hy][hx] = 1;
					continue;
				} else if(map[hy][hx] == 1){
					flag = true;
					break;
				} else {
					map[hy][hx] = 1;
					map[ty][tx] = 0;
					if(list.size() > 0 && tx == list.get(0) && ty == list.get(1)) {
						list.remove(); list.remove();
						td = list.remove();
					}
					tx += dx[td]; ty += dy[td];
				}
				
			}
			totalTime = time;
			if(flag) break;
			
			if(dir.equals("D")) {
				hd = (hd + 1) % 4;
			} else {
				hd =  (hd + 3) % 4;
			}
			list.add(hx); list.add(hy); list.add(hd);
		}
		if(!flag) {
			for(int j = 0;; j++) {
				result++;
				hx += dx[hd]; hy += dy[hd];
				if(hx <= 0 || hx > N || hy <= 0 || hy > N ) {     
					flag = true;
					break;
				}
				if(map[hy][hx] == 2) {
					map[hy][hx] = 1;
					continue;
				} else if(map[hy][hx] == 1){
					flag = true;
					break;
				} else {
					map[hy][hx] = 1;
					map[ty][tx] = 0;
					if(list.size() > 0 && tx == list.get(0) && ty == list.get(1)) {
						list.remove(); list.remove();
						td = list.remove();
					}
					tx += dx[td]; ty += dy[td];
				}
				
			}
		}
		System.out.println(result);
	}
}

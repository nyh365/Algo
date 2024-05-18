import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main{
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1 ,0};
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Queue<int[]> robot = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        int robotY = Integer.parseInt(st.nextToken());
        int robotX = Integer.parseInt(st.nextToken());
        int robotDir = Integer.parseInt(st.nextToken());
        robot.add(new int[] {robotX, robotY, robotDir});

        int[][] room = new int[N][M];
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < M; j++) {
        		room[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        int[] cur;
        int xx, yy;
        int result = 0;
        boolean needClean;
        while(!robot.isEmpty()) {
        	cur = robot.remove();
        	
        	//1번
        	if(room[cur[1]][cur[0]] == 0) {
        		result++;
        		room[cur[1]][cur[0]] = -1;
        	}
        	
        	//2번, 3번 조건 확인
        	needClean = false;
        	for(int k = 0; k < 4; k++) {
        		xx = cur[0] + dx[k];
        		yy = cur[1] + dy[k];
        		
        		if(room[yy][xx] == 0) {
        			needClean = true; 
        			break;
        		}
        	}
        	
        	//3번
        	if(needClean) {
        		while(true) {
        			cur[2] = (cur[2] + 3) % 4;
        			xx = cur[0] + dx[cur[2]];
        			yy = cur[1] + dy[cur[2]];
        			if(room[yy][xx] == 0) {
        				robot.add(new int[] {xx, yy, cur[2]});
        				break;
        			}
        		}
        	} else { //2번
        		xx = cur[0] + dx[(cur[2] + 2) % 4];
        		yy = cur[1] + dy[(cur[2] + 2) % 4];
        		if(room[yy][xx] == 1) break;
        		robot.add(new int[] {xx, yy, cur[2]});
        	}
        }
        System.out.print(result);
    }
}

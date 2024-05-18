import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main{
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1 ,0};
	static int[][] room;
	static int result;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int robotY = Integer.parseInt(st.nextToken());
        int robotX = Integer.parseInt(st.nextToken());
        int robotDir = Integer.parseInt(st.nextToken());

        room = new int[N][M];
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < M; j++) {
        		room[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        solve(robotX, robotY, robotDir);
	    
        System.out.print(result);
    }
	public static void solve(int robotX, int robotY, int robotDir) {
		//1번
    	if(room[robotY][robotX] == 0) {
    		result++;
    		room[robotY][robotX] = -1;
    	}
    	
    	//2번, 3번 조건 확인
    	boolean needClean = needClean(robotX, robotY, robotDir);
    	
    	int xx, yy;
    	if(needClean) {
    		while(true) {
    			robotDir = (robotDir + 3) % 4;
    			xx = robotX + dx[robotDir];
    			yy = robotY + dy[robotDir];
    			if(room[yy][xx] == 0) {
    				break;
    			}
    		}
    	} else { //2번
    		xx = robotX + dx[(robotDir + 2) % 4];
    		yy = robotY + dy[(robotDir + 2) % 4];
    	}
    	if(room[yy][xx] != 1) {
    		solve(xx, yy, robotDir);
    	}
	}
	public static boolean needClean(int robotX, int robotY, int robotDir) {
		int xx, yy;

		//2번, 3번 조건 확인
    	for(int k = 0; k < 4; k++) {
    		xx = robotX + dx[k];
    		yy = robotY + dy[k];
    		
    		if(room[yy][xx] == 0) {
    			return true;
    		}
    	}
    	return false;
	}
}

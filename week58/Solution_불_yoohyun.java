import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main{
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1 ,0};
	static char[][] room;
	static int result, W, H;
	static Queue<int[]> fires, sanggeun;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        char[] inputArray;
        
        for(int t = 0; t < T; t++) {
        	st = new StringTokenizer(br.readLine());
        	W = Integer.parseInt(st.nextToken());
        	H = Integer.parseInt(st.nextToken());
        	
        	init();
        	
        	for(int i = 0; i < H; i++) {
        		inputArray = br.readLine().toCharArray();
        		for(int j = 0; j < W; j++) {
        			room[i][j] = inputArray[j];
        			if(room[i][j] == '@') {
        				sanggeun.add(new int[] {j,i});
        			} else if(room[i][j] == '*') {
        				fires.add(new int[] {j, i});
        			}
        		}
        	}
        	
        	while(true) {
        		boolean temp = fire();
        		
        		if(temp) {
        			sb.append(result).append("\n");
        			break;
        		} else {
        			if(fires.isEmpty() && sanggeun.isEmpty()) {
        				sb.append("IMPOSSIBLE").append("\n");
        				break;
        			}
        		}
        	}
        }
        System.out.print(sb);
    }
	public static void init() {
		room = new char[H][W];
		fires = new LinkedList<>();
		sanggeun = new LinkedList<>();
		result = 0;
	}
	
	public static boolean fire() {
		int[] cur;
		Queue<int[]> secondary = new LinkedList<>();
		while(!fires.isEmpty()) {
			cur = fires.remove();
			
			int xx, yy;
			for(int k = 0; k < 4; k++) {
				xx = cur[0] + dx[k];
				yy=  cur[1] + dy[k];
				
				if(xx < 0 || xx >= W || yy < 0 || yy >= H) continue;
				if(room[yy][xx] == '#' || room[yy][xx] == '*') continue;
				room[yy][xx] = '*';
				secondary.add(new int[] {xx, yy});
			}
		}
		
		while(!secondary.isEmpty()) {
			fires.add(secondary.remove());
		}
		
		return move();
	}
	
	public static boolean move() {
		result++;
		int[] cur;
		Queue<int[]> secondary = new LinkedList<>();
		while(!sanggeun.isEmpty()) {
			cur = sanggeun.remove();
			
			int xx, yy;
			for(int k = 0; k < 4; k++) {
				xx = cur[0] + dx[k];
				yy=  cur[1] + dy[k];
				
				if(xx< 0 || xx >= W || yy < 0 || yy >= H) return true;
				if(room[yy][xx] == '.') {
					room[yy][xx] = '@';
					secondary.add(new int[] {xx, yy});
				}
			}
		}
		
		while(!secondary.isEmpty()) {
			sanggeun.add(secondary.remove());
		}
		return false;
	} 
}

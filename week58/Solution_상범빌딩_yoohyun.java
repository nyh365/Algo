import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main{
	static int[] dx = {0, 0, 1, 0, -1 ,0};
	static int[] dy = {0, 0, 0, -1, 0, 1};
	static int[] dh = {1, -1, 0, 0, 0, 0};
	static char[][][] building;
	static int result, L, R, C;
	static Queue<int[]> sangbeom;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        char[] inputArray;
        
        while(true) {
        	st = new StringTokenizer(br.readLine());

        	L = Integer.parseInt(st.nextToken());
        	R = Integer.parseInt(st.nextToken());
        	C = Integer.parseInt(st.nextToken());
        	
        	if(L == 0 && R == 0 && C == 0) break;

        	init();
        	
        	for(int i = 0; i < L; i++) {
        		for(int j = 0; j < R; j++) {
        			inputArray = br.readLine().toCharArray();
        			for(int k = 0; k < C; k++) {
        				building[i][j][k] = inputArray[k];
        				if(building[i][j][k] == 'S') {
        					sangbeom.add(new int[] {k,j,i});
        				}
        			}
        		}
        		br.readLine();
        	}
        	if(escape()) {
        		sb.append("Escaped in ").append(result+1).append(" minute(s).").append("\n");
        	} else {
        		sb.append("Trapped!").append("\n");
        	}
        }
        System.out.print(sb);
    }
	public static void init() {
		building = new char[L][R][C];
		sangbeom = new LinkedList<>();
		result = 0;
	}
	public static boolean escape() {
		int[] cur;
		Queue<int[]> secondary = new LinkedList<>();
		while(!sangbeom.isEmpty()) {
			cur = sangbeom.remove();
			int xx, yy, hh;
			for(int k = 0; k < 6; k++) {
				xx = cur[0] + dx[k];
				yy = cur[1] + dy[k];
				hh = cur[2] + dh[k];
				
				if(xx < 0 || xx >= C || yy < 0 || yy >= R || hh < 0 || hh >= L) continue;
				if(building[hh][yy][xx] == 'E') return true;
				if(building[hh][yy][xx] != '.') continue;
				building[hh][yy][xx] = '#';
				
				secondary.add(new int[] {xx,yy,hh});
			}
			
			if(sangbeom.isEmpty()) {
				result++;
				while(!secondary.isEmpty()) {
					sangbeom.add(secondary.remove());
				}
			}
		}
		return false;
	} 
}

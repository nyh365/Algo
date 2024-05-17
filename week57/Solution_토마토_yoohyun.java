import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main{
	static int[] dm = {0,0,1,0,-1,0};
	static int[] dn = {0,0,0,-1,0,1};
	static int[] dh = {1,-1,0,0,0,0};
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        
        int[][][] tomatos = new int[H][N][M];
        Queue<int[]> main = new LinkedList<>();
        int tomatoCnt = 0;
        
        for(int i = 0; i < H; i++) {
        	for(int j = 0; j < N; j++) {
        		st = new StringTokenizer(br.readLine());
        		for(int k = 0; k < M; k++) {
        			tomatos[i][j][k] = Integer.parseInt(st.nextToken());
        			if(tomatos[i][j][k] == 1) {
        				main.add(new int[] {k,j,i});
        			} else if(tomatos[i][j][k] == 0) {
        				tomatoCnt++;
        			}
        		}
        	}
        }
        
        Queue<int[]> secondary = new LinkedList<>();
        int result = 0, mm, nn, hh;
        int[] cur;
        while(!main.isEmpty()) {
        	cur = main.remove();
        	
        	for(int k = 0; k < 6; k++) {
        		mm = cur[0] + dm[k];
        		nn = cur[1] + dn[k];
        		hh = cur[2] + dh[k];
        		
        		if(mm < 0 || mm >= M || nn < 0 || nn >= N || hh < 0 || hh >= H) continue;
        		if(tomatos[hh][nn][mm] != 0) continue;
        		tomatos[hh][nn][mm] = 1;
        		tomatoCnt--;
        		secondary.add(new int[] {mm, nn, hh});
        	}
        	
        	if(main.isEmpty() && !secondary.isEmpty()) {
        		result++;
        		while(!secondary.isEmpty()) {
        			main.add(secondary.remove());
        		}
        	}
        }
        
        System.out.print(tomatoCnt == 0 ? result : -1);
    }
}

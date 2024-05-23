import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main{
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F, S, G, U, D;
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
    
        int[] floor = new int[F + 1];
        Arrays.fill(floor, Integer.MAX_VALUE);
        Queue<int[]> loc = new LinkedList<>();
        loc.add(new int[] {S, 0});
        
        int[] cur;
        if(G == S) {
        	floor[G] = 0;
        } else {
        	while(!loc.isEmpty()) {
            	cur = loc.remove();
            	
            	//U버튼 눌렀을때
            	if(U + cur[0] <= F) {
            		if(floor[U + cur[0]] > cur[1] + 1) {
            			floor[U + cur[0]] = cur[1] + 1;
            			loc.add(new int[] {U + cur[0], cur[1] + 1});
            		}
            	}
            	//D버튼 눌렀을때
            	if(cur[0] - D > 0) {
            		if(floor[cur[0] - D] > cur[1] + 1) {
            			floor[cur[0] - D] = cur[1] + 1;
            			loc.add(new int[] {cur[0] - D, cur[1] + 1});
            		}
            	}
            }
        }
        
        System.out.print(floor[G] == Integer.MAX_VALUE ? "use the stairs": floor[G]);
	}
}

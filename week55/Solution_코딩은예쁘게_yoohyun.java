import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        int[] before = new int[N];
        int[] collect = new int[N];
        int[] dis = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	before[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	collect[i] = Integer.parseInt(st.nextToken());
        	dis[i] = collect[i] - before[i];
        }
        
        int result = Math.abs(dis[0]);
        for(int i = 1; i < N; i++) {
        	if(dis[i] * dis[i - 1] < 0) {
        		result += Math.abs(dis[i]);
        	} else if(Math.abs(dis[i]) >= Math.abs(dis[i - 1])) {
        		result += Math.abs(dis[i] - dis[i - 1]);
        	}
        }
        System.out.print(result);
    }
}

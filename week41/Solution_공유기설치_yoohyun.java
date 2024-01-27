import java.util.*;
import java.lang.*;
import java.io.*;
 
public class Main{
	static int[] router;
	static int N, C;
    public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());

    	router = new int[N];
    	for(int i = 0; i < N; i++) {
    		router[i] = Integer.parseInt(br.readLine());
    	}
    	
    	
    	Arrays.sort(router);
    	
    	int start = 1, end = router[N - 1];
    	int mid;
    	int result = 0;
    	while(start <= end) {
    		mid = (start + end) / 2;
    		
    		if(possible(mid)) {
    			start = mid + 1;
    			result = mid;
    		} else {
    			end = mid - 1;
    		}
    	}
    	
    	System.out.print(result);
    }
    public static boolean possible(int dis) {
    	int cnt = 0, cur = 0;
    	for(int i = 1; i < N; i++) {
    		if(Math.abs(router[cur] - router[i]) >= dis) {
    			cnt++;
    			cur = i;
    		}
    	}
    	return cnt >= C - 1 ? true : false;
    }   
}

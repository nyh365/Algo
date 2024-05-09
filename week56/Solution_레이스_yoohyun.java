import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main{
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] locations = new int[K];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++) {
        	locations[i] = Integer.parseInt(st.nextToken());
        }

        int start = 1, end = locations[K - 1] - locations[0];
        int mid, result = 0;
        
        while(start <= end) {
        	mid = (start + end) / 2;
        	
        	int cnt = count(locations, mid, K);
        	if(cnt >= M) {
        		result = Math.max(mid, result);
        		start = mid + 1;
        	} else {
        		end = mid - 1;
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        int prev = locations[0], cnt = 1;
        for(int i = 1; i < K; i++) {
        	if(locations[i] - prev >= result && cnt < M) {
        		prev = locations[i];
        		cnt++;
        		sb.append(1);
        	} else {
        		sb.append(0);
        	}
        }
        System.out.print(sb);
    }
	public static int count(int[] locations, int target, int K) {
		int cnt = 1, prev = locations[0];
		for(int i = 1; i < K; i++) {
			if(locations[i] - prev >= target) {
				prev = locations[i];
				cnt++;
			}
		}
		
		return cnt;
	}
}

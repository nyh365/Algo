import java.util.*;
import java.lang.*;
import java.io.*;
 
public class Main{
    public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	
    	int N = Integer.parseInt(br.readLine());
    	int[] num = new int[N];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < N; i++) {
    		num[i] = Integer.parseInt(st.nextToken());
    	}

    	Set<Integer> set = new HashSet<>();
    	int start = 0, end = 0;
    	long cnt = 0, result = 0;
    	while(start < N) {
    		if(end == N) {
    			result += cnt;
    			start++;
    			cnt--;
    		} else if(set.contains(num[end])) {
    			set.remove(num[start++]);
    			result += cnt;
    			cnt--;
    		} else {
    			set.add(num[end++]);
    			cnt++;
    		}
    	}
    	System.out.print(result);
    }
}

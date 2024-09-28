import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main{
	static int N;
	static int[] A;
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	N = Integer.parseInt(br.readLine());
    	A = new int[N]; 
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < N; i++) {
    		A[i] = Integer.parseInt(st.nextToken());
    	}

    	int result = 0;
    	if(N < 3) {
    		result = N;
    	} else {
    		Arrays.sort(A);
    		for(int i = 0; i < N - 1; i++) {
    			for(int j = N - 1; j > i + 1; j--) {
    				if(A[i] + A[i + 1] > A[j]) {
    					result = Math.max(result, j - i + 1);
    				}
    			}
    		}
    		
    		if(result == 0) {
    			result = 2;
    		}
    	}
    	
    	System.out.println(result);
	}
}

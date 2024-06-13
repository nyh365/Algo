import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
 
public class Main{
	static String[] lamp;
	static int N, M, K;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        lamp = new String[N];
        
        for(int i = 0; i < N; i++) {
        	lamp[i] = br.readLine();
        }
        
        K = Integer.parseInt(br.readLine());
        
        System.out.print(solve());
	}
	public static int solve() {
		int cntZero, result = 0;
		for(int i = 0; i < N; i++) {
			cntZero = countZero(i);
			
			if(cntZero > K) continue;
			if((K - cntZero) % 2 != 0) continue;
			
			result = Math.max(result, findResult(i));
		}
		return result;
	}
	public static int countZero(int row) {
		int result = 0;
		for(int i = 0; i < M; i++) {
			if(lamp[row].charAt(i) == '0') result++;
		}
		return result;
	}
	public static int findResult(int target) {
		int result = 0;
		
		for(int i = 0; i < N; i++) {
			if(lamp[target].equals(lamp[i])) result++;
		}
		
		return result;
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main{
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	int[][] arr = new int[N][M];
    	char[] input;
    	for(int i = 0; i < N; i++) {
    		input = br.readLine().toCharArray();
    		for(int j = 0; j < M; j++) {
    			arr[i][j] = input[j] - '0';
    		}
    	}
    	
    	int result = -1;
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < M; j++) {
    			for(int di = -N; di < N; di++) {
    				for(int dj = -M; dj < M; dj++) {
    					if(di == 0 && dj == 0) continue;
    					
    					int temp = 0;
    					int numI = i;
    					int numJ = j;
    					
    					while(numI >= 0 && numI < N && numJ >= 0 && numJ < M){
    						temp *= 10;
    						temp += arr[numI][numJ];
    						
    						if(isSquare(temp)) {
    							result = Math.max(result, temp);
    						}
    						
    						numI += di;
    						numJ += dj;
    					}
    				}
    			}
    		}
    	}
    	System.out.print(result);
	}
	public static boolean isSquare(int num) {
		int squre = (int) Math.sqrt(num);
		
		return Math.pow(squre, 2) == num ? true : false;
	}
}

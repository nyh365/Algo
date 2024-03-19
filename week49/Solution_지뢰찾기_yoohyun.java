import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
 
public class Main{
	public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	int T = Integer.parseInt(br.readLine());
    	
    	for(int test_case = 0; test_case < T; test_case++) {
    		int N = Integer.parseInt(br.readLine());
    		
    		int[] num = new int[N];
    		char[] bomb = br.readLine().toCharArray();
    		for(int i = 0; i < N; i++) {
    			num[i] = bomb[i] - '0';
    		}
    		br.readLine();
    		sb.append(findBomb(N, num)).append("\n");
    	}
    	System.out.print(sb);
	}
	public static int findBomb(int N, int[] num) {
		int bombCnt = 0;
		for(int i = 0; i < N; i++) {
			if (i == 0 && num[i] != 0 && num[i+1] != 0) {
                num[i] -= 1;
                num[i+1] -= 1;
                bombCnt++;
            } else if (i == (N - 1) && num[i - 1] != 0 && num[i] != 0) {
            	num[i - 1] -= 1;
            	num[i] -= 1;
                bombCnt++;
            } else if (i != 0 && i != (N - 1) && num[i - 1] != 0 && num[i] != 0 && num[i + 1] != 0) {
            	num[i - 1] -= 1;
            	num[i] -= 1;
            	num[i + 1] -= 1;
                bombCnt++;
            }
		}
		return bombCnt;
	}
}

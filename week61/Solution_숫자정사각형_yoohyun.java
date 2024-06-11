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
        
        char[][] square = new char[N][M];
        for(int i = 0; i < N; i++) {
        	square[i] = br.readLine().toCharArray();
        }

        int result = 0;
        int minLength = Math.min(N, M);
        for(int i = 1; i <= minLength; i++) {
        	for(int j = 0; j <= M - i; j++) {
        		for(int k = 0; k <= N - i; k++) {
        			if(square[k][j] == square[k][j + i - 1]&& square[k][j] == square[k + i - 1][j] && square[k][j] == square[k + i - 1][j + i - 1]) {
        				result = Math.max(result, i);
        			}
        		}
        	}
        }
        System.out.print((int) Math.pow(result, 2));
	}
}

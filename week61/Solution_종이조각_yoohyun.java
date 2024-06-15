import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
 
public class Main{
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        
        int[][] paper = new int[N][M];
        
        char[] input;
        for(int i = 0; i < N; i++) {
        	input = br.readLine().toCharArray();
        	for(int j = 0; j < M; j++) {
        		paper[i][j] = input[j] - '0';
        	}
        }
       
        int result = 0, total, temp;
        for(int i = 0; i < (1 << N * M); i++) {
        	total = 0;
        	//가로 합 구하기
        	for(int j = 0; j < N; j++) {
        		temp = 0;
        		for(int k = 0; k < M; k++) {
        			if(((1 << (j * M + k)) & i) == 0) {
        				temp = temp * 10 + paper[j][k];
        			} else {
        				total += temp;
        				temp = 0;
        			}
        		}
        		total += temp;
        	}
        	
        	//세로 합 구하기
        	for(int j = 0; j < M; j++) {
        		temp = 0;
        		for(int k = 0; k < N; k++) {
        			if(((1 << (k * M + j)) & i) > 0) {
        				temp = temp * 10 + paper[k][j];
        			} else {
        				total += temp;
        				temp = 0;
        			}
        		}
        		total += temp;
        	}
        	result = Math.max(result, total);
        }
        
        System.out.print(result);
	}
}

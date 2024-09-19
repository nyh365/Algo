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
    	
    	int M = Integer.parseInt(st.nextToken());
    	int N = Integer.parseInt(st.nextToken());

    	char[][] map = new char[M][N];
    	
    	for(int i = 0; i < M; i++) {
    		map[i] = br.readLine().toCharArray();
    	}
    	
    	int result = 0;
    	int wallType = -1;
    	//가로 구하기
    	for(int i = 0; i < M - 1; i++) {
    		for(int j = 0; j < N; j++) {
    			if(map[i][j] == 'X' && map[i + 1][j] == '.') {
    				if(wallType == 0) {
    					result++;
    					wallType = -1;
    				} else {
    					wallType = 0;
    				}
    			} else if(map[i][j] == '.' && map[i + 1][j] == 'X'){
    				if(wallType == 1) {
    					result++;
    					wallType = -1;
    				} else {
    					wallType = 1;
    				}
    			} else {
    				wallType = -1;
    			}
    		}
    	}
    	
    	//세로 구하기
    	wallType = -1;
    	for(int i = 0; i < N - 1; i++) {
    		for(int j = 0; j < M; j++) {
    			if(map[j][i] == 'X' && map[j][i + 1] == '.') {
    				if(wallType == 0) {
    					result++;
    					wallType = -1;
    				} else {
    					wallType = 0;
    				}
    			} else if(map[j][i] == '.' && map[j][i + 1] == 'X'){
    				if(wallType == 1) {
    					result++;
    					wallType = -1;
    				} else {
    					wallType = 1;
    				}
    			} else {
    				wallType = -1;
    			}
    		}
    	}
    	
    	System.out.print(result);
	}
}

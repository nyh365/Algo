import java.util.*;
import java.lang.*;
import java.io.*;
 
public class Main{
    static char[][] miro;
    static Queue<int[]> jihun = new LinkedList<>();
    static Queue<int[]> fires = new LinkedList<>();
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
    public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int R = Integer.parseInt(st.nextToken());
    	int C = Integer.parseInt(st.nextToken());
    	
    	miro = new char[R][C];

    	char[] input;
    	for(int i = 0; i < R; i++) {
    		input = br.readLine().toCharArray();
    		for(int j = 0; j < C; j++) {
    			if(input[j] == 'J') {
    				jihun.add(new int[] {j, i});
    			} else if(input[j] == 'F') {
    				fires.add(new int[]{j,i});
    			}
    			miro[i][j] = input[j];
    		}
    	}
    	
    	Queue<int[]> jihunNext = new LinkedList<>();
    	Queue<int[]> fireNext = new LinkedList<>();
    	
    	boolean flag = false;
    	int result = 0;
    	while(!jihun.isEmpty()) {
    		while(!fires.isEmpty()) {
    			int[] fireLoc = fires.remove();
    			int[] fireLLoc = new int[2];
    			for(int i = 0; i < 4; i++) {
    				fireLLoc[0] = fireLoc[0] + dx[i];
    				fireLLoc[1] = fireLoc[1] + dy[i];
    				
    				if(fireLLoc[0] < 0 || fireLLoc[0] >= C || fireLLoc[1] < 0 || fireLLoc[1] >= R) continue;
    				if(miro[fireLLoc[1]][fireLLoc[0]] == '.' || miro[fireLLoc[1]][fireLLoc[0]] == 'J') {
    					miro[fireLLoc[1]][fireLLoc[0]] = 'F';
        				fireNext.add(new int[] {fireLLoc[0], fireLLoc[1]});
    				}
    			}
    		}
    		while(!jihun.isEmpty()) {
    			int[] jihunLoc = jihun.remove();
    			int[] jihunLLoc = new int[2];
    			for(int i = 0; i < 4; i++) {
    				jihunLLoc[0] = jihunLoc[0] + dx[i];
    				jihunLLoc[1] = jihunLoc[1] + dy[i];
    				
    				if(jihunLLoc[0] < 0 || jihunLLoc[0] >= C || jihunLLoc[1] < 0 || jihunLLoc[1] >= R) {
    					flag = true;
    					break;
    				}
    				
    				if(miro[jihunLLoc[1]][jihunLLoc[0]] == '.') {
    					miro[jihunLLoc[1]][jihunLLoc[0]] = 'J';
        				jihunNext.add(new int[] {jihunLLoc[0], jihunLLoc[1]});
    				}
    			}
    		}
    		
    		result++;
    		if(flag) break;
    		
    		while(!fireNext.isEmpty()) {
    			fires.add(fireNext.remove());
    		}
    		
    		while(!jihunNext.isEmpty()) {
    			jihun.add(jihunNext.remove());
    		}
    		
    	}
    	System.out.println(flag ? result : "IMPOSSIBLE");
    }
}

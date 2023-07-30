import java.io.*;
import java.util.*;

public class Main {
	static char[][] forest;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
    static int result = 0;
    static int R,C;
	public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        forest = new char[R][C];
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        int result = 0;
        
        for(int i = 0; i < R; i++) {
        	char[] input = br.readLine().toCharArray();
        	for(int j = 0; j < C; j++) {
            	forest[i][j] = input[j];
            	if(forest[i][j] == 'S') {// 비버 위치
            		queue.add(j);
            		queue.add(i);
            	}
            	else if(forest[i][j] == '*') {
            		queue2.add(j);
            		queue2.add(i);
            	}
        	}
        }
        
        boolean check[][] = new boolean[R][C];
        boolean flag = false;
        while(!queue.isEmpty()) {
        	Queue<Integer> water_tmp = new LinkedList<>();
        	Queue<Integer> beaver_tmp = new LinkedList<>();
        	
        	while(!queue2.isEmpty()) {
        		int water_x = queue2.remove(), water_y = queue2.remove();
        		for(int i = 0; i < 4; i++) {
            		int water_xx = water_x + dx[i];
            		int water_yy = water_y + dy[i];
            		if(water_xx >= 0 && water_xx < C && water_yy >= 0 && water_yy < R) {
            			if(forest[water_yy][water_xx] != 'X' && forest[water_yy][water_xx] != 'D') {
            				if(forest[water_yy][water_xx] != '*') {
            					forest[water_yy][water_xx] ='*';
            					water_tmp.add(water_xx);
            					water_tmp.add(water_yy);
            				}
            			}
            		}
            	}
        	}
        	while(!queue.isEmpty()) {
        		int x = queue.remove(),  y = queue.remove();
        		check[y][x] = true;
        		for(int i = 0; i < 4; i++) {
            		int xx = x + dx[i];
            		int yy = y + dy[i];
            		if(xx >= 0 && xx < C && yy >= 0 && yy < R) {
            			if(forest[yy][xx] == 'D') {
            				flag = true;
            				break;
            			}
            			if(!check[yy][xx]) {
            				if(forest[yy][xx] != 'X' && forest[yy][xx] != '*') {
                				check[yy][xx] = true;
                				beaver_tmp.add(xx);
                				beaver_tmp.add(yy);
                			}
            			}
            		}
            	}
        	}
        	if(queue2.isEmpty()) {
        		while(!water_tmp.isEmpty())
        			queue2.add(water_tmp.remove());
        	}
        	if(queue.isEmpty()) {
        		while(!beaver_tmp.isEmpty())
        			queue.add(beaver_tmp.remove());
        	}
        	result++;
        	if(flag) {
        		break;
        	}
        }
        if(flag) 
        	System.out.println(result);
        else
        	System.out.println("KAKTUS");
    }    
}

import java.io.*;
import java.util.*;

public class Main {
	static int[][] box;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
    static int day = 0;
    static int M,N;
	public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < M; j++) {
            	box[i][j] = Integer.parseInt(st.nextToken());
            	if(box[i][j] == 1) {
            		queue.add(j);
            		queue.add(i);
            	}
            	else if(box[i][j] == 0) {
            		cnt++;
            	}
        	}
        }
        if(cnt == 0) {
        	day = 0;
        }
        else {
        	while(!queue.isEmpty()) {
            	int size = queue.size() / 2;
            	for(int i = 0; i < size; i++) {
            		int x = queue.remove();
            		int y = queue.remove();
            		for(int k = 0; k < 4; k++) {
                		int xx = x + dx[k];
                		int yy = y + dy[k];
                		if(xx >= 0 && xx < M && yy >= 0 && yy < N) {
                			if(box[yy][xx] == 0) {
                				queue.add(xx);
                				queue.add(yy);
                				box[yy][xx] = 1;
                				cnt--;
                			}
                		}
                	}
            	}
            	day++;
            		
            }
        	if(cnt != 0) {
        		day = -1;
        	}
        	else
        		day -= 1;
        }
        System.out.println(day);
	}       
}

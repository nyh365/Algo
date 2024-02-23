import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main{
	static int N, M;
	static int roomNum;
	static int bigRoom;
	static int[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int[] wall = {4, 8, 1, 2};
	static HashMap<Integer, Integer> rooms = new HashMap<>();
	static HashSet<Integer>[] neighbor = new HashSet[2501];
	public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	map = new int[M][N];
    	
    	for(int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < N; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	init();
    	
    	findRoom();
    	
    	System.out.print(roomNum + "\n" + bigRoom + "\n" + findMax());
    }
	public static void init() {
		for(int i = 1; i <= 2500; i++) {
			neighbor[i] = new HashSet<>();
		}
	}
	public static void findRoom() {
		int[][] visited = new int[M][N];
		int total = M * N;
		Queue<Integer> queue = new LinkedList<>();
		
		while(total != 0) {
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < N; j++) {
					if(visited[i][j] != 0) continue;
					
					int roomCnt = 1;
					queue.add(j); queue.add(i);
					visited[i][j] = ++roomNum;
					
					int x, y, xx, yy;
					while(!queue.isEmpty()) {
						x = queue.remove(); y = queue.remove();
						for(int k = 0; k < 4; k++) {
							xx = x + dx[k];
							yy = y + dy[k];
							
							if(xx < 0 || xx >= N || yy < 0 || yy >= M) continue;
							if((map[yy][xx] & wall[k]) > 0) {
								if(visited[yy][xx] != 0 && visited[yy][xx] != roomNum) {
									neighbor[roomNum].add(visited[yy][xx]);
								}
								continue;
							}
							if(visited[yy][xx] != 0) continue;
							
							roomCnt++;
							visited[yy][xx] = roomNum;
							queue.add(xx); queue.add(yy);
						}
					}
					bigRoom = Math.max(bigRoom, roomCnt);
					total -= roomCnt;
					rooms.put(roomNum, roomCnt);
				}
			}
		}
	}
	public static int findMax() {
		int result = Integer.MIN_VALUE;
		
		for(int i = 1; i <= roomNum; i++) {
			Iterator it = neighbor[i].iterator();
			while(it.hasNext()) {
				result = Math.max(result, rooms.get(i) + rooms.get(it.next()));
			}
		}
		
		return result;
	}
}

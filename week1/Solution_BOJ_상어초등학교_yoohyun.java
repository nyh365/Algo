import java.io.*;
import java.util.*;

public class Main {
	static int[][] seat;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int N;
	public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        seat = new int[N + 1][N + 1];
     
        List<List<Integer>> student = new LinkedList<>();
        student = new LinkedList<>();
        for(int i = 0; i < N * N; i++) {
        	student.add(new LinkedList<>());
        }
        
        for(int i = 0; i < N * N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int index = Integer.parseInt(st.nextToken());
        	for(int j = 0; j < 4; j++) {
        		student.get(index - 1).add(Integer.parseInt(st.nextToken()));
        	}    	
        	findSeat(index, student.get(index - 1));
        }
        int result = 0;
        for(int i = 1; i <= N; i++) {
    		for(int j = 1; j <= N; j++) {
        		int count = 0;
        		for(int k = 0; k < 4; k++) {
        			int xx = j + dx[k];
        			int yy = i + dy[k];
        			if(xx >= 1 && xx <= N && yy >= 1 && yy <= N) {
        				for(int f = 0; f < 4; f++) {
        					if(seat[yy][xx] == student.get(seat[i][j] - 1).get(f)) {
        						count++;
        					}
        				}
        			}
        		}
        		result += (count == 0 ? 0 : Math.pow(10, count - 1));
        	}
    	}
        System.out.println(result);
	}   
	
	public static void findSeat(int index, List<Integer> friend) {
		int tmp[][] = init();
		method1(tmp, friend);
		Queue<Loc> queue = findMax(tmp);
		if(queue.size() == 1) {
			Loc loc = queue.remove();
			seat[loc.y][loc.x] = index;
			return;
		}
		tmp = init();
		method2(tmp, queue);
		queue = findMax(tmp);
		if(queue.size()== 1) {
			Loc loc = queue.remove();
			seat[loc.y][loc.x] = index;
			return;
		}
		
		List<Loc> list = new LinkedList<>();
		while(!queue.isEmpty()) {
			list.add(queue.remove());
		}
		
		Collections.sort(list);
		Loc loc = list.get(0);
		seat[loc.y][loc.x] = index;
		return;

	}
	public static void method1(int[][] tmp, List<Integer> friend) {
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(seat[i][j] == 0) {
					int count = 0;
					for(int k = 0; k < 4; k++) {
						Loc locc = new Loc(j + dx[k], i + dy[k]);
						if(locc.x >= 1 && locc.x <= N && locc.y >= 1 && locc.y <= N) {
							if(seat[locc.y][locc.x] != 0) {
								for(int f = 0; f < 4; f++) {
									if(seat[locc.y][locc.x] == friend.get(f)) {
										count++;
									}
								}	
							}		
						}
					}
					tmp[i][j] = count;
				}
			}
		}
	}
	
	public static Queue<Loc> method2(int[][] tmp, Queue<Loc> queue) {
		int size = queue.size();
		for(int i = 0; i < size; i++){
			Loc loc = queue.remove();
			int count = 0;
			for(int k = 0; k < 4; k++) {
				Loc locc = new Loc(loc.x + dx[k], loc.y + dy[k]);
				if(locc.x >= 1 && locc.x <= N && locc.y >= 1 && locc.y <= N) {
					if(seat[locc.y][locc.x] == 0) {
						queue.add(locc);
						count++;
					}
				}
			}
			tmp[loc.y][loc.x] = count;
		}
		return queue;
	}
	
	public static Queue<Loc> findMax(int[][] tmp) {
		int max = Integer.MIN_VALUE;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				max = Math.max(max, tmp[i][j]);
			}
		}
		Queue<Loc> loc = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(tmp[i][j] == max) {
					loc.add(new Loc(j,i));
				}
			}
		}
		return loc;
	}
	public static int[][] init(){
		int tmp[][] = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			Arrays.fill(tmp[i], -1);
		}
		return tmp;
	}
}
class Loc implements Comparable<Loc>{
	int x;
	int y;
	public Loc(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Loc o) {
		if(this.y < o.y) return -1;
		else if(this.y == o.y) {
			if(this.x < o.x) return -1;
			else if(this.x == o.x) return 0;
			else return 1;
		}
		else return 1;
	}
}

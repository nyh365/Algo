import java.util.*;
import java.io.*;

public class Main {
	static int[][] ground;
	static int N;
	static int M;
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());
       int D = Integer.parseInt(st.nextToken());
       ground = new int[N][M];
       int[] archer = new int[M];
       int result = Integer.MIN_VALUE;
       List<Point> list = new LinkedList<>();
       //격자판 입력, 적 위치 리스트에 저장
       for(int i = 0; i < N; i++) {
    	   st = new StringTokenizer(br.readLine());
    	   for(int j = 0; j < M; j++) {
    		   ground[i][j] = Integer.parseInt(st.nextToken());
    		   if(ground[i][j] == 1) list.add(new Point(j,i));
    	   }
       }
       Collections.sort(list);
       //조합
       for(int i = M - 1; i > M - 4; i--) {
    	   archer[i] = 1;
       }
       
       do {
    	   List<Point> tmp = copy(list);
    	   int count = 0, round = 0;
    	   while(tmp.size() != 0) {
    		   for(int i = 0; i < M; i++) {
            	   if(archer[i] == 1) {
            		   int size = tmp.size();
            		   int min_dis = Integer.MAX_VALUE;
            		   int min_index = -1;
            		   for(int j = size - 1; j >= 0; j--) {
                		   if(tmp.get(j).y + round < N) {
                			   int distance = Math.abs(tmp.get(j).x - i) + Math.abs(tmp.get(j).y + round - N);
                			   if(distance <= D && min_dis >= distance) {
                				   min_index = j;
                    			   min_dis = distance;
                    		   }
                		   }
                		   else {
                			   min_index--;
                			   tmp.remove(j);
                		   }
                	   }
            		   if(min_index >= 0)
            			   tmp.get(min_index).hit = true;
            	   }
               }
    		   int size = tmp.size();
    		   for(int i = size - 1; i >= 0; i--) {
    			   if(tmp.get(i).hit) {
    				   tmp.remove(i);
    				   count++;
    			   }
    		   }
    		   round++;
    	   }
    	   result = Math.max(result, count);
       } while(np(archer));
       System.out.println(result);
    }
    
    public static boolean np(int[] archer) {
    	int N = archer.length;
    	int i = N - 1;
    	while(i > 0 && archer[i-1] >= archer[i]) --i;
    	if(i == 0) return false;
    	int j = N - 1;
    	while(archer[i-1] >= archer[j]) --j;
    	swap(archer, i - 1, j);
    	int k = N - 1;
    	while(i < k) {
    		swap(archer, i++, k--);
    	}
    	return true;
    }
    public static void swap(int[] num, int i, int j) {
    	int tmp = num[i];
    	num[i] = num[j];
    	num[j] = tmp;
    }
    public static List<Point> copy(List<Point> list){
    	List<Point> tmp = new LinkedList<>();
    	for(Point p : list) {
    		int x = p.x;
    		int y = p.y;
    		tmp.add(new Point(x,y));
    	}
    	return tmp;
    }
}
class Point implements Comparable<Point>{
	int x;
	int y;
	boolean hit;
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		return x > o.x ? 1 : (x == o.x ? 0 : -1);
	}
}

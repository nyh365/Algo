import java.io.*;
import java.util.*;

public class Main {
	static char[][] board = new char[8][8];
	static boolean[][] visited = new boolean[8][8];
	static int[] dx = {0,1,1,0,-1,-1,1,-1,0};
	static int[] dy = {-1,0,-1,1,0,-1,1,1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Point> wallList = new LinkedList<>();
		
		for(int i = 0; i < 8; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j = 0; j < 8; j++) {
				board[i][j] = input[j];
				if(board[i][j] == '#')
					wallList.add(new Point(j,i));
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> queue2 = new LinkedList<>();
		queue.add(0);
		queue.add(7);
		visited[7][0] = true;
		boolean result = false;
		
		while(!queue.isEmpty()) {
			int x = queue.remove();
			int y = queue.remove();
			
			for(int i = 0; i < 9; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				
				if(xx < 0 || xx >= 8 || yy < 0 || yy >=8) continue;
				if(i != 8 && visited[yy][xx]) continue;
				if(board[yy][xx] == '#') continue;
				if(xx >= 0 && xx <= 7 && yy - 1 >= 0 && yy - 1 <= 7) {
					if(board[yy - 1][xx] == '#') continue;
				}
				
				if(xx == 7 && yy == 0) {
					result = true;
					break;
				}
				queue2.add(xx);
				queue2.add(yy);
				
				visited[yy][xx] = true;
			}
			if(result) break;
			visited[y][x] = false;
			if(queue.isEmpty()) {
				while(!queue2.isEmpty()) {
					queue.add(queue2.remove());
					queue.add(queue2.remove());
				}
				Collections.sort(wallList);
				for(int i = wallList.size() - 1; i >=0 ; i--) {
					Point p = wallList.get(i);
					if(p.y + 1 >= 8) {
						board[p.y][p.x] = '.';
						wallList.remove(i);
					} 
					else {
						board[p.y][p.x] = '.';
						board[p.y+1][p.x] = '#';
						wallList.get(i).setY(p.y + 1);
					}
				}
			}
		}
		
		if(result)
			System.out.println("1");
		else
			System.out.println("0");
	
	}
	static class Point implements Comparable<Point>{
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.y, y);
		}
	}
}

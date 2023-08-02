import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static boolean UP, DOWN, LEFT, RIGHT;
	static char[][] block = {
			{'|', '+', '1', '4'},
			{'|', '+', '2', '3'},
			{'+', '-', '1','2'},
			{'+', '-', '3', '4'},
	};
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int[][] M = new int[1][2], Z = new int[1][2];
	static char[][] EURO;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//유럽의 크기 R, C
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		//초기입력
		EURO = new char[R][C];
		for(int r = 0; r < R; r++) {
			char[] input = br.readLine().toCharArray(); 
			for(int c = 0; c < C; c++) {
				if(input[c] == 'Z') {
					Z[0][0] = c; Z[0][1] = r;
				} else if(input[c] == 'M') {
					M[0][0] = c; M[0][1] = r;
				}
				EURO[r][c] = input[c];
			}
		}
		Queue<Integer> queue = new LinkedList<>();
		boolean findM = false;
		//M를 기준으로 파이프가 주변에 있을 때
		for(int i = 0; i < 4; i++) {
			int x = M[0][0] + dx[i];
			int y = M[0][1] + dy[i];
			if(x < 0 || x >= C || y < 0 || y >= R) continue;
			for(int k = 0; k < block[i].length; k++) {
				if(EURO[y][x] == block[i][k]) {
					findM = true;
					queue.add(x); queue.add(y); queue.add(M[0][0]); queue.add(M[0][1]);
					break;
				}
			}
			if(findM) break;
		}
		//Z를 기준으로 파이프가 주변에 있을 때
		boolean findZ = false;
		if(!findM) {
			for(int i = 0; i < 4; i++) {
				int x = Z[0][0] + dx[i];
				int y = Z[0][1] + dy[i];
				if(x < 0 || x >= C || y < 0 || y >= R) continue;
				for(int k = 0; k < block[i].length; k++) {
					if(EURO[y][x] == block[i][k]) {
						findZ = true;
						queue.add(x); queue.add(y); queue.add(Z[0][0]); queue.add(Z[0][1]);
						break;
					}
				}
				if(findZ) break;
			}
		}
		boolean findLoc = false;
		while(!findLoc) {
			int x = queue.remove();
			int y = queue.remove();
			int preX = queue.remove();
			int preY = queue.remove();
			switch(EURO[y][x]) {
			case '|' :
				if(preY < y) {
					queue.add(x);queue.add(y + 1);queue.add(x);queue.add(y);
				}
				else {
					queue.add(x); queue.add(y - 1);queue.add(x);queue.add(y);
				}
				break;
			case '-':
				if(preX < x) {
					queue.add(x+1);queue.add(y);queue.add(x);queue.add(y);
				}
				else {
					queue.add(x - 1);queue.add(y);queue.add(x);queue.add(y);
				}
				break;
			case '+': 
				if(preX < x) {
					queue.add(x + 1);queue.add(y);queue.add(x);queue.add(y);
				}
				else if(preX > x){
					queue.add(x - 1);queue.add(y);queue.add(x);queue.add(y);
				}
				else {
					if(preY < y) {
						queue.add(x);queue.add(y + 1);queue.add(x);queue.add(y);
					}
					else {
						queue.add(x); queue.add(y - 1);queue.add(x);queue.add(y);
					}
				}
				break;
			case '1':
				if(preX == x) {
					queue.add(x + 1); queue.add(y); queue.add(x); queue.add(y);
				}
				else {
					queue.add(x); queue.add(y + 1); queue.add(x); queue.add(y);
				}
				break;
			case '2':
				if(preX == x) {
					queue.add(x + 1); queue.add(y); queue.add(x); queue.add(y);
				}
				else {
					queue.add(x); queue.add(y - 1); queue.add(x); queue.add(y);
				}
				break;
			case '3':
				if(preX == x) {
					queue.add(x - 1); queue.add(y); queue.add(x); queue.add(y);
				}
				else {
					queue.add(x); queue.add(y - 1); queue.add(x); queue.add(y);
				}
				break;
			case '4':
				if(preX == x) {
					queue.add(x - 1); queue.add(y); queue.add(x); queue.add(y);
				}
				else {
					queue.add(x); queue.add(y + 1); queue.add(x); queue.add(y);
				}
				break;
			case '.':
				queue.add(x);queue.add(y);
				findLoc = true;
				break;
			}
		}
		int x = queue.remove();
		int y = queue.remove();
		//상
		if(y - 1 >= 0) {
			if(EURO[y - 1][x] != '.') {
				if(EURO[y - 1][x] == '|' || EURO[y - 1][x] == '+' || EURO[y - 1][x] == '1' || EURO[y - 1][x] == '4' || (EURO[y - 1][x] == 'Z' && !findZ)|| (EURO[y - 1][x] == 'M' && !findM))
					UP = true;
			}
		}
		//하
		if(y + 1 < R) {
			if(EURO[y + 1][x] != '.') {
				if(EURO[y + 1][x] == '|' || EURO[y + 1][x] == '+' || EURO[y + 1][x] == '2' || EURO[y + 1][x] == '3' || (EURO[y + 1][x] == 'Z' && !findZ) ||( EURO[y + 1][x] == 'M' && !findM))
					DOWN = true;
			}
		}
		
		//좌
		if(x - 1 >= 0) {
			if(EURO[y][x - 1] != '.') {
				if(EURO[y][x-1] == '-' || EURO[y][x-1] == '+' || EURO[y][x-1] == '1' || EURO[y][x-1] == '2' || (EURO[y][x-1] == 'Z'&& !findZ) || (EURO[y][x-1] == 'M' && !findM))
					LEFT = true;
			}
		}
		//우
		if(x + 1 < C) {
			if(EURO[y][x + 1] != '.') {
				if(EURO[y][x+1] == '-' || EURO[y][x+1] == '+' || EURO[y][x+1] == '3' || EURO[y][x+1] == '4' || (EURO[y][x+1] == 'Z'&& !findZ) || (EURO[y][x+1] == 'M' && !findM))
					RIGHT = true;
			}
		}
		char result;
		if(UP) {
			if(DOWN) {
				if(LEFT)
					result ='+';
				else
					result = '|';
			}
			else {
				if(LEFT) {
					result = '3';
				}
				else result = '2';
			}
		}
		else {
			if(DOWN) {
				if(LEFT) {
					result = '4';
				}
				else
					result = '1';
			}
			else {
				result = '-';
			}
		}
		System.out.println((y+1) + " " + (x+1) + " " + result);
	}

}

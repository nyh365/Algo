import java.util.*;
import java.io.*;

class Solution{
	static char[][] field;
	static int[] tank;
	static int H;
	static int W;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			field = new char[H][W];
			tank = new int[4];
			for(int i = 0; i < H; i++) {
				char[] c = br.readLine().toCharArray();
				for(int j = 0; j < W; j++) {
					if(c[j] == '^' || c[j] == 'v' || c[j] == '<' || c[j] == '>') {
						tank[0] = j; // 탱크의 x위치
						tank[1] = i; // 탱크의 y위치
						switch(c[j]) {
						case '^' : tank[2] = 0;  tank[3] = -1; break; 
						case 'v' : tank[2] = 0;  tank[3] = 1;break;
						case '<' : tank[2] = -1; tank[3] = 0; break;
						case '>' : tank[2] = 1;  tank[3] = 0; break;
						}
					}
					field[i][j] = c[j];
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			char[] command = br.readLine().toCharArray();
			
			for(int i = 0; i < N; i++) {
				switch(command[i]) {
				case 'U' : up(); break; 
				case 'D' : down(); break;
				case 'L' : left(); break;
				case 'R' : right(); break;
				case 'S' : shoot(); break;
				}
			}
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					sb.append(field[i][j]);
				}
				sb.append("\n");
			}
			
		}
		
		System.out.print(sb);
		
	}
	public static void up() {
		tank[2] = 0; tank[3] = -1;
		if(tank[1] - 1 >= 0) {
			if(field[tank[1] - 1][tank[0]] == '.') {
				field[tank[1]][tank[0]] = '.';
				field[tank[1] - 1][tank[0]] = '^';
				tank[1] -= 1;
			}
			else {
				field[tank[1]][tank[0]] = '^';
			}
		}
		else {
			field[tank[1]][tank[0]] = '^';
		}
		
	}
	public static void down() {
		tank[2] = 0; tank[3] = 1;
		if(tank[1] + 1 < H) {
			if(field[tank[1] + 1][tank[0]] == '.') {
				field[tank[1]][tank[0]] = '.';
				field[tank[1] + 1][tank[0]] = 'v';
				tank[1] += 1;
			}
			else {
				field[tank[1]][tank[0]] = 'v';
			}
		} else {
			field[tank[1]][tank[0]] = 'v';
		}
		
	}
	public static void left() {
		tank[2] = -1; tank[3] = 0;
		if(tank[0] - 1 >= 0) {			
			if(field[tank[1]][tank[0] - 1] == '.') {
				field[tank[1]][tank[0]] = '.';
				field[tank[1]][tank[0] - 1] = '<';
				tank[0] -= 1;
			}
			else {
				field[tank[1]][tank[0]] = '<';
			}
		} else {
			field[tank[1]][tank[0]] = '<';
		}
		
	}
	public static void right() {
		tank[2] = 1; tank[3] = 0;
		if(tank[0] + 1 < W) {			
			if(field[tank[1]][tank[0] + 1] == '.') {
				field[tank[1]][tank[0]] = '.';
				field[tank[1]][tank[0] + 1] = '>';
				tank[0] += 1;
			}
			else {
				field[tank[1]][tank[0]] = '>';
			}
		} else {
			field[tank[1]][tank[0]] = '>';
		}
		
	}
	public static void shoot() {
		int shot_x = tank[0];
		int shot_y = tank[1];
		if(tank[2] == 0) {
			while(true) {
				shot_x += tank[2];
				shot_y += tank[3];
				if(shot_y >= 0 && shot_y < H) {
					if(field[shot_y][shot_x] == '*') {
						field[shot_y][shot_x] ='.';
						break;
					}
					else if(field[shot_y][shot_x] == '#'){
						 break;
					}
				}else break;
			}
		}
		else {
			while(true) {
				shot_x += tank[2];
				shot_y += tank[3];
				if(shot_x >= 0 && shot_x < W) {
					if(field[shot_y][shot_x] == '*') {
						field[shot_y][shot_x] ='.';
						break;
					}
					else if(field[shot_y][shot_x] == '#'){
						 break;
					}
				}
				else break;
			}
		}
	}	
}

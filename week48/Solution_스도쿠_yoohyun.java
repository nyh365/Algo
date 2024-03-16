import java.io.*;
import java.util.*;

public class Main {
	static int[][] puzzle;
	static List<int[]> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        puzzle = new int[9][9];
        list = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
        	char[] input = br.readLine().toCharArray();
        	for(int j = 0; j < 9; j++) {
        		puzzle[i][j] = input[j] - '0';
        		if(puzzle[i][j] == 0) list.add(new int[] {j,i});
        	}
        }
        sudoku(0);
        for(int i = 0; i < 9; i++) {
        	for(int j = 0; j < 9; j++) {
        		sb.append(puzzle[i][j]);
        	}
        	sb.append("\n");
        }
        System.out.println(sb);
    }
    public static boolean sudoku(int count) {
    	if(count == list.size()) {
    		return true;
    	}
    	for(int i = 1; i <= 9; i++) {
    		int[] loc = list.get(count);
    		puzzle[loc[1]][loc[0]] = i;
    		if(rowCheck(loc[0], loc[1]) && colCheck(loc[0], loc[1]) && squareCheck(loc[0], loc[1])) {
    			if(sudoku(count+1)) return true;
    		}
    		puzzle[loc[1]][loc[0]] = 0;
    	}
    	return false;
    }
    public static boolean rowCheck(int x, int y) {
    	for(int j = 0; j < 9; j++) {
    		if(j != x) {
    			if(puzzle[y][j] == puzzle[y][x]) return false;
    		}
    	}
    	return true;
    }
    public static boolean colCheck(int x, int y) {
    	for(int i = 0; i < 9; i++) {
    		if(i != y) {
    			if(puzzle[i][x] == puzzle[y][x]) return false;
    		}
    	}
    	return true;
    }
    public static boolean squareCheck(int x, int y) {
    	int xStart = x / 3 * 3;
    	int yStart = y / 3 * 3;
    	for(int i = yStart; i < yStart + 3; i++) {
    		for(int j = xStart; j < xStart + 3; j++) {
    			if(x == j && y == i) continue;
    			if(puzzle[i][j] == puzzle[y][x]) return false;
    		}
    	}
    	return true;
    }
}

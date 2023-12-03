import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char cur[][] = new char[N][N];
		int result = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) {
				cur[i][j] = s.charAt(j);
			}
		}		
		
		for(int i = 0; i < (1 << N); i++) {
			int result0 = 0;
			int[] c = new int[N];
			String s = Integer.toBinaryString(i);
			if(s.length() < N) {
				String tmp ="";
				int size = N - s.length();
				for(int j = 0; j < size; j++)
					tmp += "0";
				s = tmp + s;
			}
			for(int j = 0; j < N; j++)
				c[j] = s.charAt(j) -'0';
				
			for(int j = 0; j < c.length ; j++) {
				if(c[j] == 1) {
					reverseRow(cur[j]);
				}	
			}
			for(int j = 0; j < N; j++) {
				result0 += countOfT(cur, j);
			}
			result = Math.min(result0, result);
			for(int j = 0; j < c.length ; j++) {
				if(c[j] == 1) {
					reverseRow(cur[j]);
				}	
			}
		}
		
		System.out.print(result);
	}
	
	public static void reverseRow(char[] arr) {
		for(int j = 0; j < arr.length; j++) {
			if(arr[j] == 'H')
				arr[j] = 'T';
			else
				arr[j] = 'H';
		}
	}
	public static int countOfT(char[][] arr, int j) {
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i][j] == 'T')
				count++;
		}
		return Math.min(count, arr.length - count);
	}
}

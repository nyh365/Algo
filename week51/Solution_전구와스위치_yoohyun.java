import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int cur0[] = new int[N];
		int cur1[] = new int[N];
		int result[] = new int[N];
		int count0 = 0;
		int count1 = 0;
		String s1 = br.readLine();
		String s2 = br.readLine();
		for(int i = 0; i < N; i++) {
			cur0[i] = s1.charAt(i) - '0';
			cur1[i] = s1.charAt(i) - '0';
			result[i] = s2.charAt(i) - '0';
		}
		
		for(int i = 1; i < N; i++) {
			if(cur0[i-1] != result[i-1]) {
				count0++;
				if(i != N - 1) {
					cur0[i-1] = 1-cur0[i-1];
					cur0[i] = 1-cur0[i];
					cur0[i + 1] = 1-cur0[i + 1];
				}
				else {
					cur0[i-1] = 1-cur0[i-1];
					cur0[i] = 1-cur0[i];
				}
			}
		}
		cur1[0] = 1-cur1[0];
		cur1[1] = 1-cur1[1];
		count1++;
		for(int i = 1; i < N; i++) {
			if(cur1[i-1] != result[i-1]) {
				count1++;
				if(i != N - 1) {
					cur1[i-1] = 1-cur1[i-1];
					cur1[i] = 1-cur1[i];
					cur1[i + 1] = 1-cur1[i + 1];
				}
				else {
					cur1[i-1] = 1-cur1[i-1];
					cur1[i] = 1-cur1[i];
				}
			}
		}
		if(isValid(cur0, result))
			System.out.print(count0);
		else if(isValid(cur1, result))
			System.out.print(count1);
		else
			System.out.println(-1);
		
	}
	
	public static boolean isValid(int[] arr1, int[] arr2) {
		for(int i = 0; i < arr1.length; i++) {
			if(arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}	
}

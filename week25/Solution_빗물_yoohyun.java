import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[] apt = new int[W];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < W; i++) {
			apt[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		int tmp;
		for(int i = 0; i < W; i++) {
			int leftMax = 0;
			int rightMax = 0;
			
			for(int j = 0; j < i; j++) {
				leftMax = Math.max(leftMax, apt[j]);
			}
			
			for(int j = i + 1; j < W; j++) {
				rightMax = Math.max(rightMax, apt[j]);
			}
			tmp = Math.min(leftMax, rightMax);
			if(tmp <= apt[i]) continue;
			result += tmp - apt[i];
		}
		System.out.print(result);
	}
}

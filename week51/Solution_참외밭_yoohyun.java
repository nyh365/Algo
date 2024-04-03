import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int arr[][] = new int[6][2];
		int area = 0;
		int width = 0;
		int heigh = 0;
		int N = Integer.parseInt(br.readLine());
		int max_width = Integer.MIN_VALUE;
		int max_heigh = Integer.MIN_VALUE;
		int max_w_index = -1;
		int max_h_index = -1;
		for(int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}	
		for(int i = 0; i < 6; i++) {
			int tmp  = arr[i][0];
			if(tmp == 1 || tmp == 2) {
				if(arr[i][1] > max_width) {
					max_width = arr[i][1];
					max_w_index = i;
				}
			}else {
				if(arr[i][1] > max_heigh) {
					max_heigh = arr[i][1];
					max_h_index = i;
				}
			}
		}
		if(max_w_index == 0) {
			heigh = Math.abs(arr[5][1] - arr[1][1]);
		}else if(max_w_index == 5) {
			heigh = Math.abs(arr[0][1] - arr[4][1]);
		}else {
			heigh = Math.abs(arr[max_w_index - 1][1] - arr[max_w_index + 1][1]);
		}
		
		if(max_h_index == 0) {
			width = Math.abs(arr[5][1] - arr[1][1]);
		}else if(max_h_index == 5) {
			width = Math.abs(arr[0][1] - arr[4][1]);
		}else {
			width = Math.abs(arr[max_h_index - 1][1] - arr[max_h_index + 1][1]);
		}
		area = max_width * max_heigh - heigh * width;
		System.out.println(area * N);
	}
}

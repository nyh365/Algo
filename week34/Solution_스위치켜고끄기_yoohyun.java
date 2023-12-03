import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N + 1];
		int student;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		student = Integer.parseInt(br.readLine());
		for(int i = 0; i < student; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());
			if(gender == 1) {
				int j = 1;
				int tmp = number;
				while(tmp <= N) {
					arr[tmp] = 1 - arr[tmp];
					tmp = number * ++j; 
				}
			}else {
				int cnt = 1;
				while(number - cnt >= 1 && number + cnt <= N) {
					if(arr[number - cnt] == arr[number + cnt]) {
						arr[number - cnt] = arr[number + cnt] = 1-arr[number + cnt]; 
						cnt++;
					}else break;
					
				}
				arr[number] = 1-arr[number];
			}
		}
		for(int i = 1; i <= N; i++) {
			System.out.print(arr[i] + " ");
			if(i % 20 == 0)
				System.out.println();
			
		}
	}
}

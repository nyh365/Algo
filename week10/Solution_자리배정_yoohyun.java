import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int find = Integer.parseInt(br.readLine());
		int x = 1, y = 1;
		int flag = 0;
		int heigh = R, width = C;
		int wall = 0;
		int order = 1;
		int cnt = 1;
		while(true) {
			if(order == 1) {
				cnt--;
				for(int i = y; i <= heigh - wall; i++) {
					cnt++;
					if(cnt == find) {
						flag = 1;
						break;
					}
					if(i != heigh - wall)
						y++;
				}
			}
			else if(order == 2) {
				cnt--;
				for(int i = x ; i <= width - wall; i++) {
					cnt++;
					if(cnt == find) {
						flag = 1;
						break;
					}
					if(i != width - wall)
						x++;
				}
			}
			else if(order == 3) {
				cnt--;
				for(int i = y; i >= wall + 1; i--) {
					cnt++;
					if(cnt == find) {
						flag = 1;
						break;
					}
					if(i != wall + 1)
						y--;
				}
				wall += 1;
			}
			else if(order == 4) {
				cnt--;
				for(int i = x; i >= wall + 1; i--) {
					cnt++;
					if(cnt == find) {
						flag = 1;
						break;
					}
					if(i != wall + 1)
						x--;
				}
			}
			if(flag == 1) break;
			else {
				if(cnt == C * R) {
					flag = - 1;
					break;
				}
			}
			order = (order) % 4 + 1;
		}
		if(flag != -1)
			System.out.println(x + " "  + y);
		else
			System.out.println(0);
	}
}

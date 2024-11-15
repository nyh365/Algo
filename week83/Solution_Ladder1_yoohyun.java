import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= 10; test_case++) {
			br.readLine();
			sb.append("#").append(test_case).append(" ");
			int[][] ladder = new int[100][100];
			int[] dy = { 0, 0, -1};
			int[] dx = { -1, 1, 0};
			int des = -1;
			
			for(int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 0; i < 100; i++) {
				if(ladder[99][i] == 2) {
					des = i; break;
				}
			}
			
			int x = des; int y = 99;
			while(y > 0) {
				for(int i = 0; i < 3; i++) {
					if(x + dx[i] >= 0 && x + dx[i] < 100 && ladder[y + dy[i]][x + dx[i]] == 1) {
						ladder[y + dy[i]][x + dx[i]] = 0;
						x += dx[i];
						y += dy[i];
						
					}
				}
			}
			sb.append(x).append("\n");			
		}
		System.out.println(sb);
	}
}

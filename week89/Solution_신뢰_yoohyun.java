import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			int total = 0;
			int O_Cur = 1, B_cur = 1;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			char prev = ' ';
			int prev_t = 0;
			for(int i = 0; i < N; i++) {
				char color = st.nextToken().charAt(0);
				int move = Integer.parseInt(st.nextToken());
				if(i == 0)
					prev = color;
				if(color == 'B') {
					int time = Math.abs(move - B_cur);
					if(prev == 'B') {
						total += time + 1;
						B_cur = move;
						prev_t += time + 1;
					}
					else {
						total += time <= prev_t ? 1 : time + 1 - prev_t;
						B_cur = move;
						prev_t = time <= prev_t ? 1 : time + 1 - prev_t;
					}
					prev = 'B';
				}
				else {
					int time = Math.abs(move - O_Cur);
					if(prev == 'O') {
						total += time + 1;
						O_Cur = move;
						prev_t += time + 1;
					}
					else {
						total += time <= prev_t ? 1 : time + 1 - prev_t;
						O_Cur = move;
						prev_t = time <= prev_t ? 1 : time + 1 - prev_t;
					}
					prev = 'O';
				}
			}
			sb.append(total).append("\n");
		}
		System.out.print(sb);
	}
}

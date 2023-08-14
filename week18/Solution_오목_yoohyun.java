import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
  public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int board[][] = new int[19][19];
		int dx[] = {1, 0, 1, -1};
		int dy[] = {0, 1, 1, 1};
		StringTokenizer st;
		for(int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 19; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < 19; i++) {
			for(int j = 0; j < 19; j++) {
				if(board[j][i] == 1 || board[j][i] == 2) {
					for(int k = 0; k < 4; k++) {
						int x = i; int y = j;
						int cnt = 1;
						while(true) {
							x += dx[k];
							y += dy[k];
							if(x >= 0 && x < 19 && y >= 0 && y < 19) {
								if(board[j][i] == board[y][x]) cnt++;
								else break;
							}
							else break;
						}
						
						x = i; y = j;
						
						while(true) {
							x -= dx[k];
							y -= dy[k];
							if(x >= 0 && x < 19 && y >= 0 && y < 19) {
								if(board[j][i] == board[y][x]) cnt++;
								else break;
							}
							else break;
						}
						
						if(cnt == 5) {
							System.out.println(board[j][i]);
							System.out.println((j + 1) + " " + (i + 1));
							return;
						}
						
					}
				}
			}
		}
		System.out.println(0);
	}
}

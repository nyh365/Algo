import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static final int EXPONENT_1 = 31;
	private static final int EXPONENT_2 = 33;
	static int[][] eungi, teacher;
	static int H, W, N, M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			st = new StringTokenizer(br.readLine());
			
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			eungi = new int[H][W];		
			for(int i = 0; i < H; i++) {
				char[] input = br.readLine().toCharArray();
				for(int j = 0; j < W; j++) {
					eungi[i][j] = (input[j] == 'o'? 1 : 0);
				}
			}
			
			teacher = new int[N][M];
			for(int i = 0; i < N; i++) {
				char[] input = br.readLine().toCharArray();
				for(int j = 0; j < M; j++) {
					teacher[i][j] = (input[j] == 'o'? 1 : 0);
				}
			}
			
			sb.append(solve()).append("\n");
		}
		System.out.print(sb);
	}
	public static int solve() {
		int[][] teacherRowHash = rowHash(N, M, W, teacher);
		int[][] eungiRowHash = rowHash(H, W, W, eungi);
		
		int[][] teacherColHash = colHash(N, teacherRowHash[0].length, H, teacherRowHash);
		int[][] eungiColHash = colHash(H, eungiRowHash[0].length, H, eungiRowHash);
		
		return countCnt(teacherColHash.length, teacherColHash[0].length, eungiColHash, teacherColHash);
	}
	public static int[][] rowHash(int height, int width, int length, int[][] paint){
		int newLength = width - length + 1;
		int[][] hashed = new int[height][newLength];
		for(int j = 0; j < height; j++) {
			int pow1 = 1;
			int tempHash1 = 0;
			
			for(int k = 0; k < newLength; k++) {
				if(k == 0) {
					for(int l = 0; l < length; l++) {
						tempHash1 += pow1 * paint[j][k + length -l - 1];
						
						if(l != length - 1) {
							pow1 *= EXPONENT_1;
						}
					}
				} else {
					tempHash1 = EXPONENT_1 * (tempHash1 - pow1 * paint[j][k - 1]) + paint[j][k + length - 1]; 
				}
				hashed[j][k] = tempHash1;
			}
		}
		return hashed;
	}
	public static int[][] colHash(int height, int width, int length, int[][] rowHashedPaint){
		int newLength = height - length + 1;
		int[][] hashed = new int[newLength][width];
		for(int j = 0; j < width; j++) {
			int pow1 = 1;
			int tempHash1 = 0;
			
			for(int k = 0; k < newLength; k++) {
				if(k == 0) {
					for(int l = 0; l < length; l++) {
						tempHash1 += pow1 * rowHashedPaint[k + length -l - 1][j];
						
						if(l != length - 1) {
							pow1 *= EXPONENT_2;
						}
					}
				} else {
					tempHash1 = EXPONENT_2 * (tempHash1 - pow1 * rowHashedPaint[k - 1][j]) + rowHashedPaint[k + length - 1][j];
				}
				hashed[k][j] = tempHash1;
			}
		}
		return hashed;
	}
	public static int countCnt(int height, int weight, int[][] eungiResult, int[][] teacherResult) {
		int result = 0;
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < weight; j++) {
				if(teacherResult[i][j] == eungiResult[0][0]) {
					result++;
				}
			}
		}
		return result;
	}
}

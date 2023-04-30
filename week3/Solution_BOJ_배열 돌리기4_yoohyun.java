import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int[][] arr;
	static int N, M;
	static int result = Integer.MAX_VALUE;
	public static void main(String arge[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		int[][] copy = new int[N][M];
		// 사각형에 숫자 입력받기
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// K개의 (r,c,s) 입력받기
		int[][] comm = new int[K][3];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			comm[i][0] = Integer.parseInt(st.nextToken());
			comm[i][1] = Integer.parseInt(st.nextToken());
			comm[i][2] = Integer.parseInt(st.nextToken());
		}
		// 순열에 넣을 배열 만들기
		int[] order = new int[K];
		for(int i = 0; i < K; i++) {
			order[i] = i;
		}
		// 순열로 만들어진 순서대로 사각형을 회전시키며 최솟값 구하기
		do {
			squareCopy(copy);
			for(int i = 0; i < K; i++) {
				rotation(copy,comm[order[i]][0], comm[order[i]][1], comm[order[i]][2]);
			}
			rowMinValue(copy);
		}while(next_permutation(order));
		
		System.out.print(result);
	}
	// 회전
	public static void rotation(int[][] copy, int r, int c, int s) {
		int cnt = 0;
		int x1 = c - s - 1, y1 = r - s - 1;
        int x2 = c + s - 1, y2 = r + s - 1;
		while (true) {
            x1 += cnt; y1 += cnt;
            x2 -= cnt; y2 -= cnt;
            if(x1 >= x2 || y1 >= y2)
                break;
            int pre = copy[y1][x1];
 
            for (int j = x1; j <= x2; j++) {
                int temp = copy[y1][j];
                copy[y1][j] = pre;
                pre = temp;
            }
 
            for (int i = y1 + 1; i <= y2; i++) {
                int temp = copy[i][x2];
                copy[i][x2] = pre;
                pre = temp;
            }
 
            for (int j = x2 - 1; j >= x1; j--) {
                int temp = copy[y2][j];
                copy[y2][j] = pre;
                pre = temp;
            }
 
            for (int i = y2 -1; i >= y1; i--) {
                int temp = copy[i][x1];
                copy[i][x1] = pre;
                pre = temp;
            }
            cnt = 1;
        }
	}
	//사각형의 각 행의 합 중 최솟값 구하기
	public static void rowMinValue(int[][] copy) {
		for(int i = 0; i < N; i++) {
			int sum = 0;
			for(int j = 0; j < M; j++) {
				sum += copy[i][j];
			}
			result = Math.min(result, sum);
		}
	}
	// 순열 구하기
	public static boolean next_permutation(int[] numbers) { 
		int i = numbers.length - 1;
		while(i > 0 && numbers[i - 1] >= numbers[i]) --i;
		if(i == 0) return false;
		
		int j = numbers.length - 1;
		while(numbers[i - 1] >= numbers[j]) --j;
		
		swap(numbers, i - 1, j);
		
		int k = numbers.length - 1;
		while(i < k) {
			swap(numbers, i++, k--);
		}
		
		return true;
		
	}
	public static void swap(int[] numbers, int i, int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}
	public static void squareCopy(int[][] copy){
        for(int i = 0; i < N; i++){
        	for(int j = 0; j < M; j++)
        		copy[i][j] = arr[i][j];
        }
    }
}

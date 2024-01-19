import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arrA = new int[N];
		int[] arrB = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}
		
		int indexA = 0, indexB = 0;
		while(true) {
			if(indexA == N && indexB == M) break;
			if(indexA == N) {
				sb.append(arrB[indexB++]).append(" ");
			}
			else if(indexB == M) {
				sb.append(arrA[indexA++]).append(" ");
			} else {
				if(arrA[indexA] > arrB[indexB]) {
					sb.append(arrB[indexB++]).append(" ");
				}
				else if(arrA[indexA] < arrB[indexB]) {
					sb.append(arrA[indexA++]).append(" ");
				}
				else {
					sb.append(arrA[indexA++]).append(" ");
					sb.append(arrB[indexB++]).append(" ");
				}
			}
		}
		System.out.print(sb);
	}
}

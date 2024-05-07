import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int result = 0;
	static int R;
	static int C;
	public static void main(String arge[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		quarter(0, 0, (int) Math.pow(2, N));
		System.out.println(result);
		
	}
	public static void quarter(int r, int c, int size) {
		int half = size / 2;
		if(size == 1)
			return;
		if(R < r + half && C < c + half ) {
			quarter(r, c, half);
			return;
		}else {
			result += half * half;
		}
		
		if(R < r + half && c + half <= C) {
			quarter(r, c + half, half);
			return;
		}else {
			result += half * half;
		}
		
		if(r + half <= R && C < c + half ) {
			quarter(r + half, c, half);
			return;
		}else {
			result += half * half;
		}
		
		if(r + half <= R && c + half <= C) {
			quarter(r + half, c + half, half);
			return;
		}
	}
}

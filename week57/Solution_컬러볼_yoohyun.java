import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
 
public class Main{
	public static class ColorBall {
		int color, size, num, total;
		
		public ColorBall(int color, int size, int num) {
			this.color = color;
			this.size = size;
			this.num = num;
		}
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        ColorBall[] colorBalls = new ColorBall[N];
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	colorBalls[i] = new ColorBall(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
        }
        
        Arrays.sort(colorBalls, (a, b) -> Integer.compare(a.size, b.size) == 0 ? Integer.compare(a.color, b.color) : Integer.compare(a.size, b.size));
        
        int[] totals = new int[N + 1];
        int[] colors = new int[N + 1];
        int[] temp = new int[] {colorBalls[0].size, colorBalls[0].size};
        colors[colorBalls[0].color] = colorBalls[0].size;

        for(int i = 1; i < N; i++) {
        	if(colorBalls[i].size == colorBalls[i - 1].size) {
        		colors[colorBalls[i].color] += colorBalls[i].size;
        		if(colorBalls[i - 1].color != colorBalls[i].color) {
        			totals[colorBalls[i - 1].color] += colors[colorBalls[i - 1].color];
        			colors[colorBalls[i - 1].color] = 0;
        		}
        		temp[1] += colorBalls[i].size;
        		colorBalls[i].total = totals[0] - totals[colorBalls[i].color];
        	} else {
        		totals[0] += temp[1];
        		temp[0] = colorBalls[i].size;
        		temp[1] = temp[0];
        		
        		totals[colorBalls[i - 1].color] += colors[colorBalls[i - 1].color];
        		colors[colorBalls[i - 1].color] = 0;
        		
        		colorBalls[i].total = totals[0] - totals[colorBalls[i].color];
        		colors[colorBalls[i].color] += colorBalls[i].size;
        	}
        }
        
        Arrays.sort(colorBalls, (a,b) -> Integer.compare(a.num, b.num));
        for(ColorBall cb : colorBalls) {
        	sb.append(cb.total).append("\n");
        }
        System.out.print(sb);
    }
}

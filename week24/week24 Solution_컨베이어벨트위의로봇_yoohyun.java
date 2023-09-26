import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] boxes;
	static boolean[] robots;
	static int n, k, total;


	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		boxes = new int[2 * n];
		robots = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 2 * n; i++) {
			boxes[i] = Integer.parseInt(st.nextToken());
		} 
		
		int result = 0;
		while(!isOver()) {
			result++;
			moveBelt();
			moveRobot();
			insertRobot();
		}
		System.out.print(result);
	}
	public static void moveBelt() {
		int tmp = boxes[2 * n - 1];
		for(int i = 2 * n - 1; i > 0; i--) {
			boxes[i] = boxes[i - 1];
		}
		boxes[0] = tmp;
		
		for(int i = n - 1 ; i > 0; i--) {
			robots[i] = robots[i - 1];
		}
		
		robots[0] = false;
		robots[n - 1] = false;
	}
	
	public static void moveRobot() {
		for(int i = n - 2; i >= 0; i--) {
			if(!robots[i]) continue;
			if(boxes[i + 1] < 1) continue;
			if(robots[i + 1]) continue;
			
			
			robots[i + 1] = true;
			boxes[i + 1] -= 1;
			if(boxes[i + 1] == 0) total++;
			robots[i] = false;
		}
	}
	
	public static void insertRobot() {
		if(boxes[0] > 0) {
			robots[0] = true;
			boxes[0] -= 1;
			if(boxes[0] == 0) total++;
		}
	}
	
	public static boolean isOver() {
		return total >= k ? true : false;
	}
}





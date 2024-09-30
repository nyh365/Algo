import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
 
public class Main{
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	int N = Integer.parseInt(br.readLine());
    	long[][] points = new long[N][2];

    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		points[i][0] = Integer.parseInt(st.nextToken());
    		points[i][1] = Integer.parseInt(st.nextToken());
    	}

    	int result = 0;
    	long a, b, c;
    	for(int i = 0; i < N; i++) {
    		for(int j = i + 1; j < N; j++) {
    			for(int k = j + 1; k < N; k++) {
    				a = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);  
    				b = (points[i][0] - points[k][0]) * (points[i][0] - points[k][0]) + (points[i][1] - points[k][1]) * (points[i][1] - points[k][1]);  
    				c = (points[k][0] - points[j][0]) * (points[k][0] - points[j][0]) + (points[k][1] - points[j][1]) * (points[k][1] - points[j][1]);  
    			
    				if((a == b + c ) ||(b == a + c)|| (c == a + b)) result++;
    			}
    		}
    	}
    	System.out.println(result);
	}
}

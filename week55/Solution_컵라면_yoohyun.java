import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main{
    public static class Problem {
    	int day, noodle;
    	
    	public Problem(int day, int noodle) {
    		this.day = day;
    		this.noodle = noodle;
    	}
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Problem> decDay = new PriorityQueue<>((a,b) -> Integer.compare(b.day, a.day) == 0 ? Integer.compare(b.noodle, a.noodle) : Integer.compare(b.day, a.day));
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	decDay.add(new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        
        PriorityQueue<Problem> decNoodle = new PriorityQueue<>((a,b) -> Integer.compare(b.noodle, a.noodle));
        int cur = decDay.peek().day;
        long result = 0;
        while(cur > 0) {
        	while(!decDay.isEmpty() ) {
        		if(decDay.peek().day >= cur) {
        			decNoodle.add(decDay.remove());
        		} else {
        			break;
        		}
        	}
        	Problem curP = decNoodle.isEmpty() ? decDay.remove() : decNoodle.remove();
        	cur = cur > curP.day ? curP.day - 1 : cur - 1;
        	result += curP.noodle;
        }
        System.out.print(result);
    }
}

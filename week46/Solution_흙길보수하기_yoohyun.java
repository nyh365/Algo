import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
 
public class Main{
	public static class Hole implements Comparable<Hole> {
		int start, end;

		public Hole(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Hole o) {
			return Integer.compare(this.start, o.start);
		}
	}
	
	public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int L = Integer.parseInt(st.nextToken());
    	
    	Hole[] holes = new Hole[N];
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		holes[i] = new Hole(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    	}
    	
    	Arrays.sort(holes);

    	int total = 0, end = 0, cnt = 0;    	
    	for(int i = 0; i < holes.length; i++) {
    		if(end <= holes[i].start) {
    			cnt = (holes[i].end - holes[i].start - 1) / L + 1;
    			end = holes[i].start + L * cnt;
    		} else {
    			if(holes[i].end <= end) continue;
    			cnt = (holes[i].end - end - 1) / L + 1;
    			end = end + L * cnt;
    		}
    		total += cnt;
    	}
    	System.out.print(total);
	}
}

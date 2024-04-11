import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Meeting[] meeting = new Meeting[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meeting[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(meeting);
		
		int result = 0;
		int last = -1;
		for(int i = 0; i < N; i++) {
			if(last <= meeting[i].start) {
				result++;
				last = meeting[i].end;
			}
		}
		
		
		System.out.print(result);
	}
	static class Meeting implements Comparable<Meeting>{
		int start, end;
		public Meeting(int start, int end){
			this.start = start;
			this.end = end;
		}
		public int compareTo(Meeting e) {
			if(this.end < e.end) {
				return -1;
			}
			else if(this.end == e.end) {
				if(this.start < e.start)
					return -1;
				else if(this.start == e.end)
					return 0;
				else 
					return 1;
			}
			else
				return 1;
		}
	}
}

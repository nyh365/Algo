import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main{
	public static class Lecture implements Comparable<Lecture> {
		int cost, day;
		
		public Lecture(int cost, int day) {
			this.cost = cost;
			this.day = day;
		}
		public int compareTo(Lecture lecture) {
			return Integer.compare(lecture.cost, this.cost) == 0 ? Integer.compare(lecture.day, this.day) : Integer.compare(lecture.cost, this.cost);
		}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[10001];
        Lecture[] lectures = new Lecture[N];
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	lectures[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        
        Arrays.sort(lectures);
        
        int total = 0;
        for(int i = 0; i < N; i++) {
        	for(int j = lectures[i].day; j >= 1; j--) {
        		if(!visited[j]) {
        			total += lectures[i].cost;
        			visited[j] = true;
        			break;
        		}
        	}
        }
        
        System.out.print(total);
    }
}

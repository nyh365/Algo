import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        PriorityQueue<Lecture> lectures = new PriorityQueue<>();
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	lectures.add(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        
        int total = 0;
        while(!lectures.isEmpty()) {
        	Lecture cur = lectures.remove();
        	
        	for(int i = cur.day; i >= 1; i--) {
        		if(!visited[i]) {
        			total += cur.cost;
        			visited[i] = true;
        			break;
        		}
        	}
        }
        
        System.out.print(total);
    }
}

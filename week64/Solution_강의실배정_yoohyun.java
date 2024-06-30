import java.io.*;
import java.util.*;

public class Main {
    static class Lecture implements Comparable<Lecture>{
        int start, end;

        public Lecture(int start, int end){
            this.start = start;
            this.end = end;
        }

        public int compareTo(Lecture lecture){
            return Integer.compare(this.end, lecture.end) == 0 ? Integer.compare(this.start, lecture.start) : Integer.compare(this.end, lecture.end);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[N];

        int s,e;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
        
            lectures[i] = new Lecture(s, e);
        }

        Arrays.sort(lectures);

        int result = 0, curEnd = 0;
        for(int i = 0; i < N; i++){
            if(lectures[i].start >= curEnd){
                ++result;
                curEnd = lectures[i].end;
            }
        }
        System.out.print(result);
    }
}

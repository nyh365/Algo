import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Student implements Comparable<Student> {
        String name;
        int day, month, year;

        public Student(String name, String day, String month, String year) {
            this.name = name;
            this.day = Integer.parseInt(day);
            this.month = Integer.parseInt(month);
            this.year = Integer.parseInt(year);
        }

        public int compareTo(Student other) {
            if (this.year != other.year) return Integer.compare(this.year, other.year);
            if (this.month != other.month) return Integer.compare(this.month, other.month);
            return Integer.compare(this.day, other.day);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        Student[] students = new Student[N];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            students[i] = new Student(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken());
        }
        
        Arrays.sort(students);

        System.out.println(students[N - 1].name);
        System.out.println(students[0].name);
    }
}

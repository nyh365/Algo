import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
 
public class Main{
	public static class City implements Comparable<City>{
		int x, people;

		public City(int x, int people) {
			this.x = x;
			this.people = people;
		}

		public int compareTo(City o) {
			return Integer.compare(this.x, o.x);
		}
	}
	public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;

    	int N = Integer.parseInt(br.readLine());
    	City[] cities = new City[N];
    	
    	long total = 0;
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		cities[i] = new City(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    		total += cities[i].people;
    	}
    	
    	total = (total + 1) / 2;
    	Arrays.sort(cities);
    	
    	long curCnt = 0;
    	for(int i = 0; i < N; i++) {
    		curCnt += cities[i].people;
    		if(curCnt >= total) {
    			System.out.print(cities[i].x);
    			break;
    		}
    	}
	}
}

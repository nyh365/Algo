import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
 
public class Main{
	public static class Meat implements Comparable<Meat> {
		int weight, cost;
		public Meat(int weight, int cost){
			this.weight = weight;
			this.cost = cost;
		}
		
		public int compareTo(Meat meat) {
			return Integer.compare(this.cost, meat.cost) == 0 ? Integer.compare(meat.weight, this.weight) : Integer.compare(this.cost, meat.cost);
		}
	}
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Meat[] meats = new Meat[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			meats[i] = new Meat(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(meats);
		int result = Integer.MAX_VALUE;
		boolean flag = false;
		int prePrice = -1;
		int total = 0;
		int cost = 0;
		for(int i = 0; i < N; i++) {
			total += meats[i].weight;
			
			if(meats[i].cost == prePrice) {
				cost += meats[i].cost;
			} else {
				cost = meats[i].cost;
			}
			
			if(total >= K) {
				flag = true;
				result = Math.min(result, cost);
			}
			
			prePrice = meats[i].cost;
		}
		
		System.out.print(flag ? result : -1);
	}
}

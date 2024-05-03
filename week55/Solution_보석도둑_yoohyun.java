import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main{
	public static class Jewelry {
		int price, weight;
		
		public Jewelry(int weight, int price) {
			this.price = price;
			this.weight = weight;
		}
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Jewelry> ascWeight = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	ascWeight.add(new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        
        int[] bags = new int[K];
        for(int i = 0; i < K; i++) {
        	bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);
        
        PriorityQueue<Jewelry> descPrice = new PriorityQueue<>((a, b) -> Integer.compare(b.price, a.price));
        long result = 0;
        for(int i = 0; i < K; i++) {
        	while(!ascWeight.isEmpty()) {
        		if(ascWeight.peek().weight > bags[i]) break;
        		descPrice.add(ascWeight.remove());
        	}
        	
        	if(!descPrice.isEmpty()) {
        		result += descPrice.remove().price;
        	}
        }
        System.out.print(result);
    }
}

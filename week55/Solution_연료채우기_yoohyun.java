import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main{
	public static class GasStation {
		int dis, fuel;
		
		public GasStation(int dis, int fuel) {
			this.dis = dis;
			this.fuel = fuel;
		}
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<GasStation> ascDis = new PriorityQueue<>((a,b) -> Integer.compare(a.dis, b.dis));
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	ascDis.add(new GasStation(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        
        st = new StringTokenizer(br.readLine());
        int town = Integer.parseInt(st.nextToken());
        int curFuel = Integer.parseInt(st.nextToken());
        int result = 0, curLoc = 0;
        
        PriorityQueue<GasStation> descFuel = new PriorityQueue<>((a,b) -> Integer.compare(b.fuel, a.fuel));
        while(curLoc + curFuel < town) {
        	while(!ascDis.isEmpty()) {
        		if(ascDis.peek().dis > curLoc + curFuel) break;
        		descFuel.add(ascDis.remove());
        	}
        	
        	if(descFuel.isEmpty()) break;
        	else {
        		GasStation temp = descFuel.remove();
        		result++;
        		curFuel = curFuel - (temp.dis - curLoc) + temp.fuel;
        		curLoc = temp.dis;
        	}
        }
        
        System.out.print(curLoc + curFuel >= town ? result : -1);
    }
}

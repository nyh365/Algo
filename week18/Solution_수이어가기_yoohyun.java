import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());		
		ArrayList<Integer> list = new ArrayList<>();
		int max = 0;
		
		for(int i = 1; i <= N; i++) {
			ArrayList<Integer> tmp = new ArrayList<>();
			tmp.add(N);
			tmp.add(i);
			int pprev = N;
			int prev = i;
			
			while( pprev - prev >= 0) {
				tmp.add(pprev - prev);
				int temp = pprev;
				pprev = prev;
				prev = temp - prev;
			}
			if(max < tmp.size()) {
				list = tmp;
				max = tmp.size();
			}
		}
		System.out.println(list.size());
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}			
	}
}

import java.io.*;
import java.util.*;


public class Main {
	
	public static void main (String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> q = new PriorityQueue<>((n1, n2) -> {
			int abs_n1 = Math.abs(n1);
			int abs_n2 = Math.abs(n2);
			if(abs_n1 >abs_n2)
				return 1;
			else if(abs_n1 <abs_n2)
				return -1;
			else {
				if(n1 < n2)
					return -1;
				else if(n1 > n2)
					return 1;
				else 
					return 0;
			}
			
		});
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N ;i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				if(q.isEmpty()) 
					sb.append("0" + "\n");
                else 
                	sb.append(q.poll() + "\n");
			}
			else {
				q.add(x);
			}
		}
		System.out.print(sb);
	}
}

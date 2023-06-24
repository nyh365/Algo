import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken()), q = Integer.parseInt(st.nextToken());
		int hour = Integer.parseInt(br.readLine());
		
		p = (p + hour) % (2*w);
		q = (q + hour) % (2*h);
		
		if(p > w)
			p = 2 * w - p;
		if(q > h)
			q = 2 * h - q;
		sb.append(p).append(" ").append(q);
		System.out.println(sb);
	}
}  

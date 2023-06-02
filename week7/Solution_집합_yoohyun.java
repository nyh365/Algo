import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());

		int S = 0;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String comm = st.nextToken();
			int num;
			
			switch(comm) {
			case "add" :
				num = Integer.parseInt(st.nextToken());
				S |= (1 << (num-1));
				break;
			case "check" : 
				num = Integer.parseInt(st.nextToken());
				if((S & (1 << (num-1))) != 0) sb.append("1").append("\n");
				else sb.append("0").append("\n");
				break;
			case "remove" :
				num = Integer.parseInt(st.nextToken());
				S &= ~(1 << (num-1));
				break;
			case "toggle" : //1 ->0 0 -> 1 11101 => 11111, 11111 => 11101
				num = Integer.parseInt(st.nextToken());
				S ^= (1 << (num-1));
				break;
			case "all" :
				S |= ~(1 << 21);
				break;
			case "empty" :
				S = 0;
				break;
			}
		}
		System.out.println(sb);
	}
}

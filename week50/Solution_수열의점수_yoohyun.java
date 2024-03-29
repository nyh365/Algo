import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
 
public class Main{
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		LinkedList<Long> minus = new LinkedList<>();
		LinkedList<Long> plus = new LinkedList<>();
		int zero = 0;
		
		long num = 0;
		long result = 0;
		for(int i = 0; i < N; i++) {
			num = Integer.parseInt(br.readLine());
			if(num < 0) {
				minus.add(num);
			} else if(num == 0) {
				zero++;
			} else if(num == 1) {
				result += num;
			} else {
				plus.add(num);
			}
		}
		
		Collections.sort(minus);
		Collections.sort(plus, (a,b) -> Long.compare(b,a));
		
		int size = minus.size() / 2;
		for(int i = 0; i < size; i++) {
			result += minus.remove() * minus.remove();
		}
		
		if(minus.size() % 2 != 0) {
			if(zero == 0) {
				result += minus.remove();
			}
		}
		
		size = plus.size() / 2;
		for(int i = 0; i < size; i++) {
			result += plus.remove() * plus.remove();
		}
		
		if(plus.size() % 2 != 0) {
			result += plus.remove();
		}
		
		System.out.print(result);
		
	}
}

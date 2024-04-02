import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;
 
public class Main{
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		LinkedList<Integer> booksLeft = new LinkedList<>();
		LinkedList<Integer> booksRight = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		int num = 0;
		for(int i = 0; i < N; i++) {
			num = Integer.parseInt(st.nextToken());
			if(num < 0) {
				booksLeft.add(num);
			} else {
				booksRight.add(num);
			}
		}
		
		Collections.sort(booksLeft);
		Collections.sort(booksRight, (a,b) -> Integer.compare(b, a));
		
		int result = 0;
		if(booksLeft.isEmpty()) {
			result += getDistance(booksRight, M);
		} else if(booksRight.isEmpty()) {
			result += getDistance(booksLeft, M);
			
		} else {
			if(Math.abs(booksLeft.getFirst()) > booksRight.getFirst()) {
				result += getDistance(booksLeft, M);
			} else {
				result += getDistance(booksRight, M);
			}
		}
		result += sumDistance(booksRight, M);
		result += sumDistance(booksLeft, M);
		
		System.out.print(result);
	}
	public static int sumDistance(LinkedList<Integer> books, int M) {
		int result = 0;
		while(!books.isEmpty()) {
			result += getDistance(books, M) * 2;
		}
		return result;
	}
	public static int getDistance(LinkedList<Integer> books, int M) {
		int dis = Math.abs(books.getFirst());
		for(int i = 0; i < M; i++) {
			if(!books.isEmpty()) books.removeFirst();
		}
		return dis;
	}
}

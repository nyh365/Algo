import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
 
public class Main{
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		ArrayList<Integer> boysWantsTall = new ArrayList<>(); 
		ArrayList<Integer> boysWantsSmall = new ArrayList<>(); 
		
		int cur = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			cur = Integer.parseInt(st.nextToken());
			if(cur > 0) {
				boysWantsTall.add(cur);
			} else {
				boysWantsSmall.add(cur);
			}
		}

		Collections.sort(boysWantsSmall);
		Collections.sort(boysWantsTall, (a,b) -> Integer.compare(b, a));
		
		ArrayList<Integer> girlsWantsTall = new ArrayList<>(); 
		ArrayList<Integer> girlsWantsSmall = new ArrayList<>(); 
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			cur = Integer.parseInt(st.nextToken());
			if(cur > 0) {
				girlsWantsTall.add(cur);
			} else {
				girlsWantsSmall.add(cur);
			}
		}
		
		Collections.sort(girlsWantsSmall);
		Collections.sort(girlsWantsTall, (a,b) -> Integer.compare(b, a));
		
		int result = 0;
		//키 큰 여자를 원하는 남자 + 키 작은 남자를 원하는 여자
		result += findCouple(boysWantsSmall, girlsWantsTall);
		
		//키 작은 여자를 원하는 남자 + 키 큰 남자를 원하는 여자
		result += findCouple(girlsWantsSmall, boysWantsTall);

		System.out.print(result);
	}
	public static int findCouple(ArrayList<Integer> tall, ArrayList<Integer> small) {
		int result = 0;
		
		int i = 0;
		for(int height : tall) {
			for(; i < small.size();) {
				if(Math.abs(height) > small.get(i++)) {
					result++;
					break;
				}
			}
		}
		return result;
	}
}

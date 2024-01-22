import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		HashMap<String, Integer> wordMap = new HashMap<>();
		int totalLength = 0;
		
		int N = Integer.parseInt(br.readLine());		
		String[] originWord = new String[N];
		String[] sortedWord = new String[N];
		int[] length = new int[N];
		for(int i = 0; i < N; i++) {
			originWord[i] = br.readLine();
			sortedWord[i] = originWord[i];
			wordMap.put(originWord[i], i);
		}
		
		Arrays.sort(sortedWord);
		int cnt;
		for(int i = 1; i < N; i++) {
			cnt = getLength(sortedWord[i-1], sortedWord[i]);
			totalLength = Math.max(totalLength, cnt);
			
			length[wordMap.get(sortedWord[i - 1])] = Math.max(cnt, length[wordMap.get(sortedWord[i - 1])]);
			length[wordMap.get(sortedWord[i])] = Math.max(cnt, length[wordMap.get(sortedWord[i])]);
		}
		
		int result = -1;
		for(int i = 0; i < N; i++) {
			if(result == -1) {
				if(length[i] == totalLength) {
					result = i;
					sb.append(originWord[i]).append("\n");
				}
			} else {
				if(length[i] == totalLength && originWord[i].substring(0, totalLength).equals(originWord[result].substring(0, totalLength))) {
					sb.append(originWord[i]);
					break;
				}
			}
		}
		
		System.out.print(sb);
	}
	public static int getLength(String a, String b) {
		int size = Math.min(a.length(), b.length());
		for(int i = size; i > 0; i--) {
			if(a.substring(0, i).equals(b.substring(0, i))) {
				return i;
			}
		}
		return 0;
	}
}

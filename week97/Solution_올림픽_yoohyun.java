import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static class Score implements Comparable<Score> {
		int country, gold, silver, copper;

		public Score(int country, int gold, int silver, int copper) {
			this.country = country;
			this.gold = gold;
			this.silver = silver;
			this.copper = copper;
		}

		public int compareTo(Score score) {
			return this.gold == score.gold ? 
					(this.silver == score.silver ?
							-Integer.compare(this.copper, score.copper) : -Integer.compare(this.silver, score.silver)
				) : -Integer.compare(this.gold, score.gold);
		}
	}
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        Score[] scores = new Score[N];
        int[] detail = new int[3];
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int num = Integer.parseInt(st.nextToken());
        	int gold = Integer.parseInt(st.nextToken());
        	int silver = Integer.parseInt(st.nextToken());
        	int copper = Integer.parseInt(st.nextToken());
        	
        	scores[i] = new Score(num, gold, silver, copper);
        	
        	if(num == K) {
        		detail[0] = scores[i].gold;
                detail[1] = scores[i].silver;
                detail[2] = scores[i].copper;
        	}
        }

        Arrays.sort(scores);
        
        int result = 1;
        for(int i = 0; i < N; i++) {
        	if(scores[i].gold == detail[0] && scores[i].silver == detail[1] && scores[i].copper == detail[2]) break;
        	if(scores[i].country == K) break;
        	result++;
        }
        
        System.out.print(result);
	}
}

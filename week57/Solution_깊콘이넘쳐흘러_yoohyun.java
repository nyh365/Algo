import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main{
	public static class Gifticon {
		long expire, expectedUseDate;
		
		public Gifticon(long expire) {
			this.expire = expire;
		}
		
		public void setExpectedUseDate(long expectedUseDate) {
			this.expectedUseDate = expectedUseDate;
		}
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        Gifticon[] gifticons = new Gifticon[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	gifticons[i] = new Gifticon(Long.parseLong(st.nextToken()));
        }
        
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	gifticons[i].setExpectedUseDate(Long.parseLong(st.nextToken()));
        }
        
        Arrays.sort(gifticons, (a,b) -> Long.compare(a.expectedUseDate, b.expectedUseDate) == 0 ? Long.compare(a.expire , b.expire) : Long.compare(a.expectedUseDate, b.expectedUseDate));
        
        long result = 0;
        long temp = -1, extensionCnt, preMaxExpireDate = -1, curExpectedUseDate = -1;
        for(int i = 0; i < N; i++) {
        	if(i == 0 || gifticons[i].expectedUseDate != gifticons[i - 1].expectedUseDate) {
        		preMaxExpireDate = curExpectedUseDate;
        	} 
        	temp = Math.max(preMaxExpireDate, gifticons[i].expectedUseDate);
        	extensionCnt = gifticons[i].expire >= temp ? 0 :  (temp - gifticons[i].expire - 1) / 30 + 1;
        	result += extensionCnt;
        	curExpectedUseDate = Math.max(curExpectedUseDate, gifticons[i].expire + 30 * extensionCnt);
        }
        System.out.print(result);
    }
}

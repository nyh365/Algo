import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int start = 1, end = 200_000_000;
        int mid, answer = 0;
        
        while(start <= end) {
            mid = (start + end) / 2;
            
            if(isPossible(stones, mid, k)) {
                start = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                end = mid - 1;   
            }
        }
        
        return answer;
    }
    
    public boolean isPossible(int[] stones, int removeCnt, int k) {
        int cnt = 0;
        for(int i = 0; i < stones.length; i++) {
            if(stones[i] < removeCnt) {
                if(cnt == k - 1) return false;
                cnt++;
                continue;
            }
            cnt = 0;
        }
        return true;
    }
}

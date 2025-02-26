import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int index = A.length - 1, cnt = 0;
        for(int i = A.length - 1; i >= 0; i--) {
            if(A[i] < B[index]) {
                cnt++;
                index--;
            }
        }
        
        return cnt;
    }
}

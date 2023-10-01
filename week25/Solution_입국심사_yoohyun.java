import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        int size = times.length;
        
        long start = 1;
        long end = (long) n * times[size - 1];
        long mid;
        
        long sum;
        while(start < end){
            mid = (start + end) / 2;
            sum = 0;
            
            for(int time : times){
                sum += mid / time;
            }
            
            if(sum < n){
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        answer = end;
        return answer;
    }
}

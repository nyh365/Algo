import java.util.*;

class Solution {
    static final int MAX = 24 * 60 + 10;
    public int solution(String[][] book_time) {
        int answer = 0;
        
        int[] schedule = new int[MAX];
        int size = book_time.length;
        for(int i = 0; i < size; i++){
            schedule[timeToInt(book_time[i][0])] += 1;
            schedule[timeToInt(book_time[i][1]) + 10] += -1;
        }
        
        for(int i = 1; i < MAX; i++){
            schedule[i] += schedule[i - 1];
            answer = Math.max(answer, schedule[i]);
        }
        
        return answer;
    }
    public int timeToInt(String time){
        String[] times = time.split(":");
        
        return Integer.parseInt(times[0]) * 60 +  Integer.parseInt(times[1]);
    }
}

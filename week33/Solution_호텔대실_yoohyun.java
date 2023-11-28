import java.util.*;

class Solution {
    
    public int solution(String[][] book_time) {
        int answer = 0;
        
        PriorityQueue<int[]> startTime = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]) == 0 ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> endTime = new PriorityQueue<>();
        
        int size = book_time.length;
        for(int i = 0; i < size; i++){
            startTime.add(convert(book_time[i]));
        }
        
        answer++;
        endTime.add(startTime.remove()[1] + 10);
        
        while(!startTime.isEmpty()){
            if(endTime.peek() > startTime.peek()[0]){
                answer++;
                endTime.add(startTime.remove()[1] + 10);
            } else{
                endTime.remove();
                endTime.add(startTime.remove()[1] + 10);
            }
        }
        return answer;
    }
    
    public int[] convert(String[] book_time){        
        return new int[]{ timeToInt(book_time[0]), timeToInt(book_time[1])};
    }
    
    public int timeToInt(String time){
        String[] times = time.split(":");
        int totalTime = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
        return totalTime;
    }
}

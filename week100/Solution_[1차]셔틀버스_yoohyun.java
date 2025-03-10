import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<int[]> waitLine = makeWaitLine(timetable);
        int result = -1;
        int curTime = 60 * 9;
        int capacitySeat = m;
        
        int[] nextCrew;
        for(int i = 0; i < n; i++) {
            capacitySeat = m;
            if(waitLine.isEmpty()) break;
            while(!waitLine.isEmpty() && waitLine.peek()[0] <= curTime ) {
                    nextCrew = waitLine.remove();
                
                    if(nextCrew[1] >= capacitySeat) {
                        if(nextCrew[1] > capacitySeat) {
                            waitLine.add(new int[] {nextCrew[0], nextCrew[1] - capacitySeat});
                        }

                        result = nextCrew[0] - 1;
                        capacitySeat = 0;

                        break;
                     } else {
                        capacitySeat -= nextCrew[1];
                     }    
            }
            
            if(capacitySeat > 0) {
                result = curTime - 1;
            }
            if(curTime > 23 * 60 + 59) break;
            
            curTime += t;
        }
        
        if(capacitySeat > 0) {
            result = curTime - t;
        } 
        
        int hour = result / 60;
        int minute = result % 60;
        
        return (hour < 10 ? "0" + hour : hour) + ":" + (minute < 10 ? "0" + minute : minute);
    }
    
    public PriorityQueue<int[]> makeWaitLine(String[] timetable) {
        HashMap<Integer, Integer> waitLine = makeWaitLineToHashMap(timetable);
        
        return makeWaitLineToPQ(waitLine);
    }
    
    public HashMap<Integer, Integer> makeWaitLineToHashMap(String[] timetable) {
        HashMap<Integer, Integer> waitLine = new HashMap<>();
        StringTokenizer st;
        
        for(String time : timetable) {
            st = new StringTokenizer(time, ":");
            int timeValue = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
            waitLine.put(timeValue, waitLine.getOrDefault(timeValue, 0) + 1);
        }
        
        return waitLine;
    }
    public PriorityQueue<int[]> makeWaitLineToPQ(HashMap<Integer, Integer> waitLineHashMap) {
        PriorityQueue<int[]> waitLine = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        for(int key : waitLineHashMap.keySet()) {
            waitLine.add(new int[] {key, waitLineHashMap.get(key)});
        }
        
        return waitLine;
    }
}

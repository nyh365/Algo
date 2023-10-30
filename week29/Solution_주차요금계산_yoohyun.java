import java.util.*;
class Solution {
    static final int END = 60 * 23 + 59;
    public int[] solution(int[] fees, String[] records) {
        StringTokenizer st;
        HashMap<String, Integer> timeline = new HashMap<>();
        HashMap<String, Integer> parkingTime = new HashMap<>();
        
        String[] time;
        String carNumber, isParking;
        int times;
        for(String record : records){
            st = new StringTokenizer(record);
            time = st.nextToken().split(":");
            carNumber = st.nextToken();
            isParking = st.nextToken();
            
            if("IN".equals(isParking)){
                timeline.put(carNumber, getTime(time));
            } else {
                times = getTime(time) - timeline.get(carNumber);
                timeline.remove(carNumber);
                parkingTime.put(carNumber, parkingTime.getOrDefault(carNumber, 0) + times);
            }
        }
        
        for(String t : timeline.keySet()){
            times = END  - timeline.get(t);
                parkingTime.put(t, parkingTime.getOrDefault(t, 0) + times);       
        }
        
        int cnt = 0, tmp;
        int[][] result = new int[parkingTime.size()][2];
        int[] answer = new int[parkingTime.size()];
        for(String s : parkingTime.keySet()){
            result[cnt][0] = Integer.parseInt(s);
            tmp = parkingTime.get(s) - fees[0];
            result[cnt++][1] = fees[1] + (tmp < 0 ? 0 : tmp % fees[2] == 0 ? tmp / fees[2] : tmp / fees[2] + 1) * fees[3];
        }
        
        Arrays.sort(result, (a, b) -> Integer.compare(a[0], b[0]));
        cnt = 0;
        for(int[] fee : result){
            answer[cnt++] = fee[1];
        }
        
        return answer;
    }
    public int getTime(String[] time){
        int times = 0;
        times += 60 * Integer.parseInt(time[0]);
        times += Integer.parseInt(time[1]);
        return times;
    }
}

import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String s) {
        ArrayList<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        s = s.substring(2, s.length() - 2).replace("},{", " ");
        String[] element = s.split(" ");
        Arrays.sort(element, (a, b) -> Integer.compare(a.length(), b.length()));
        
        String[] tmpFull; int num;
        for(String e : element){
            tmpFull = e.split(",");
            for(String tmp : tmpFull){
                num = Integer.parseInt(tmp);
                if(!set.contains(num)){
                    set.add(num);
                    result.add(num);
                }
            }
        }
        System.out.println(result);
        return result;
    }
}

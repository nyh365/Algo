import java.util.*;

class Solution {
    public class Music implements Comparable<Music> {
        String genre;
        int plays;
        
        Music(String genre, int plays){
            this.genre = genre;
            this.plays = plays;
        }
        
        public int compareTo(Music music){
            return Integer.compare(music.plays, this.plays);
        }
    }
    public ArrayList<Integer> solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        HashMap<String, Integer> gTotal = new HashMap<>();
        HashMap<String, LinkedList<int[]>> gPlays = new HashMap<>();
        
        int size = genres.length;
        for(int i = 0; i < size; i++){
            gTotal.put(genres[i], gTotal.getOrDefault(genres[i], 0) + plays[i]);
            
            if(!gPlays.containsKey(genres[i])){
                gPlays.put(genres[i], new LinkedList<>());
            }
            
            gPlays.get(genres[i]).add(new int[]{i, plays[i]});
        }
        
        LinkedList<Music> list = new LinkedList<>();
        for(String s : gTotal.keySet()){
            list.add(new Music(s, gTotal.get(s)));
        }
        
        Collections.sort(list);
        
        LinkedList<int[]> tmp;
        int length;
        for(Music m : list){
            tmp = gPlays.get(m.genre);
            Collections.sort(tmp, (a,b) -> Integer.compare(b[1],a[1]));
            length = Math.min(2, tmp.size());
            for(int i = 0; i < length; i++){
                answer.add(tmp.get(i)[0]);
            }
        }
        return answer;
    }
}

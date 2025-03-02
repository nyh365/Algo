import java.util.*;

class Solution {
    HashSet<HashSet<String>> result = new HashSet<>();
    HashSet<String> banned_user = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        
        for(int i = 0; i < banned_id.length; i++){
            banned_id[i] = banned_id[i].replace("*", ".");
        }        
        
        findBannedUser(user_id, banned_id, 0);
        
        return result.size();
    }
    public void findBannedUser(String[] user_id, String[] banned_id, int cnt) {
        if(cnt == banned_id.length) {
            result.add(banned_user);
            return;
        }
        
        for(int i = 0; i < user_id.length; i++){
            if(banned_user.contains(user_id[i])) continue;
            if(!user_id[i].matches(banned_id[cnt])) continue;
            banned_user.add(user_id[i]);
            findBannedUser(user_id, banned_id, cnt + 1);
            banned_user.remove(user_id[i]);
        }
    }
}

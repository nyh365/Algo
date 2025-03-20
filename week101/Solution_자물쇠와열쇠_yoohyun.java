import java.util.*;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int[][] locInfo = findHeight(lock);
        if(locInfo[0][0] == -1) return true;
        
        int[][] pattern = makePattern(locInfo, lock);
        
        return findKey(pattern, key);
    }
    
    public int[][] findHeight(int[][] lock) {
        //info[0] 은 넓이에 대한 정보
        //info[1] 은 높이에 대한 정보
        int[][] info = new int[2][4];
        for(int i = 0; i < 2; i++) {
            Arrays.fill(info[i], -1);
        }
        
        for(int i = 0; i < lock.length; i++) {
            for(int j = 0; j < lock[0].length; j++) {
                if(lock[i][j] == 0) {
                    if(info[1][0] == -1) {
                        info[1][0] = j;
                        info[1][1] = i;
                    }
                    info[1][2] = j;
                    info[1][3] = i;
                }
            }
        }
        
        for(int i = 0; i < lock[0].length; i++) {
            for(int j = 0; j < lock.length; j++) {
                if(lock[j][i] == 0) {
                    if(info[0][0] == -1) {
                        info[0][0] = i;
                        info[0][1] = j;
                    }
                    info[0][2] = i;
                    info[0][3] = j;
                }
            }
        }
        return info;
    }
    
    public int[][] makePattern(int[][] info, int[][] lock) {
        int[][] pattern = new int[info[1][3] - info[1][1] + 1][info[0][2] - info[0][0] + 1];
        
        for(int i = info[1][1]; i <= info[1][3]; i++) {
            for(int j = info[0][0]; j <= info[0][2]; j++) {
                if(lock[i][j] == 1) continue;
                pattern[i - info[1][1]][j - info[0][0]] = 1;
            }
        }
        
        return pattern;
    }
    
    public boolean findKey(int[][] pattern, int[][] key) {
        int width = pattern[0].length;
        int height = pattern.length;
        
        for(int k = 0; k < 4; k++) {
            for(int i = 0; i <= key.length - height; i++) {
                for(int j = 0; j <= key[0].length - width; j++) {
                    if(equalPattern(j, i, key, pattern)) return true;
                }
            }
            rotate(key);
        }
        
        return false;
    }
    
    public boolean equalPattern(int x, int y, int[][] key, int[][] pattern) {
        for(int i = 0; i < pattern.length; i++) {
            for(int j = 0; j < pattern[0].length; j++) {
                if(pattern[i][j] != key[y + i][x + j]) {
                    return false;
                } 
            }
        }
        
        return true;
    }
    
    public void rotate(int[][] key) {
        int[][] temp = new int[key.length][key.length];
        
        for(int i = 0; i < key.length; i++) {
            for(int j = 0; j < key.length; j++) {
                temp[i][j] = key[key.length - 1 - j][i];
            }
        }
        
        for(int i = 0; i < key.length; i++) {
            for(int j = 0; j < key.length; j++) {
                key[i][j] = temp[i][j];
            }
        }
    }
}

import java.util.*;
class Solution {
    static int[] ADice, BDice;
    static ArrayList<Integer> ADiceSum, BDiceSum;
    static int maxCnt = Integer.MIN_VALUE; 
    static int[] result;
    static int n;
    public int[] solution(int[][] dice) {
        n = dice.length;
        
        ADice = new int[n / 2];
        BDice = new int[n / 2];
        result = new int[n / 2];
        
        combinationDice(0, 0, 0, dice);
        
        return result;
    }
    
    public void combinationDice (int cnt, int idx, int visited, int[][] dice) {
        if(cnt == n / 2) {
            makeBDice();
            
            int tmp = countWin(dice);
            if(maxCnt < tmp) {
                maxCnt = tmp;
                for(int i = 0; i < n / 2; i++) {
                    result[i] = ADice[i] + 1;
                }
            }
            
            return;
        }
        
        for(int i = idx; i < n; i++) {
            if((visited & (1 << i)) != 0) continue;
            ADice[cnt] = i;
            combinationDice(cnt + 1, i + 1, visited | (1 << i), dice);
        }
    }
    
    public void makeBDice() {
        int idx = 0;
        boolean flag;
        for(int i = 0; i < n; i++) {
            flag = true;
            for(int j = 0; j < n / 2; j++) {
                if(ADice[j] == i) {
                    flag = false;
                    break;
                }
            }
            if(!flag) continue;
            BDice[idx++] = i;
        }
    }
    
    public int countWin(int[][] dice) {
        makeABDiceSum(dice);
        
        Collections.sort(BDiceSum);
        
        int result = 0, idx;
        for(int ASum : ADiceSum) {
            idx = binarySearch(ASum);
            
            if(idx == -1) continue;
            result += (idx + 1);
        }
        
        return result;
    }
    
    public int binarySearch(int target) {
        int start = 0;
        int end = BDiceSum.size() - 1;
        int mid;
        
        int result = -1;
        while(start <= end) {
            mid = (start + end) / 2;
            
            if(BDiceSum.get(mid) < target) {
                start = mid + 1;
                result = mid;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }
    
    public void makeABDiceSum(int[][] dice) {
        ADiceSum = new ArrayList<>();
        BDiceSum = new ArrayList<>();
        
        makeDiceSum(0, 0, dice, ADice, ADiceSum);
        makeDiceSum(0, 0, dice, BDice, BDiceSum);
    }
    
    public void makeDiceSum(int cnt, int sum, int[][] dice, int[] diceOrder, ArrayList<Integer> diceSum) {
        if(cnt == n / 2) {
            diceSum.add(sum);
            return;
        }
        
        for(int i = 0; i < 6; i++) {
            makeDiceSum(cnt + 1, sum + dice[diceOrder[cnt]][i], dice, diceOrder, diceSum);
        }
    }
}

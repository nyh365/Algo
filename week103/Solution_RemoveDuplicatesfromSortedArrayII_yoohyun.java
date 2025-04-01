class Solution {
    public int removeDuplicates(int[] nums) {
        int size = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[size - 2]) {
                nums[size++] = nums[i];
            }
        }
        return size;
    }
}

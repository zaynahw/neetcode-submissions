class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        if (nums == null || nums.length == 0) { return -1; }
        for (int i = 0; i < nums.length / 2; i++) {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
            mid = (left + right) / 2;;
        }

        if (nums[mid] != target) {
            return -1;
        } else {
            return mid;
        }
    }
}

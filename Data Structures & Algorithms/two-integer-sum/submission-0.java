class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> vals = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int compl = target - nums[i];
            if (vals.containsKey(compl)) {
                return new int[]{vals.get(compl), i};
            }
            vals.put(nums[i], i);
        }
        return new int[]{};   
    }
}

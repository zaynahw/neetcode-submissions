class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> check = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (visited.contains(target - nums[i])) {
                return new int[]{check.get(target - nums[i]), i};
            }
            visited.add(nums[i]);
            check.put(nums[i], i);
        }
        return new int[]{};
    }  
}

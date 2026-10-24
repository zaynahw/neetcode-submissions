class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null ) { return 0; }
        if (s.length() <= 1) { return s.length(); }

        int left = 0;
        int right = 0;
        int maxLength = 0;
        HashSet<Character> vis = new HashSet<>();
        while (right < s.length()) {
            while (vis.contains(s.charAt(right))) {
                vis.remove(s.charAt(left++));
            }
            
            vis.add(s.charAt(right));
            maxLength = Math.max(maxLength, right-left+1);
            right++;
        }

        return maxLength;

     }
}

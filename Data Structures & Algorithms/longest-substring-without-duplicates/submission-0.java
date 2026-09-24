class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        HashSet<Character> found = new HashSet<>();
        int maxLength = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            if (found.contains(s.charAt(right))) {
                while (found.contains(s.charAt(right))) {
                    found.remove(s.charAt(left));
                    left++;
                }
            } 
            found.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
            
        }
        return maxLength;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1 ) {
            return s.length();
        } 
        HashSet<Character> visited = new HashSet<>();
        int left = 0;
        int right = 1;
        int greatestLength = 1;
        visited.add(s.charAt(left));
        while (left < right && right < s.length()) {
            if (visited.contains(s.charAt(right))) {
                while (visited.contains(s.charAt(right))) {
                    visited.remove(s.charAt(left));
                    left++;
                }
            }
            visited.add(s.charAt(right));

            if (greatestLength < (right - left + 1)) {
                greatestLength = right - left + 1;
            }

            right++;
        }
        return greatestLength;
    }
}

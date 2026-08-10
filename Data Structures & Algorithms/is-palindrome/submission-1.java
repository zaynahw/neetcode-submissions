class Solution {
    public boolean isPalindrome(String s) {
        String clean = "";
        // instead have to look through each char, and do Character.isLetterOrDigit(c) and then add to a cleaned string accordinly

        for (int i=0; i<s.length();i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                clean += s.charAt(i);
            }
        }

        clean = clean.toLowerCase();
        for (int i=0; i<clean.length()/2; i++) {
            if (clean.charAt(i) != clean.charAt(clean.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
}

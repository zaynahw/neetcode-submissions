class Solution {
    public boolean isValid(String s) {
        Stack<Character> all = new Stack<>();
        for (int i=0 ; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch =='[' || ch == '{') {
                all.push(ch);
            } else {
                if (all.isEmpty()) {
                    return false;
                }
                char check = all.pop();
                if (ch == ')' && check != '(' ) {
                    return false;
                } else if (ch == ']' && check != '[' ) {
                    return false;
                } else if (ch == '}' && check != '{' ) {
                    return false;
                }
            }
        }

        return all.isEmpty();
    }
}

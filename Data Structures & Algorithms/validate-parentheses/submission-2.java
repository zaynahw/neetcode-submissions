class Solution {
    public boolean isValid(String s) {
        if (s == null ) { return false;}
        Stack<Character> lastType = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c =='[' || c =='(' || c == '{') {
                lastType.push(c);
            }

            if (c == ']') {
                if (lastType.isEmpty()) {
                    return false;
                }
                if (lastType.peek() != '[') {
                    return false;
                }
                lastType.pop();
            }

            if (c == '}') {
                if (lastType.isEmpty()) {
                    return false;
                }
                if (lastType.peek() != '{') {
                    return false;
                }
                lastType.pop();
            }

            if (c == ')') {
                if (lastType.isEmpty()) {
                    return false;
                }
                if (lastType.peek() != '(') {
                    return false;
                }
                lastType.pop();
            }
        }

        return lastType.isEmpty();
    }
}

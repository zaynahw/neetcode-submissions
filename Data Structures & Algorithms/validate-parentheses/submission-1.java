class Solution {
    public boolean isValid(String s) {
        if (s == null ) { return false;}
        Stack<Character> squares = new Stack<>();
        Stack<Character> round = new Stack<>();
        Stack<Character> curly = new Stack<>();
        Stack<Character> lastType = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '[') {
                squares.push(c);
                lastType.push('s');
            }

            if (c == '{') {
                curly.push(c);
                lastType.push('c');
            }

            if (c == '(') {
                round.push(c);
                lastType.push('r');
            }
            
            if (c == ']') {
                if (squares.isEmpty()) { return false; }
                if (squares.peek() == '[') {
                    if (lastType.peek() != 's') {
                        return false;
                    } else {
                        lastType.pop();
                        squares.pop();
                    }
                }
            }

            if (c == ')') {
                if (round.isEmpty()) { return false; }
                if (round.peek() == '(') {
                    if (lastType.peek() != 'r') {
                        return false;
                    } else {
                        lastType.pop();
                        round.pop();
                    }
                }
            }

            if (c == '}') {
                if (curly.isEmpty()) { return false; }
                if (curly.peek() == '{') {
                    if (lastType.peek() != 'c') {
                        return false;
                    } else {
                        lastType.pop();
                        curly.pop();
                    }
                }
            }
        }

        if (!squares.isEmpty() || !round.isEmpty() || !curly.isEmpty()) {
            return false;
        }
        return true;
    }
}

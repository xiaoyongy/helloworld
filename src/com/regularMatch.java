package com;

public class regularMatch {
    private boolean isMatch1(String text, String pattern) { //递归
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch1(text, pattern.substring(2)) ||
                    (first_match && isMatch1(text.substring(1), pattern)));
        } else {
            return first_match && isMatch1(text.substring(1), pattern.substring(1));
        }
    }

    public boolean isMatch2(String s, String p) {
        if (s.equals(p)) {
            return true;
        }

        boolean[] memo = new boolean[s.length() + 1];

        return helper(s.toCharArray(), p.toCharArray(),
                s.length() - 1, p.length() - 1, memo);
    }

    private boolean helper(char[] s, char[] p, int i, int j, boolean[] memo) {
        if (memo[i + 1]) {
            return true;
        }

        if (i == -1 && j == -1) {
            memo[i + 1] = true;
            return true;
        }

        boolean isFirstMatching = false;

        if (i >= 0 && j >= 0 && (s[i] == p[j] || p[j] == '.'
                || (p[j] == '*' && (p[j - 1] == s[i] || p[j - 1] == '.')))) {
            isFirstMatching = true;
        }

        if (j >= 1 && p[j] == '*') {
            // 看 s[0,...i] 和 p[0,...j-2]
            boolean zero = helper(s, p, i, j - 2, memo);
            // 看 s[0,...i-1] 和 p[0,...j]
            boolean match = isFirstMatching && helper(s, p, i - 1, j, memo);

            if (zero || match) {
                memo[i + 1] = true;
            }

            return memo[i + 1];
        }

        // 看 s[0,...i-1] 和 p[0,...j-1]
        if (isFirstMatching && helper(s, p, i - 1, j - 1, memo)) {
            memo[i + 1] = true;
        }

        return memo[i + 1];
    }

    public static void main(String[] args) {
        String s = "b";
        String p = "c*b";
        boolean result = new regularMatch().isMatch2(s, p);
        System.out.println(result);

    }
}

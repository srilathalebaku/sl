class Solution {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";

        StringBuilder stack = new StringBuilder();

        for (char digit : num.toCharArray()) {
            while (k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > digit) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(digit);
        }

        // If k still remains, remove from the end
        while (k > 0 && stack.length() > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        // Remove leading zeros
        while (stack.length() > 1 && stack.charAt(0) == '0') {
            stack.deleteCharAt(0);
        }

        return stack.length() == 0 ? "0" : stack.toString();
    
    }
}

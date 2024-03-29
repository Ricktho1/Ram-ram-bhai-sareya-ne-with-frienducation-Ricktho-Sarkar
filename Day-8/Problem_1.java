class Problem_1 {
    //O(n^2) time complexity
    //O(n) space complexity
    static int maxLen = 0;
    static int lo = 0;
    public static String longestPalindrome(String s) {
        char[] input = s.toCharArray();
        if(s.length() < 2) {
            return s;
        }
        
        for(int i = 0; i<input.length; i++) {
            expandPalindrome(input, i, i);
            expandPalindrome(input, i, i+1);
        }
        return s.substring(lo, lo+maxLen);
    }
    
    public static void expandPalindrome(char[] s, int j, int k) {
        while(j >= 0 && k < s.length && s[j] == s[k]) {
            j--;
            k++;
        }
        if(maxLen < k - j - 1) {
            maxLen = k - j - 1;
            lo = j+1;
        }
    }
    public static void main(String[] args) {
        String s = "babad";
        String k = longestPalindrome(s);
        System.out.println(k);
    }
}
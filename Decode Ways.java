class Solution {
    public int numDecodings(String S) {
        int[] memo = new int[S.length()];
        Arrays.fill(memo, -1);
        return numDecodingsHelper(S, S.length()-1, memo);
    }
    
    private int numDecodingsHelper(String str, int index, int[] memo) {
        /// base case - return 1 if everything processed
        if(index < 0) return 1;
        
        if(memo[index] != -1) return memo[index];
        
        //// Last Digit Not Equal to Zero - Keep Counting for index-1
        int res = (str.charAt(index) == '0') ? 0 : numDecodingsHelper(str, index - 1, memo);
        
        /// Last But One Digit : Either 1 or 2 => and for 2 last digit should be less than 6, Keep counting index-2
        if(index-1 >= 0 && ((str.charAt(index-1) == '1') || (str.charAt(index-1) == '2' && str.charAt(index) <= '6'))) {
            res += numDecodingsHelper(str, index - 2, memo); 
        }
        memo[index] = res;
        return res;
    }
}
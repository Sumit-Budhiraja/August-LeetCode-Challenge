class Solution {
    public int minFlipsMonoIncr(String S) {
        int ones=0;int minFlips=0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='0') {
                minFlips=Math.min(minFlips+1,ones);
            }else{
                ones++;
            }
        }
        return minFlips;
    }
}
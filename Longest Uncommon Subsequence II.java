class Solution {
    public int findLUSlength(String[] strs) {
        int max=-1;
        for(int i=0;i<strs.length;i++){
            boolean flag=false;
            int cur=strs[i].length();
            for(int j=0;j<strs.length;j++){
                if(i!=j && isSubsequence(strs[i], strs[j])){
                    flag=true;
                    break;
                }
            }
            if(!flag){
                max=Math.max(max,cur);
            }
        }
        return max;
    }
    private boolean isSubsequence(String a, String b){
        if(a.equals(b)) return true;
        int i=0;
        int j =0;
        while(i<a.length() && j<b.length()){
            if(a.charAt(i) == b.charAt(j++)){
                i++;
            }
        }
        return i==a.length();
    }
}
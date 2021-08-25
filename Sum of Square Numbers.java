class Solution {
    public boolean judgeSquareSum(int c) {
    int n =(int) Math.sqrt(c);
    n=n+1;
    int l = 0;
    int r = n;
    while(l<n){
        int p = l*l + r*r;
        if(p==c)
            return true;
        if(p>c)
            r--;
        else
           l++;
    }
        return false;
    }
}
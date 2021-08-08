class Solution {

public boolean stoneGame(int[] piles) {

    int i = 0;
    int j = piles.length-1;
    int sum_alex = 0;
    int sum_lee = 0;

	
    while(i < j)
    {
        sum_alex += Math.max(piles[i],piles[j]);
        sum_lee += Math.min(piles[i],piles[j]);
        i++;
        j--;
    }
	
    if(sum_alex > sum_lee)
        return true;
    
    return false;
}
}
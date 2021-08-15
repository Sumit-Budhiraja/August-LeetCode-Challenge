class Solution {
    public String minWindow(String s, String t) {
        int[] tCount = new int[128];
        for (int i = 0; i < t.length(); i++) {
            tCount[t.charAt(i)]++;
        }
        
        int minStart = -1;
        int minEnd = -1;
        int[] sCount = new int[128];
        int count = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            int rightChar = s.charAt(right);
            sCount[rightChar]++;
            if (sCount[rightChar] <= tCount[rightChar]) {
                count++;
            }
            while (count == t.length()) {
                if (minStart == -1 || right - left + 1 < minEnd - minStart + 1) {
                    minStart = left;
                    minEnd = right;
                }
                
                int leftChar = s.charAt(left++);
                sCount[leftChar]--;
                if (sCount[leftChar] < tCount[leftChar]) {
                    count--;
                }
            }
        }
        
        return minStart == -1 ? "" : s.substring(minStart, minEnd + 1);
    }
}
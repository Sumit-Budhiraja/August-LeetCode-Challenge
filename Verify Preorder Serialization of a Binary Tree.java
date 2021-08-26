class Solution {
    public boolean isValidSerialization(String preorder) {   
        if(preorder.length()==1) return preorder.charAt(0) == '#';
        String[] parts = preorder.split(",");
        if(parts.length % 2 == 0) return false; // total entries will always be odd if it is valid
        
        Deque<Integer> st = new LinkedList<>();
        for(String str: parts) {
            if(str.equals("#")) {
                if(st.isEmpty()) 
                    return false;
                int curr = st.pop();
                curr++;
                if(curr < 2)
                    st.push(curr);
            } else {
                if(st.isEmpty()) {
                    st.push(0);
                } else {
                    int curr = st.pop();
                    curr++;
                    if(curr < 2) {
                        st.push(curr);
                    }
                    st.push(0);
                }
            }
        }
        
        return st.isEmpty();
        
    }
}
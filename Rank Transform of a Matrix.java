class Solution {
    
    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int ans[][] = new int[m][n];
        
        PriorityQueue<int[]> pq = 
            new PriorityQueue<int[]>((a, b) -> matrix[a[0]][a[1]]-matrix[b[0]][b[1]]);
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                
                pq.add(new int[]{i, j});
                
            }
        }
        
        int[] rows = new int[m];
        int[] cols = new int[n];
        int rank = 0;
        
        while(!pq.isEmpty()) {
            
            int[] ele = pq.poll();
            
            int x = ele[0];
            int y = ele[1];
            
            if(ans[x][y]!=0)
                continue;
            
            // perform a dfs from the current element and find 
            // all connected elements and find their max rank and collect all those elements.
            List<int[]> list = new ArrayList();
            
            rank = find(matrix, m, n, x, y, new boolean[m][n], rows, cols, list);
            
            for(int[] item : list) {
                int i = item[0];
                int j = item[1];
                
                ans[i][j] = rank + 1;
                
                rows[i] = ans[i][j];
                cols[j] = ans[i][j];
            }
            
        }
        
        return ans;
    }
    
    private int find(int[][] matrix, int m, int n, int x, int y,
                     boolean[][] visited, int[] rows, int[] cols, List<int[]> list) {
        
        visited[x][y] = true;
        
        list.add(new int[]{x, y});
        
        int rank = Math.max(rows[x], cols[y]);
        
        for(int i=0; i<n; i++) {
            
            if(matrix[x][i] == matrix[x][y] && !visited[x][i])
                rank = Math.max(rank, find(matrix, m, n, x, i, visited, rows, cols, list));
            
        }
        
        for(int i=0; i<m; i++) {
            
            if(matrix[i][y] == matrix[x][y] && !visited[i][y])
                rank = Math.max(rank, find(matrix, m, n, i, y, visited, rows, cols, list));
            
        }
        
        return rank;
    }
}
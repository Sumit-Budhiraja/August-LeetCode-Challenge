class Solution {
    List<int[]> emptyCells = new ArrayList<>();
    int[] rows = new int[9], cols = new int[9], boxes = new int[9];
    public void solveSudoku(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    emptyCells.add(new int[]{r, c});
                } else {
                    int val = board[r][c] - '0';
                    int boxPos = (r / 3) * 3 + (c / 3);
                    rows[r] |= 1 << val;
                    cols[c] |= 1 << val;
                    boxes[boxPos] |= 1 << val;
                }
            }
        }
        backtracking(board, 0);
    }
    boolean backtracking(char[][] board, int i) {
        if (i == emptyCells.size()) return true; // Check if we filled all empty cells?

        int r = emptyCells.get(i)[0], c = emptyCells.get(i)[1], boxPos = (r / 3) * 3 + c / 3;
        for (int val = 1; val <= 9; ++val) {
            if (hasBit(rows[r], val) || hasBit(cols[c], val) || hasBit(boxes[boxPos], val)) continue; // skip if that value is existed!
            board[r][c] = (char) ('0' + val);
            int oldRow = rows[r], oldCol = cols[c], oldBox = boxes[boxPos]; // backup old values
            rows[r] |= 1 << val;
            cols[c] |= 1 << val;
            boxes[boxPos] |= 1 << val;
            if (backtracking(board, i + 1)) return true;
            rows[r] = oldRow; // backtrack
            cols[c] = oldCol; // backtrack
            boxes[boxPos] = oldBox; // backtrack
        }
        return false;
    }
    boolean hasBit(int x, int k) {
        return ((x >> k) & 1) == 1;
    }
}
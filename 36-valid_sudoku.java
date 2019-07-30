class Solution {
    public boolean isValidSudoku(char[][] board) {
        int size = board.length;
        // Arrays to store values read from column or subbox
        boolean[][] column = new boolean[size][size];
        boolean[][] subbox = new boolean[size][size];
        for(int r = 0; r < size; r++) {
            // Array to store values read in row
            boolean[] row = new boolean[9];
            for(int c = 0; c < size; c++) {
                // Check for empty cell
                char cell = board[r][c];
                if(cell == '.') {
                    continue;
                }

                // Check duplicates
                int index = cell - '0' - 1;
                int s = subboxIndex(r, c);

                //Duplicate found
                if(row[index] || column[c][index] || subbox[s][index]) {
                    return false;
                }
                // Update container arrays
                row[index] = true;
                column[c][index] = true;
                subbox[s][index] = true;
            }

        }
        // Loop completed without duplicates = valid sudoku
        return true;
    }

    // Assigning coordinate to subbox according to row & col
    public int subboxIndex(int row, int col) {
        return 3*(row/3) + (col/3);
    }
}
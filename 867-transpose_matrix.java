/**
 * Given a matrix A, return the transpose of A.
 *
 * The transpose of a matrix is the matrix flipped over it's main diagonal,
 * switching the row and column indices of the matrix.
 */
class Solution {
    public int[][] transpose(int[][] A) {
        int width = A[0].length;
        int[][] result = new int[width][A.length];
        for(int row = 0; row < A.length; row++) {
            for(int col = 0; col < width; col++) {
                result[col][row] = A[row][col];
            }
        }
        return result;
    }
}
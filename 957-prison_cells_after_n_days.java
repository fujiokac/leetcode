/**
 * There are 8 prison cells in a row, and each cell is either occupied or vacant.
 *
 * Each day, whether the cell is occupied or vacant changes according to the following rules:
 *
 * If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
 * Otherwise, it becomes vacant.
 * (Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)
 *
 * We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.
 *
 * Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)
 *
 * Chie's note: the theme of prison population is a bit tacky, I'd much rather this be about the growth of a microbial colony.
 */


class Solution {
    public static final int SIZE = 8;
    /**
     * This is the "magic number" before the pattern loops
     * Technically this does not need to be hardcoded...
     * but the challenge parameters do not require that flexibility
     * And including them extends runtime.
     */
    public static final int LOOP = 14;
    public int[] prisonAfterNDays(int[] cells, int N) {
        // First Day
        cells = firstPass(cells);
        // Run for number of days % magic number
        int loopN = (N-1) % LOOP;
        for(int n = 0; n < loopN; n++) {
            cells = mutate(cells);
        }
        return cells;
    }
    /**
     * Execute one day on cell block
     */
    public int[] mutate(int[] cells) {
        int[] cellBlock = new int[SIZE];
        for(int i = 1; i < SIZE-1; i++) {
            if(cells[i-1] == cells[i+1]) {
                cellBlock[i] = 1;
            }
            else {
                cellBlock[i] = 0;
            }
        }
        return cellBlock;
    }

    /**
     * First day behaves differently than other days,
     * the end cells will only be occupied on this day
     */
    public int[] firstPass(int[] cells) {
        // First pass
        int[]cellBlock = mutate(cells);
        cellBlock[0] = 0;
        cellBlock[SIZE-1] = 0;
        return cellBlock;
    }
}
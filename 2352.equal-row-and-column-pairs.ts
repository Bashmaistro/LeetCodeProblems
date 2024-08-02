/*
 * @lc app=leetcode id=2352 lang=typescript
 *
 * [2352] Equal Row and Column Pairs
 */

// @lc code=start
function equalPairs(grid: number[][]): number {
    const n = grid.length;
    let count = 0;
    
    const rows = grid.map(row => row.join(','));

    const columns: string[] = [];
    for (let j = 0; j < n; j++) {
        let column: number[] = [];
        for (let i = 0; i < n; i++) {
            column.push(grid[i][j]);
        }
        columns.push(column.join(','));
    }

    for (const row of rows) {
        for (const col of columns) {
            if (row === col) {
                count++;
            }
        }
    }
    
    return count;
}
// @lc code=end


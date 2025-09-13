/*
 * @lc app=leetcode id=36 lang=typescript
 *
 * [36] Valid Sudoku
 */

// @lc code=start
function isValidSudoku(board: string[][]): boolean {


    const rows: Set<string>[] = Array.from({ length: 9 }, () => new Set());
    const cols: Set<string>[] = Array.from({ length: 9 }, () => new Set());
    const boxes: Set<string>[] = Array.from({ length: 9 }, () => new Set());

    for (let i = 0; i < 9; i++) {
        for (let j = 0; j < 9; j++) {
            const val = board[i][j];
            
            if (val === ".") continue;

            // Satır kontrolü
            if (rows[i].has(val)) return false;
            rows[i].add(val);

            // Sütun kontrolü
            if (cols[j].has(val)) return false;
            cols[j].add(val);

            // 3x3 kutu kontrolü
            const boxIndex = Math.floor(i / 3) * 3 + Math.floor(j / 3);
            if (boxes[boxIndex].has(val)) return false;
            boxes[boxIndex].add(val);
        }
    }

    return true;
};
// @lc code=end


/*
 * @lc app=leetcode id=1004 lang=typescript
 *
 * [1004] Max Consecutive Ones III
 */

// @lc code=start
function longestOnes(nums: number[], k: number): number {
    let left = 0;
    let maxLength = 0;
    let zerosCount = 0;

    for (let right = 0; right < nums.length; right++) {
        if (nums[right] === 0) {
            zerosCount++;
        }

        while (zerosCount > k) {
            if (nums[left] === 0) {
                zerosCount--;
            }
            left++;
        }

        maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength;
};
// @lc code=end


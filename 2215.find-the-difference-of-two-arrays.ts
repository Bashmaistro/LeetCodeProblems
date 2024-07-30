/*
 * @lc app=leetcode id=2215 lang=typescript
 *
 * [2215] Find the Difference of Two Arrays
 */

// @lc code=start
function findDifference(nums1: number[], nums2: number[]): number[][] {
    const set1 = new Set(nums1);
    const set2 = new Set(nums2);

    const uniqueInNums1 = Array.from(set1).filter(num => !set2.has(num));
    const uniqueInNums2 = Array.from(set2).filter(num => !set1.has(num));

    return [uniqueInNums1, uniqueInNums2];

    
};
// @lc code=end


/*
 * @lc app=leetcode id=1657 lang=typescript
 *
 * [1657] Determine if Two Strings Are Close
 */

// @lc code=start
function closeStrings(word1: string, word2: string): boolean {
    if (word1.length !== word2.length) {
        return false;
    }

    const set1 = new Set(word1);
    const set2 = new Set(word2);
    if (set1.size !== set2.size || [...set1].some(char => !set2.has(char))) {
        return false;
    }

    const getFrequency = (word: string) => {
        const frequencyMap: { [key: string]: number } = {};
        for (const char of word) {
            frequencyMap[char] = (frequencyMap[char] || 0) + 1;
        }
        return Object.values(frequencyMap).sort((a, b) => a - b);
    };

    const freq1 = getFrequency(word1);
    const freq2 = getFrequency(word2);

    for (let i = 0; i < freq1.length; i++) {
        if (freq1[i] !== freq2[i]) {
            return false;
        }
    }

    return true;
}
// @lc code=end


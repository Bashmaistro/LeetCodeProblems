/*
 * @lc app=leetcode id=394 lang=typescript
 *
 * [394] Decode String
 */

// @lc code=start
function decodeString(s: string): string {
    let countStack: number[] = [];
    let stringStack: string[] = [];
    let currentString = "";
    let currentNum = 0;

    for (let char of s) {
        if (!isNaN(Number(char))) {
            currentNum = currentNum * 10 + Number(char);
        } else if (char === '[') {
            countStack.push(currentNum);
            stringStack.push(currentString);
            currentNum = 0;
            currentString = "";
        } else if (char === ']') {
            let repeatTimes = countStack.pop()!;
            let lastString = stringStack.pop()!;
            currentString = lastString + currentString.repeat(repeatTimes);
        } else {
            currentString += char;
        }
    }

    return currentString;
};
// @lc code=end



// 88. Merge Sorted Array

// You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

// Merge nums1 and nums2 into a single array sorted in non-decreasing order.

// The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.



public class MergeSortedArray {

    public static void main(String[] args) {

        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};



        int m = 3;
        int n = 3;
        int fPointer = 0;
        int sPointer = 0;

        int[] answer = new int[m+n];



        for (int i = 0; i < m + n; i++) {

            if (m == 0 ){

                nums1= nums2;

                break;
            }if (n == 0){
                nums1= answer;
                break;
            }
            if(nums1[fPointer] <= nums2[sPointer] && fPointer < m  ){


                answer[i] = nums1[fPointer];
                fPointer++;

            }else{

                answer[i] = nums2[sPointer];
                sPointer++;
            }



        }



        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }

    }

}



// 392. Is Subsequence
// Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

// A subsequence of a string is a new string that is formed from the original string by deleting some 
// (can be none) of the characters without disturbing the relative positions of the remaining characters. 
// (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

 

// Example 1:

// Input: s = "abc", t = "ahbgdc"
// Output: true
// Example 2:

// Input: s = "axc", t = "ahbgdc"
// Output: false


/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isSubsequence = function(s, t) {
    
    
    let k=0;

    for(i=0;i<t.length;i++){
        if(t[i] == s[k]){
           
            k++;
        }
    }

    if(k == s.length){
        return true;
    }else{
        return false
    }
    
};

// 443. String Compression

// Given an array of characters chars, compress it using the following algorithm:

// Begin with an empty string s. For each group of consecutive repeating characters in chars:

// If the group's length is 1, append the character to s.
// Otherwise, append the character followed by the group's length.
// The compressed string s should not be returned separately, but instead, be stored in the input character 
// array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

// After you are done modifying the input array, return the new length of the array.

// You must write an algorithm that uses only constant extra space.


/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
        let k = 0;
 for(i=0;i<nums.length; i++){ 
        if(nums[k] == 0){
         nums.splice(k, 1);
         nums.push(0);
        }else{
           k++; 
        }

    }

};


// 443. String Compression


// Given an array of characters chars, compress it using the following algorithm:

// Begin with an empty string s. For each group of consecutive repeating characters in chars:

// If the group's length is 1, append the character to s.
// Otherwise, append the character followed by the group's length.
// The compressed string s should not be returned separately, but instead, be stored in the input 
// character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

// After you are done modifying the input array, return the new length of the array.

// You must write an algorithm that uses only constant extra space.

 

function compress(chars) {
    let writeIndex = 0;
    let readIndex = 0;
    const n = chars.length;

    while (readIndex < n) {
        const char = chars[readIndex];
        let count = 0;

        // Count the number of consecutive repeating characters
        while (readIndex < n && chars[readIndex] === char) {
            readIndex++;
            count++;
        }

        // Write the character to the writeIndex
        chars[writeIndex] = char;
        writeIndex++;

        // If the count is greater than 1, write the count as well
        if (count > 1) {
            const countStr = count.toString();
            for (const digit of countStr) {
                chars[writeIndex] = digit;
                writeIndex++;
            }
        }
    }

    // Return the new length of the array
    return writeIndex;
}

// 1679. Max Number of K-Sum Pairs


// You are given an integer array nums and an integer k.

// In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

// Return the maximum number of operations you can perform on the array.

 

var maxOperations = function(nums, k) {
    let count = 0;
    let numCount = new Map();

    // Sayıların sayısını ve indexlerini bir haritada saklayalım
    for (let i = 0; i < nums.length; i++) {
        let num = nums[i];
        let complement = k - num;

        if (numCount.has(complement) && numCount.get(complement).length > 0) {
            count++;
            numCount.get(complement).pop();
        } else {
            if (!numCount.has(num)) {
                numCount.set(num, []);
            }
            numCount.get(num).push(i);
        }
    }

    return count;
};



  
//643. Maximum Average Subarray I

// You are given an integer array nums consisting of n elements, and an integer k.

// Find a contiguous subarray whose length is equal to k that has the maximum average 

// value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findMaxAverage = function(nums, k) {
    let currentSum = 0;
    
    for (let i = 0; i < k; i++) {
        currentSum += nums[i];
    }
    
    let maxAverage = currentSum / k;
    
    for (let i = k; i < nums.length; i++) {
        currentSum += nums[i] - nums[i - k];
        let currentAverage = currentSum / k;
        if (currentAverage > maxAverage) {
            maxAverage = currentAverage;
        }
    }
    
    return maxAverage;
};



/**
 * LeetCode Problem 1493: Longest Subarray of 1's After Deleting One Element
 * Medium
 * 
 * Given a binary array nums, you should delete one element from it.
 * 
 * Return the size of the longest non-empty subarray containing only 1's in the resulting array.
 * Return 0 if there is no such subarray.
 * 
 * Example 1:
 * Input: nums = [1,1,0,1]
 * Output: 3
 * Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
 * 
 * Example 2:
 * Input: nums = [0,1,1,1,0,1,1,0,1]
 * Output: 5
 * Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
 * 
 * Example 3:
 * Input: nums = [1,1,1]
 * Output: 2
 * Explanation: You must delete one element.
 */

function longestSubarray(nums: number[]): number {
    let left = 0;
    let num_zeros = 0;
    let max_length = 0;

    for (let right = 0; right < nums.length; right++) {
        if (nums[right] === 0) {
            num_zeros += 1;
        }

        while (num_zeros > 1) {
            if (nums[left] === 0) {
                num_zeros -= 1;
            }
            left += 1;
        }

        max_length = Math.max(max_length, right - left);
    }

    return max_length;
}
/**
 * 11. Container With Most Water
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * 
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * 
 * Return the maximum amount of water a container can store.
 * 
 * Notice that you may not slant the container.
 */



function maxArea(height: number[]): number {
    let maxContainer = 0;
    let leftPointer = 0;
    let rightPointer = height.length - 1;

    while (leftPointer < rightPointer) {
        const currentHeight = Math.min(height[leftPointer], height[rightPointer]);
        const width = rightPointer - leftPointer;
        const currentArea = currentHeight * width;

        maxContainer = Math.max(maxContainer, currentArea);

        
        if (height[leftPointer] < height[rightPointer]) {
            leftPointer++;
        } else {
            rightPointer--;
        }
    }

    return maxContainer;
};










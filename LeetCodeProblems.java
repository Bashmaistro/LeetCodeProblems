
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





















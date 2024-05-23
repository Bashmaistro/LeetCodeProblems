
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

/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/intersection-of-two-arrays
@Language: Java
@Datetime: 16-09-13 22:20
*/

public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        // Arrays.sort(nums1);
        // Arrays.sort(nums2);
        
        // int[] temp = new int[nums1.length];
        
        // int i = 0, j = 0;
        // int index = 0;
        // while(i < nums1.length && j < nums2.length){
        //     if(nums1[i] == nums2[j]){
        //         if(index == 0 || temp[index - 1] != nums1[i]){
        //             temp[index] = nums1[i];
        //             index++;
        //         }
        //         i++;
        //         j++;
        //     }
        //     else if(nums1[i] < nums2[j]){
        //         i++;
        //     }else{
        //         j++;
        //     }
        // }
        
        // int[] result = new int[index];
        // for(int k = 0; k < index; k++){
        //     result[k] = temp[k];
        // }
        // return result;
        
        /*
        hastSet
        */
        
//         if(nums1 == null || nums2 == null){
// 			return null;
// 		}
		
// 		HashSet<Integer> hash = new HashSet<>();
// 		for(int i = 0; i < nums1.length; i++){
// 			hash.add(nums1[i]);
// 		}
		
// 		HashSet<Integer> result = new HashSet<>();
// 		for(int i = 0; i < nums2.length; i++){
// 			if(hash.contains(nums2[i]) && !result.contains(nums2[i])){
// 				result.add(nums2[i]);
// 			}
// 		}
// 		int size = result.size();
		
// 		int[] resultArray = new int[size];
// 		int index = 0;
// 		for(int i : result){
// 			resultArray[index++] = i;
// 		}
// 		return resultArray;

        if (nums1 == null || nums2 == null) {
            return null;
        }
        
        HashSet<Integer> set = new HashSet<>();
        
        Arrays.sort(nums1);
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                continue;
            }
            if (binarySearch(nums1, nums2[i])) {
                set.add(nums2[i]);
            }
        }
        
        int[] result = new int[set.size()];
        int index = 0;
        for (Integer num : set) {
            result[index++] = num;
        }
        
        return result;
    }
    
     private boolean binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (nums[start] == target) {
            return true;
        }
        if (nums[end] == target) {
            return true;
        }
        
        return false;
    }
}
# coding:utf-8
'''
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/maximum-subarray-iii
@Language: Python
@Datetime: 16-10-19 14:20
'''

class Solution:
    """
    @param nums: A list of integers
    @param k: An integer denote to find k non-overlapping subarrays
    @return: An integer denote the sum of max k non-overlapping subarrays
    """
    def maxSubArray(self, nums, k):
        # write your code here
        if not nums:
            return 0

        n = len(nums)
        localMax = [[-sys.maxint for i in range(k + 1)] for i in range(n + 1)]
        globalMax = [[-sys.maxint for i in range(k + 1)] for i in range(n + 1)]

        # è¾¹çåå§å
        for k in range(k + 1):
            localMax[k][0] = globalMax[k][0] = 0

        for i in range(1, n + 1):
            # è¾¹çåå§å
            localMax[i][0] = 0
            globalMax[i][0] = 0
            for k in range(1, k + 1):
                localMax[i][k] = max(localMax[i - 1][k] + nums[i - 1], globalMax[i - 1][k - 1] + nums[i - 1])
                globalMax[i][k] = max(globalMax[i - 1][k], localMax[i][k])

        return globalMax[n][k]
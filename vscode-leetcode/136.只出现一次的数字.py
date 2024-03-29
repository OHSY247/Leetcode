#
# @lc app=leetcode.cn id=136 lang=python3
#
# [136] 只出现一次的数字
#
# https://leetcode-cn.com/problems/single-number/description/
#
# algorithms
# Easy (70.67%)
# Likes:    1684
# Dislikes: 0
# Total Accepted:    331.2K
# Total Submissions: 467.9K
# Testcase Example:  '[2,2,1]'
#
# 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
# 
# 说明：
# 
# 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
# 
# 示例 1:
# 
# 输入: [2,2,1]
# 输出: 1
# 
# 
# 示例 2:
# 
# 输入: [4,1,2,1,2]
# 输出: 4
# 
#
from typing import List
from functools import reduce
# @lc code=start
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        # return reduce(lambda x,y:x^y, nums)
        sum1 = sum(nums)
        sum2 = 2*sum(set(nums))
        return sum2 - sum1
# @lc code=end


#
# @lc app=leetcode.cn id=102 lang=python3
#
# [102] 二叉树的层序遍历
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.res  = []
        
    def dfs(self, root):
        if not root:return []
    
    # 暴力法
    def brute(self, root):
        # Time Limit Exceeded
        stack = [root]
        while stack and root:
            tmp = []
            _res = []
            for _ in stack:
                _res.append(_.val)
                print(_)
                if _.left:tmp.append(_.left)
                if _.right:tmp.append(_.right)
            stack = tmp
            self.res.append(_res)
        return self.res
    
    def queue(self, root):
        # 队列
        import collections
        queue = collections.deque()
        queue.append(root)
        res = []
        while queue:
            size = len(queue)
            level = []
            for _ in range(size):
                cur = queue.popleft()
                if not cur:
                    continue
                level.append(cur.val)
                queue.append(cur.left)
                queue.append(cur.right)
            if level:
                res.append(level)
        return res

        
        
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        return self.queue(root)
# @lc code=end


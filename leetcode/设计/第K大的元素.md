# leetcode 215 第K大的元素

在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:

输入: [3,2,1,5,6,4] 和 k = 2

输出: 5

示例 2:

# 解法一：O(nlogk)

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : nums) {
            queue.add(i);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }
}
```

# 解法二：快速选择 O(n)



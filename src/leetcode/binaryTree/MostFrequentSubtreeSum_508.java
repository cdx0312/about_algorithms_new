package leetcode.binaryTree;

import leetcode.stack.TreeNode;

import java.util.*;

/**
 * @program: about_algorithms
 * @description: ${description}
 * @author: cdx
 * @create: 2018-08-26 16:31
 **/
public class MostFrequentSubtreeSum_508 {
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null)
            return new int[0];
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        Integer max = Integer.MIN_VALUE;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null) {
                stack.push(node.right);
            }
            int sum = getTreeSum(node);
            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
            max = max > map.get(sum) ? max : map.get(sum);
        }
        List<Integer> list = new ArrayList<>();
        for (Integer i : map.keySet()) {
            if (map.get(i) == max) {
                list.add(i);
            }
        }
        int[] res = new int[list.size()];
        int j = 0;
        for (Integer i : list) {
            res[j++] = i;
        }
        return res;
    }

    private int getTreeSum (TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return root.val;
        return root.val + getTreeSum(root.left) + getTreeSum(root.right);
    }

    public static void main(String[] args) {

    }
}

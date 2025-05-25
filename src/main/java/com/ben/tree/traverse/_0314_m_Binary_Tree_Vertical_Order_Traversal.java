package com.ben.tree.traverse;

import com.ben.common.PrintUtil;
import com.ben.common.TreeNode;
import com.ben.common.TreeUtil;

import java.util.*;

public class _0314_m_Binary_Tree_Vertical_Order_Traversal {

    public static void main(String[] args) {
//        TreeNode root = TreeUtil.createTree(3, 9, 20, null, null, 15, 7);
//        TreeNode root = TreeUtil.createTree(3, 9, 8, 4, 0, 1, 7);
        TreeNode root = TreeUtil.createTree(3, 9, 8, 4, 0, 1, 7, null, null, 5, null, null, 2, null, null);

        PrintUtil.printListOfList(new Solution().verticalOrder(root));
    }

    static
    public class Solution {
        public List<List<Integer>> verticalOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }

            Map<Integer, LinkedList> map = new TreeMap<>();
            helper(root, map, 0);

            List<List<Integer>> res = new ArrayList<>();
            for (LinkedList queue : map.values()) {
                res.add(new ArrayList<>(queue));
            }

            return res;
        }

        private void helper(TreeNode root, Map<Integer, LinkedList> map, int idx) {
            LinkedList queue = map.get(idx);
            if (queue == null) {
                queue = new LinkedList();
                map.put(idx, queue);
            }
            queue.add(root.val);

            if (root.left != null) {
                helper(root.left, map, idx - 1);
            }
            if (root.right != null) {
                helper(root.right, map, idx + 1);
            }
        }
    }
}

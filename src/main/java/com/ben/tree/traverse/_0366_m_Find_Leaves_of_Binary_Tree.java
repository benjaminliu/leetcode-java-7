package com.ben.tree.traverse;

import com.ben.common.PrintUtil;
import com.ben.common.TreeNode;
import com.ben.common.TreeUtil;

import java.util.*;

public class _0366_m_Find_Leaves_of_Binary_Tree {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.createTree(1, 2, 3, 4, 5);
//        TreeNode root = TreeUtil.createTree(1, 2, 3);
        PrintUtil.printListOfList(new Solution2().findLeaves(root));
    }

    static class Solution {
        public List<List<Integer>> findLeaves(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }

            Map<TreeNode, TreeNode> map = new HashMap<>();
            LinkedList<TreeNode> queue = new LinkedList<>();

            queue.add(root);
            map.put(root, root);

            traverse(root, queue, map);

            List<List<Integer>> res = new ArrayList<>();

            while (!queue.isEmpty()) {
                int size = queue.size();

                List<Integer> group = new ArrayList<>();
                while (size > 0) {
                    TreeNode tmp = queue.poll();
                    size--;
                    if (tmp.left != null || tmp.right != null) {
                        queue.offer(tmp);
                    } else {
                        group.add(tmp.val);

                        TreeNode parent = map.remove(tmp);
                        if (parent.left == tmp) {
                            parent.left = null;
                        } else {
                            parent.right = null;
                        }
                    }
                }
                res.add(group);
            }
            return res;
        }

        private void traverse(TreeNode root, LinkedList<TreeNode> queue, Map<TreeNode, TreeNode> map) {
            if (root.left != null) {
                map.put(root.left, root);
                queue.add(root.left);
                traverse(root.left, queue, map);
            }

            if (root.right != null) {
                map.put(root.right, root);
                queue.add(root.right);
                traverse(root.right, queue, map);
            }
        }
    }

    static
    public class Solution2 {
        public List<List<Integer>> findLeaves(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();

            postOrderTraverse(root, res);

            return res;
        }

        private int postOrderTraverse(TreeNode root, List<List<Integer>> res) {
            if (root == null) {
                return -1;
            }

            int left = postOrderTraverse(root.left, res);
            int right = postOrderTraverse(root.right, res);

            int curHeight = Math.max(left, right) + 1;

            if (res.size() == curHeight) {
                res.add(new ArrayList<>());
            }

            res.get(curHeight).add(root.val);

            return curHeight;
        }
    }
}
